/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.util.Locale;

/**
 *
 * @author seth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MapModel.download_map(23.91, 49.76, 24.1, 49.82);
        //MapModel.download_map(11.54,48.14,11.543,48.145);
    }

}
