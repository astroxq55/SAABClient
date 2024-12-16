package com.saabtech.gui;
import com.saabtech.model.SAABObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MapPanel extends JPanel{
    private final int MAP_PANEL_WIDTH = 320; //px
    private final int MAP_PANEL_HEIGHT = 320; //px
    private final String mapPath = "resources/map.gif";
    private final Image mapImage;
    private final int[] mapPosition = {0, 0};
    public HashMap<Long, SAABObject> mapObjects = new HashMap<>();
    public boolean checkBoxStatusCat1 = true;
    public boolean checkBoxStatusCat2 = true;
    
    
    /**
     * Constructor
     */
    public MapPanel() {
        this.setBounds(0, 0, MAP_PANEL_WIDTH, MAP_PANEL_HEIGHT);
        this.mapImage = new ImageIcon(mapPath).getImage();
    }
    
    /**
     * Paint function that paints the map and the SAAB objects in this panel
     * @param g Graphics component that paints components in panel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //draw map
        if (mapImage != null) {
            g.drawImage(mapImage, mapPosition[0], mapPosition[1], null);
        } else {
            System.out.println("No map image was found!");
        }
        // draw dots on map
        if(mapObjects != null) {
            mapObjects.forEach((id, saabObject) -> {
                if(thisShouldBePainted(saabObject)) {
                    g2d.setColor(saabObject.color);
                    g2d.fillOval(saabObject.x, saabObject.y, saabObject.diameter, saabObject.diameter);
                }
            });
        } else {
            System.out.println("No SAAB Objects were found!");
        }
    }
    
    /**
     * Object my only be painted IF corresponding checkbox is checked.
     * pairs obj category with correct checkbox status.
     * @param obj - the object that may or may not be painted.
     * @return 'true' if object may be painted, else 'false'
     */
    private boolean thisShouldBePainted(SAABObject obj) {
        boolean objectIsCategory1 = obj.getCategory() == 1;
        boolean objectIsCategory2 = obj.getCategory() == 2;
        if(objectIsCategory1){
            return checkBoxStatusCat1 && objectIsCategory1;
        } else if(objectIsCategory2){
            return checkBoxStatusCat2 && objectIsCategory2;
        } else return false;
    }

}
