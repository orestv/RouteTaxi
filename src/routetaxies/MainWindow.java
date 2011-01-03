/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package routetaxies;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author seth
 */
public class MainWindow extends JFrame{
    public MainWindow(){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initGUI();
    }

    private void initGUI(){
        MapModel m = new MapModel("out.xml");

        JPanel p = new JPanel(new MigLayout(""));
        MapCanvas cnvMap = new MapCanvas();
        JPanel pnlControls = new JPanel();
        JPanel pnlStatus = new JPanel();        

        cnvMap.setModel(m);

        p.add(cnvMap, "w 90%!, h 90%");
        p.add(pnlControls, "w 6cm!, h 100%, wrap");
        p.add(pnlStatus, "span, w 100%, h 2cm!");

        this.add(p);
        this.setPreferredSize(new Dimension(800, 600));
        this.pack();
        Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) ((dimScreen.getWidth() - this.getWidth()) / 2),
                (int)((dimScreen.getHeight() - this.getHeight())/2));
        this.setVisible(true);
    }

}
