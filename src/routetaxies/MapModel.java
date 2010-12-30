/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author seth
 */
public class MapModel {
    private static String STR_XAPI_URL = "http://www.informationfreeway.org/api/0.6/map?bbox=%2.2f,%2.2f,%2.2f,%2.2f";
    
    public static boolean download_map(double nLeft, double nBottom, double nRight, double nTop, String strFilename){
        String strUrl = String.format(Locale.UK, STR_XAPI_URL, nLeft, nBottom, nRight, nTop);
        try {
            URL u = new URL(strUrl);
            InputStream is = null;
            is = u.openStream();
            int nChunkSize = 0, nTotalRead = 0;
            int c;
            Reader rdr = new InputStreamReader(is, "UTF-8");
            Writer wr = new BufferedWriter(new FileWriter(strFilename, false));
            StringBuilder sb = new StringBuilder();
            while ((c = rdr.read()) != -1)
            {
                sb.append((char)c);
                nTotalRead++;
                if (nTotalRead % 100 == 0)
                    System.out.println("Total characters read: " + Integer.toString(nTotalRead));
            }
            wr.write(sb.toString());
            wr.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static Document parse(String strFilename){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new FileInputStream(strFilename));
            return doc;            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean parseMap(String strFilename){
        DOMParser parser = new DOMParser();
        InputStream in = null;
        try {
            in = new FileInputStream(strFilename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        InputSource src = new InputSource(in);
        try {
            parser.parse(src);
            in.close();
        } catch (SAXException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(MapModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        Document doc = parser.getDocument();
        Node n =  doc.getDocumentElement()
                .getChildNodes().item(0);
        //NodeList nodes = doc.getElementsByTagName("node");
        return true;
    }

}
