/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import org.w3c.dom.Node;

/**
 *
 * @author seth
 */
public class MapNode {
    private double latitude;
    private double longitude;

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

    public MapNode(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static MapNode fromXMLNode(Node node){
        double latitude, longitude;
        latitude = Double.parseDouble(node.getAttributes().getNamedItem("lat").getNodeValue());
        longitude = Double.parseDouble(node.getAttributes().getNamedItem("lon").getNodeValue());
        return new MapNode(latitude, longitude);
    }
}
