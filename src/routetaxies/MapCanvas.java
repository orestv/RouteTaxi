/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author seth
 */
public class MapCanvas extends JPanel implements MouseListener, MouseMotionListener{

    private double longitude_left = 23.91;
    private double longitude_right = 24.1;
    private double latitude_bottom = 49.76;
    private double latitude_top = 49.82;

    public MapCanvas(){
        addMouseMotionListener(this);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseDragged(MouseEvent e) {
        //System.out.println(String.format("Drag: %d, %d", e.getX(), e.getY()));
    }

    public void mouseMoved(MouseEvent e) {
        //System.out.println(String.format("Move: %d, %d", e.getX(), e.getY()));
    }

    private Point degreesToXY(double latitude, double longitude){
        Point pt = new Point();
        pt.y = (int) (((getLatitude_top() - latitude) / (getLatitude_top() - getLatitude_bottom())) * (this.getHeight()));
        pt.x = (int)((longitude - getLongitude_left()) / (getLongitude_right() - getLongitude_left())) * (this.getWidth());
        return pt;
    }

    public double getLatitude_bottom() {
        return latitude_bottom;
    }

    public void setLatitude_bottom(double latitude_bottom) {
        this.latitude_bottom = latitude_bottom;
    }

    public double getLatitude_top() {
        return latitude_top;
    }

    public void setLatitude_top(double latitude_top) {
        this.latitude_top = latitude_top;
    }

    public double getLongitude_left() {
        return longitude_left;
    }

    public void setLongitude_left(double longitude_left) {
        this.longitude_left = longitude_left;
    }

    public double getLongitude_right() {
        return longitude_right;
    }

    public void setLongitude_right(double longitude_right) {
        this.longitude_right = longitude_right;
    }

}
