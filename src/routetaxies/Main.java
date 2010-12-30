/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import org.w3c.dom.Document;

/**
 *
 * @author seth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strFilename = "out.xml";
        //MapModel.download_map(23.91, 49.76, 24.1, 49.82, strFilename);
        Document doc = MapModel.parse(strFilename);
        if (doc != null)
            
    }

}
