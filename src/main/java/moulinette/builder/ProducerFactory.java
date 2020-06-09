/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import moulinette.DAO.FileDAOObject;
import moulinette.element.Enum.EnumContactPersonRoles;
import moulinette.element.Enum.EnumFundingTypes;
import moulinette.element.dataset.Contact;
import moulinette.element.dataset.OnlineResource;
import moulinette.element.dataset.Person;
import moulinette.element.dataset.Webservice;
import moulinette.element.producer.Funding;
import moulinette.element.producer.Producer;

/**
 * Import information about a provider of datasets using an external CSV file
 *
 * @see Producer
 *
 * @author coussotc
 */
public class ProducerFactory extends FileDAOObject {
    
    /**
     * Instanciate a Producer Object using the information from an external CSV
     * file
     *
     * @param pathToCSVSourceFile the path to the folder containing the CSV file
     * @return a Producer Object
     * @throws IOException
     * @see Producer
     */
    public static Producer buildProducer(String pathToCSVSourceFile) throws IOException {

//        System.out.println("Début producer");

        // Declaration of the different fields of the Producer Object
        String name, resume, url, title, email;
        ArrayList<ArrayList<String>> producerCSV = new ArrayList<>();
        // Read the external CSV file 
        producerCSV = ProducerFactory.readCSV(pathToCSVSourceFile + "/Producer_snot.csv", ";");
        //Set the fields using information from the CSV file
        name = producerCSV.get(0).get(1);
        title = producerCSV.get(1).get(1);
        resume = producerCSV.get(2).get(1);
        email = producerCSV.get(2).get(2);
        /**
         * Instanciation of the onlineResource object
         */
        OnlineResource onlineResource = new OnlineResource();
        
        //Fifi       
        Optional.ofNullable(producerCSV)
                .map(producercsv -> producercsv.get(3))
                .ifPresent((urlressource) -> {
                    List<Webservice> webservices = new ArrayList<>();
                    for (int i = 1; i < urlressource.size(); i++) {
                        String value = urlressource.get(i);
                        if (value == null || "".equals(value)) {
                            continue;
                        }
                        switch (i) {
                            case 1:
                                onlineResource.setUrlDownload(value);
                                break;
                            case 2:
                                onlineResource.setUrlInfo(value);
                                break;
                            case 3:
                                onlineResource.setDoi(value);
                                break;
                            default:
                                String[] webTmp = value.split("\\|");
                                if (webTmp.length < 2) {
                                    continue;
                                }
                                Webservice webservice = new Webservice(webTmp[0], webTmp[1]);
                                webservices.add(webservice);
                        }
                        // JBP :  Pour le moment, pas de webservices
                        //onlineResource.setWebservices(webservices);
                    }

                });
        
                /**
         * Instanciation of Webservice object for the onlineResource attribute
         */
//        List<Webservice> webservices = new ArrayList<>();
//        for (String p : producerCSV.get(3).subList(4, producerCSV.get(3).size())) {
//            String[] webTmp = p.split("\\|");
//            Webservice webservice = new Webservice(webTmp[0], webTmp[1]);
//            webservices.add(webservice);
//        }
//        onlineResource.setWebservices(webservices);
        
        //System.out.println("Début instanciationFundingObject");
        ArrayList<Funding> fundings = instanciationFundingObject(producerCSV);
        //System.out.println("Fin instanciationFundingObject");
        
        List<Contact> contacts = instanciationContactsAttribute(producerCSV);

        Producer producer = new Producer("TOUR", name, resume, fundings, contacts);
        producer.setEmail(email);
        producer.setTitle(title);
        producer.setOnlineResource(onlineResource);
        
//        System.out.println("Fin producer");

        return producer;
    }

    /**
     * Instanciation of contacts attribute
     */
    private static List<Contact> instanciationContactsAttribute(ArrayList<ArrayList<String>> producerCSV) {
        List<Contact> contacts = new ArrayList<>();
        Contact c1 = new Person(producerCSV.get(4).get(1), producerCSV.get(4).get(2), producerCSV.get(4).get(3), EnumContactPersonRoles.PROJECT_LEADER);
        Contact c2 = new Person(producerCSV.get(5).get(1), producerCSV.get(5).get(2), producerCSV.get(5).get(3), EnumContactPersonRoles.DATA_MANAGER);
        contacts.add(c1);
        contacts.add(c2);
        return contacts;
    }

    /**
     * Instanciation of funding object
     */
    private static ArrayList<Funding> instanciationFundingObject(ArrayList<ArrayList<String>> producerCSV) {
        ArrayList<Funding> fundings = new ArrayList<>();
        for (ArrayList<String> p : producerCSV.subList(6, producerCSV.size())) {
            EnumFundingTypes type = EnumFundingTypes.valueOf(p.get(0).toUpperCase());
                               
            for (String s : p.subList(1, p.size())) {
                
                String[] tmp = s.split("\\|");
//                System.out.println("----");
//                System.out.println(tmp[0].trim());
//                System.out.println(tmp[1].trim());
//                System.out.println(tmp[2].trim());
//                System.out.println(tmp[3].trim());
                String acronym = "";
                if (tmp.length > 1) {
                    acronym = tmp[1].trim();
                }               
                Funding funding = new Funding(type,acronym);
                funding.setName(tmp[0].trim());
                if (!tmp[2].trim().isEmpty()) {
                    funding.setIdScanR(tmp[2].trim());
                }
                funding.setIso3166(tmp[3].trim());
                fundings.add(funding);
//                System.out.println("----");
            }
        }
        return fundings;
    }
}
