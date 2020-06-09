/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exception class that can be thrown during during CSV import
 * @author coussotc
 */
public class CSVImportException extends Exception {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSVImportException.class);

    public CSVImportException() {
    }
    
    public String getMessageDataDatasetNotFound() {
        LOGGER.error("The dataset was not found in the file.");
        return "The dataset was not found in the file.";
    }
}

