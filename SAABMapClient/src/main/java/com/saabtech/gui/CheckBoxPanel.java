package com.saabtech.gui;
import javax.swing.JLabel;
import javax.swing.JPanel;


public final class CheckBoxPanel extends JPanel{
    private final int F_PANEL_X = 320; //px
    private final int F_PANEL_Y = 0; //px
    private final int F_PANEL_WIDTH = 220; //px
    private final int F_PANEL_HEIGHT = 320; //px
    private final int X_SPACE = 10;
    private final int[] CHECKBOX_HEIGHT = {40,60};
    private final int[] TEXT_Y_POS = {0, 230,250, 270};
    private final int LABEL_WIDTH = 200;
    private final int LABEL_HEIGHT = 40;
    public CheckBox checkBoxCat1;
    public CheckBox checkBoxCat2;

    /**
     * Constructor for panel with text and checkbox
     */
    public CheckBoxPanel() {
        CheckBoxPanelSetup();
        addText("FILTER FUNCTIONS:", X_SPACE, TEXT_Y_POS[0]);
        this.checkBoxCat1 = addCheckBoxObject("Category 1", X_SPACE, CHECKBOX_HEIGHT[0]);
        this.checkBoxCat2 = addCheckBoxObject("Category 2", X_SPACE, CHECKBOX_HEIGHT[1]); 
        addText("RED: type 1", X_SPACE, TEXT_Y_POS[1]);
        addText("GREEN: type 2", X_SPACE, TEXT_Y_POS[2]);
        addText("BLUE: type 3", X_SPACE, TEXT_Y_POS[3]);
    }
    
    /**
     * Setup for panel
     */
    private void CheckBoxPanelSetup() {
        this.setBounds(F_PANEL_X, F_PANEL_Y, F_PANEL_WIDTH, F_PANEL_HEIGHT);
        this.setLayout(null); 
    }
    
    /**
     * adds one checkbox to this panel with coordinates x and y
     * @param checkBoxLabel The label text for the checkbox
     * @param x coordinate for checkbox position
     * @param y coordinate for checkbox position
     * @return 
     */
    private CheckBox addCheckBoxObject(String checkBoxLabel, int x, int y) {
        CheckBox checkboxObj = new CheckBox(checkBoxLabel, x , y);
        this.add(checkboxObj.checkbox);
        return checkboxObj;
    }
    

    
    /**
     * Adds one line of text to this panel
     * @param text string to be added
     * @param x coordinate in panel
     * @param y coordinate in panel
     */
    private void addText(String text, int x, int y) {
        JLabel panelText = new JLabel(text);
        panelText.setBounds(x, y, LABEL_WIDTH, LABEL_HEIGHT);
        this.add(panelText);
    }
    
}


