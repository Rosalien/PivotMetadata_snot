/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.LoggerFactory;
        
/**
 * Abstract class to provide reader from a CSV file
 *
 * @author coussotc
 */
public abstract class FileDAOObject {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileDAOObject.class);
        
    /**
     * Read a CSV file. Each line of the CSV file are stored into an ordered
     * list. The elements of this list are ordered list of cells.
     *
     * @param fileLocation the path of the CSV file
     * @param separator the value separator of the CSV file
     * @return ArrayList of ArrayList of String object that store the values of the CSV
     * file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<ArrayList<String>> readCSV(String fileLocation, String separator) throws FileNotFoundException, IOException {
        String line = null;
        //Charset charset = StandardCharsets.ISO_8859_1;
        Charset charset = StandardCharsets.UTF_8;
        ArrayList<ArrayList<String>> CSVFields = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(fileLocation)), charset))) {
            logger.info("Accessing file : " + fileLocation);
            while ((line = br.readLine()) != null) {
                /**
                 * The line initially encoded in ISO 8859-1 is converted to UTF-8
                 */
                //String[] fields = convertIsoToUtf8(line).split(separator);
                String[] fields = line.split(separator);
//                System.out.println("line : "+line+"\n fiels :"+fields.length);
                CSVFields.add(new ArrayList<>(Arrays.asList(fields)));
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            System.exit(1);
        }
        return CSVFields;
    }

    /**
     * The String  value of the file needs to be stored in UTF-8. If the file in encoded in ISO8859-1, this function can
     * used to convert each line of the file in utf-8
     * @param valueIso String encoded in ISO8859-1
     * @return String encoded in UTF-8
     * @throws UnsupportedEncodingException 
     */
    private static String convertIsoToUtf8(String valueIso) throws UnsupportedEncodingException {
        byte[] iso8859bytes;
        byte[] utf8bytes;
        iso8859bytes = valueIso.getBytes(StandardCharsets.ISO_8859_1);
        utf8bytes = new String(iso8859bytes, StandardCharsets.ISO_8859_1).getBytes(StandardCharsets.UTF_8);
        String valueUtf8 = new String(utf8bytes, StandardCharsets.UTF_8);
        return valueUtf8;
    }
}