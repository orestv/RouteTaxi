/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author seth
 */
public class MapCanvas extends JPanel{

    private double LONGITUDE_LEFT = 23.91;
    private double LONGITUDE_RIGHT = 24.1;
    private double LATITUDE_BOTTOM = 49.76;
    private double LATITUDE_TOP = 49.82;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
