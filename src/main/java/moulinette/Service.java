package moulinette;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import javax.annotation.PostConstruct;
import com.rac021.jax.api.qualifiers.security.Public;
import com.rac021.jax.api.qualifiers.ServiceRegistry;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import moulinette.builder.MetadataFabrique;
import moulinette.builder.ObservationFabrique;
import moulinette.builder.ProducerFactory;
import moulinette.element.PivotFormat;
import moulinette.element.dataset.Dataset;
import moulinette.element.dataset.Metadata;
import moulinette.element.producer.Producer;
import moulinette.element.observation.Observation;
import moulinette.jpa.JPAQueryDAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Jb Paroissien
 */
@ServiceRegistry("pivot")
@Public
/* @Secured(policy = Policy.CustomSignOn) */

public class Service {

//    public static final String INPUT_FILE_PATH = "/src/main/resources/inputs_files";
// public static final String INPUT_FILE_PATH = "/home/jbparoissien/sie-sno-tourbiere/Developpement/SI/app_snot/Connexion/src/main/resources/inputs_files/";
//    public static final String INPUT_FILE_PATH = "/home/tomcat/devel/dev/Developpement/SI/app_snot/Connexion/src/main/resources/inputs_files";
//    public static final String INPUT_FILE_PATH = "/home/tomcat/devel/si-snot/Developpement/SI/app_snot/Connexion/src/main/resources/inputs_files";
public static final String INPUT_FILE_PATH = "src/main/resources/inputs_files/";
//    @Inject
//    @ResourceRegistry("resourcePivot")
//    Resource Resource;
//    @Inject
//    MetadataFactory metadataFactory;
    @Context
    /* Optionnal */
    UriInfo uriInfo;

    @Inject
    MetadataFabrique metadataFabrique;

    @Inject
    ObservationFabrique observationFabrique;

    @Inject
    protected JPAQueryDAO requeteDAO;

//    @Inject
//    StreamerOutputXml streamerOutputXml;
//
//    @Inject
//    StreamerOutputJson streamerOutputJson;
//
//    @Inject
//    StreamerOutputXmlEncrypted streamerOutputXmlEncrypted;
//
//    @Inject
//    StreamerOutputJsonEncrypted streamerOutputJsonEncrypted;
    @PostConstruct
    public void init() {
    }

    public Service() {
    }

