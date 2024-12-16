package com.saabtech.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public final class AppWindow extends JFrame implements ActionListener{
    private final int WINDOW_WIDTH = 570; //px
    private final int WINDOW_HEIGHT = 360;//px
    private final String title = "SAAB Real Time Map Client"; 
    public MapPanel mapPanel;
    private CheckBoxPanel checkBoxPanel;

    /**
     * Constructor. Class setup + adds map panel and filter panel to Frame
     */
    public AppWindow(){
        appWindowSetup();
        createCheckBoxPanel();
        createMapPanel();
    }
    
    /**
     * JFrame settings for the appWindow
     */
    private void appWindowSetup() {
        this.setTitle(this.title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setVisible(true);  
    }
    
    /**
     * creates mapPanel and adds it to AppWindow
     */
    public void createMapPanel() {
        this.mapPanel = new MapPanel();
        this.add(mapPanel); 
    }
    
    /**
     * creates mapPanel and adds it to AppWindow
     */
    public void createCheckBoxPanel() {
        this.checkBoxPanel = new CheckBoxPanel();
        this.add(checkBoxPanel);
        checkBoxPanel.checkBoxCat1.checkbox.addActionListener(this);
        checkBoxPanel.checkBoxCat2.checkbox.addActionListener(this);
    }
    
    /**
     * forwards checkbox status to mapPanel so it knows if to paint
     * @param e action event reacts on checkbox 1 or 2 is ticked or unticked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkbox1IsChecked()) {
            mapPanel.checkBoxStatusCat1 = true;
        } else {
            mapPanel.checkBoxStatusCat1 = false;
        }
        if(checkbox2IsChecked()) {
            mapPanel.checkBoxStatusCat2 = true;
        } else {
            mapPanel.checkBoxStatusCat2 = false;
        }        
    }
    
    /**
     * checks the checking status for Checkbox 2
     * @return 'true' if checkbox for category 1 is ticked, else 'false'
     */
    private boolean checkbox1IsChecked() {
        return checkBoxPanel.checkBoxCat1.checkbox.isSelected();
    }
    
    /**
     * checks the checking status for Checkbox 2
     * @return 'true' if checkbox for category 2 is ticked, else 'false'
     */
    private boolean checkbox2IsChecked() {
        return checkBoxPanel.checkBoxCat2.checkbox.isSelected();
    }

}
