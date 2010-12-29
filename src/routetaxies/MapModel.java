/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seth
 */
public class MapModel {
    private static String STR_XAPI_URL = "http://www.informationfreeway.org/api/0.6/map/bbox=%f,%f,%f,%f";
    private static void download_map(float nLeft, float nBottom, float nRight, float nTop){
        float[] arrBounds = new float[] {nLeft, nBottom, nRight, nTop};
        download_map(arrBounds);
    }

    private static void download_map(float[] arrBounds){
        String strUrl = String.format(Locale.UK, STR_XAPI_URL, arrBounds);
        try {
            URL u = new URL(strUrl);
            InputStream is = null;
            is = u.openStream();
            
        } catch (IOException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