    @GET
    @Produces(value = MediaType.TEXT_PLAIN)
    public Response getString(@DefaultValue("lgt-ges-eddycovariance") @QueryParam("codes_jeu") String codesJeu) {

        String REST_URI = "http://localhost:8081/rest/resources/pivot";

//        System.out.println("codesJeu=" + codesJeu);
        Client client = ClientBuilder.newClient();
        String get = client
                .target(REST_URI)
                .queryParam("codes_jeu", codesJeu)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

//        System.out.println(get);
        return Response.ok(get).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public String getJson(@DefaultValue("lgt-ges-eddycovariance") @QueryParam("codes_jeu") String codesJeu) {

        try {
            if (codesJeu.contentEquals("all")) {
                final List<String> realNodesVariablePath = requeteDAO.getAllRealNodePaths();

                System.out.println("Tous les JDD du SNO-T");

                Map<String, List<String>> codes = new HashMap<>();
//                final String[] realNodesVariablePath = codesJeu.split("@@");
                for (int i = 0; i < realNodesVariablePath.size(); i++) {
                    String realNodeVariablePath = realNodesVariablePath.get(i);
                    //final String codeJeu = realNodesVariablePath.get(i).replaceAll("^(.*)\\/(.*),(.*),(.*)_(.*),(.*)", "$1-$3-$4");
                    codes
                            .computeIfAbsent(codesJeu, k -> new LinkedList())
                            .add(realNodeVariablePath);
//                    System.out.println("codeJeu : " + codesJeu);
//                    System.out.println("realNodeVariablePath : " + realNodeVariablePath);
                }
                return getPivot(codes);
            } else if (codesJeu != null & !codesJeu.contentEquals("all")) {
                final List<String> realNodesVariablePath = requeteDAO.getRealNodePaths(codesJeu);;
                System.out.println("codeJeu : " + codesJeu);

                Map<String, List<String>> codes = new HashMap<>();
//                final String[] realNodesVariablePath = codesJeu.split("@@");
                for (int i = 0; i < realNodesVariablePath.size(); i++) {
                    String realNodeVariablePath = realNodesVariablePath.get(i);
                    //final String codeJeu = realNodesVariablePath.get(i).replaceAll("^(.*)\\/(.*),(.*),(.*)_(.*),(.*)", "$1-$3-$4");
                    codes
                            .computeIfAbsent(codesJeu, k -> new LinkedList())
                            .add(realNodeVariablePath);

//                    System.out.println("codeJeu : " + codesJeu);
//                    System.out.println("realNodeVariablePath : " + realNodeVariablePath);
                }
                return getPivot(codes);
            } else {
                return null;
            }
        } catch (IOException ex) {
            return null;
        }

    }

    private String getPivot(Map<String, List<String>> codes) throws IOException {

        /**
         * Set input files folder
         */
        Path currentRelativePath = Paths.get("");
        /**
         * output files folder is set using args[0]
         */
        File file = new File(INPUT_FILE_PATH);
        final String inputSourcesFolder = file.getAbsolutePath();

        /**
         * Extracting the provider metadata from external CSV file
         */
        Producer producer = ProducerFactory.buildProducer(inputSourcesFolder);

//        System.out.println("codes = " + codes);
        List<Dataset> datasets = getDataset(inputSourcesFolder, codes);

        /*
        Create the pivotFormat objet to store all the information about SNO-T and its datasets
         */
        PivotFormat pivotFormat = new PivotFormat(producer, datasets);

        //Modif pour supprimer la serialization des nulls
        /**
         * Instance of a JSON builder to parse the pivotFormat into a JSON file
         */
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        String pivotFormatJson = gson.toJson(pivotFormat);

        return pivotFormatJson;

    }

    private List<Dataset> getDataset(String inputSourcesFolder, Map<String, List<String>> codes) throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        List<Dataset> datasets = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : codes.entrySet()) {
            String codeJeu = entry.getKey();
            System.out.println("********************************getDataset********************************");
            if (codeJeu.contentEquals("all")) {
                System.out.println("********************************Build ALL********************************");
                final List<String> allCodesJeu = requeteDAO.getAllCodesJeu();            
//                List<String> variables = entry.getValue();
                for (String all : allCodesJeu) {
                    List<String> variables = requeteDAO.getRealNodePaths(all);
                    System.out.println("--variables-- = " + variables);

                    System.out.println("codesJeu in loop= " + all);
                    Metadata metadata = metadataFabrique.buildMetadata(all, inputSourcesFolder);
                    List<Observation> observations = new LinkedList();
                    for (String variable : variables) {
                        System.out.println("variable in loop= " + variable);
                        Observation observation = observationFabrique.buildObservation(all, variable, inputSourcesFolder);
                        observations.add(observation);
                    }
                    datasets.add(new Dataset("TOUR_DAT_" + all, metadata, observations));
                }
            } else {
                System.out.println("codesJeu = " + codeJeu);
                List<String> variables = entry.getValue();
                Metadata metadata = metadataFabrique.buildMetadata(codeJeu, inputSourcesFolder);
                List<Observation> observations = new LinkedList();
                for (String variable : variables) {
                    Observation observation = observationFabrique.buildObservation(codeJeu, variable, inputSourcesFolder);
                    observations.add(observation);
                }
                datasets.add(new Dataset("TOUR_DAT_" + codeJeu, metadata, observations));
            }
        }

        return datasets;
    }
}
