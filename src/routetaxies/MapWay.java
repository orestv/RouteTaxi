/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.util.ArrayList;
import org.w3c.dom.Node;

/**
 *
 * @author seth
 */
public class MapWay {
    private long id;
    private String name;
    private ArrayList<MapNode> nodes = new ArrayList<MapNode>();

    public MapWay(long id, String name, ArrayList<MapNode> nodes) {
        this.id = id;
        this.name = name;
        this.nodes = nodes;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MapNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<MapNode> nodes) {
        this.nodes = nodes;
    }// </editor-fold>

}
