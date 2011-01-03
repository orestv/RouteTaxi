/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author seth
 */
public class MapModel {
    private static String STR_XAPI_URL = "http://www.informationfreeway.org/api/0.6/map?bbox=%2.2f,%2.2f,%2.2f,%2.2f";

    Document doc = null;
    private ArrayList<MapWay> ways = null;

    public MapModel(String strFilename){
        doc = parse(strFilename);
        if (doc == null)
            MapModel.downloadMap(23.91, 49.76, 24.1, 49.82, strFilename);
        doc = parse(strFilename);
        ways = getWaysFromDocument(doc);
    }
    
    public static boolean downloadMap(double nLeft, double nBottom, double nRight, double nTop, String strFilename){
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
            File f = new File(strFilename);
            if (!f.exists())
                return null;
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

    public static ArrayList<MapWay> getWaysFromDocument(Document doc){
        NodeList xmlWays = doc.getElementsByTagName("way");
        ArrayList<MapWay> lsWays = new ArrayList<MapWay>();
        NodeList xmlNodes = doc.getElementsByTagName("node");
        HashMap<Long, Node> hmapXmlNodes = new HashMap<Long, Node>();
            System.out.println(Calendar.getInstance().getTimeInMillis());
        for (int i = 0; i < xmlNodes.getLength(); i++){            
            Node n = xmlNodes.item(i);
            Long id = Long.parseLong(n.getAttributes().getNamedItem("id").getNodeValue());
            hmapXmlNodes.put(id, n);             
        }
            System.out.println(Calendar.getInstance().getTimeInMillis());
            System.out.println();

        for (int i = 0; i < xmlWays.getLength(); i++){
            Node xmlWay = xmlWays.item(i);
            NodeList children = xmlWay.getChildNodes();
            ArrayList<MapNode> mapNodes = new ArrayList<MapNode>();
            String name = "";
            long id;
            id = Long.parseLong(xmlWay.getAttributes().getNamedItem("id").getNodeValue());

            for (int j = 0; j < children.getLength(); j++){
                Node child = children.item(j);

                if (child.getNodeName().equals("nd")){
                    Long nNodeId = Long.parseLong(child.getAttributes().getNamedItem("ref").getNodeValue());
                    Node N = null;
                    N = hmapXmlNodes.get(nNodeId);

                    //Node N = doc.getElementById(Long.toString(nNodeId));
                    if (N != null){
                        MapNode childNode = MapNode.fromXMLNode(N);
                        mapNodes.add(childNode);
                    }
                }

                else if(child.getNodeName().equals("tag")){
                    String key, value;
                    key = child.getAttributes().getNamedItem("k").getNodeValue();
                    value = child.getAttributes().getNamedItem("v").getNodeValue();

                    if (key.equals("name")){
                        name = value;
                    }
                }
            }
            lsWays.add(new MapWay(id, name, mapNodes));
        }

        return lsWays;
        /*
        NodeList nodes = doc.getElementsByTagName("node");
        ArrayList<MapNode> lstNodes = new ArrayList<MapNode>();
        Calendar cal = Calendar.getInstance();
        long nMilStart = cal.getTimeInMillis();
        System.out.println(String.format("Creating nodelist... %d", nMilStart));
        for (int i = 0; i < nodes.getLength(); i++){
            Node xmlNode = nodes.item(i);
            MapNode mapNode = MapNode.fromXMLNode(xmlNode);
            lstNodes.add(mapNode);
        }
        cal = Calendar.getInstance();
        long nMilEnd = cal.getTimeInMillis();
        System.out.println(String.format("Nodelist created! %d", nMilEnd));
        int nNodeListSize = lstNodes.size();
        System.out.println(String.format("Found %d nodes in %d - %d = %d milliseconds", nNodeListSize, nMilEnd, nMilStart, (nMilEnd - nMilStart)));
        return true;
         */
    }

    public static ArrayList<MapNode> getWaysNodes(Node way){
        ArrayList<MapNode> result = new ArrayList<MapNode>();
        
        return result;
    }

}
