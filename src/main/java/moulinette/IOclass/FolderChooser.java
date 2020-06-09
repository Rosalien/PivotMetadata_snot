/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.IOclass;

import javax.swing.JFileChooser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to call a folder chooser interface
 * @author coussotc
 */
public class FolderChooser {
    private static final Logger LOGGER = LoggerFactory.getLogger(FolderChooser.class);
    
    /**
     * Call a JFileChooser in order for the user to choose a folder.
     * @return the path of the choosen folder
     * @see JFileChooser
     */
    public static String getFolder(String title) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            LOGGER.info("No folder choosen - exiting program.");
//            System.out.println("Extract canceled.\n");
            System.exit(0);
        }
        LOGGER.info("Selected folder :"+chooser.getSelectedFile().getPath());
        return chooser.getSelectedFile().getPath();
    }
}
