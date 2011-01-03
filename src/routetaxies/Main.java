/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package routetaxies;

import javax.swing.SwingUtilities;
import org.w3c.dom.*;

/**
 *
 * @author seth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MainWindow w = new MainWindow();
            }
        });
        
        String strFilename = "out.xml";
        //MapModel.download_map(23.91, 49.76, 24.1, 49.82, strFilename);
        //Document doc = MapModel.parse(strFilename);
        //MapModel.getWaysFromDocument(doc);
        /*
        if (doc != null) {
            System.out.println(doc.getElementsByTagName("node").getLength());
            NodeList lstNodes = doc.getElementsByTagName("node");
            for (int i = 0; i < lstNodes.getLength(); i++) {
                Node n = lstNodes.item(i);
                double nLat, nLon;
                nLat = Double.parseDouble(n.getAttributes().getNamedItem("lat").getNodeValue());
                nLon = Double.parseDouble(n.getAttributes().getNamedItem("lon").getNodeValue());
            }

        }
*/
    }
}
