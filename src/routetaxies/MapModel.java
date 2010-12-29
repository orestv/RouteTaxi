/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seth
 */
public class MapModel {
    private static String STR_XAPI_URL = "http://www.informationfreeway.org/api/0.6/map?bbox=%2.2f,%2.2f,%2.2f,%2.2f";
    
    public static void download_map(double nLeft, double nBottom, double nRight, double nTop){
        String strUrl = String.format(Locale.UK, STR_XAPI_URL, nLeft, nBottom, nRight, nTop);
        try {
            URL u = new URL(strUrl);
            InputStream is = null;
            is = u.openStream();
            int nChunkSize = 0, nTotalRead = 0;
            char[] buf = new char[1];
            Reader rdr = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            Writer wr = new BufferedWriter(new FileWriter("out.xml", false));
            while ((nChunkSize = rdr.read(buf)) != -1){
                nTotalRead += nChunkSize;
                wr.write(buf);
            }
            wr.close();
            
        } catch (IOException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
