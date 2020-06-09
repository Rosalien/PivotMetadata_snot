/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.DAO;

import moulinette.exceptions.CSVImportException;
import moulinette.element.Enum.EnumTopicCategories;
import moulinette.element.Enum.EnumInspireThemes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author coussotc
 */
public class ThematicCategoryInspireKeywordDAO extends FileDAOObject {

    /**
     * Serach EnumInspireThemes enumeration value in a CSV file for a dataset
     * and return the values found for the dataset. Values are in the same
     * column separated by ","
     *
     * @param datasetId int - id of the dataset
     * @param pathToCSVSourceFiles String - path to the CSV file
     * @return ArrayList of the value of the thematicCategories found in the CSV
     * file
     * @throws CSVImportException
     * @throws IOException
     */
    public static ArrayList<String> setTopicCategoriesCSV(String datasetId, String pathToCSVSourceFiles) throws CSVImportException, IOException {
        ArrayList<ArrayList<String>> topicCategoriesCSV = new ArrayList<>();
        topicCategoriesCSV = readCSV(pathToCSVSourceFiles + "/INSPIREThematicAndKeyword.csv", ";");
        ArrayList<String> topicCategories = new ArrayList<>();
        for (String s : topicCategoriesCSV.get(1).get(1).split(", ")) {
            String enumeration = null;
            enumeration = EnumTopicCategories.valueOf(s).toString();
            if (enumeration != null) {
                topicCategories.add(enumeration);
            } else {
                throw new EnumConstantNotPresentException(EnumTopicCategories.class, s);
            }
        }
        return topicCategories;
    }

    /**
     * Serach EnumTopicCategories enumeration value in a CSV file for a dataset
     * and return the value found for the dataset.
     *
     * @param datasetId int - id of the dataset
     * @param pathToCSVSourceFiles String - path to the CSV file
     * @return ArrayList of the value of the thematicCategories found in the CSV
     * file
     * @throws CSVImportException
     * @throws IOException
     */
    public static String setInspireTheme(String datasetId, String pathToCSVSourceFiles) throws CSVImportException, IOException {
        ArrayList<ArrayList<String>> inspireKeywordCSV = new ArrayList<>();
        inspireKeywordCSV = readCSV(pathToCSVSourceFiles + "/INSPIREThematicAndKeyword.csv", ";");
        
        String enumeration = EnumInspireThemes.valueOf(inspireKeywordCSV.get(1).get(2)).toString();   
        //String enumeration = EnumInspireThemes.valueOf(inspireKeywordCSV.get(datasetId).get(2)).toString();
        if (enumeration == null) {
            throw new EnumConstantNotPresentException(EnumInspireThemes.class, enumeration);
        }
        return enumeration;
    }
}
