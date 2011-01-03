/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * @author seth
 */
public class MapNode {
    private double latitude;
    private double longitude;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public MapNode(double latitude, double longitude, long id){
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
    }

    public static MapNode fromXMLNode(Node node){
        double latitude, longitude;
        long id;
        NamedNodeMap attribs = node.getAttributes();
        latitude = Double.parseDouble(attribs.getNamedItem("lat").getNodeValue());
        longitude = Double.parseDouble(attribs.getNamedItem("lon").getNodeValue());
        id = Long.parseLong(attribs.getNamedItem("id").getNodeValue());
        return new MapNode(latitude, longitude, id);
    }
}
