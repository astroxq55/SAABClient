package com.saabtech.gui;
import javax.swing.JCheckBox;


public class CheckBox extends JCheckBox{
    public JCheckBox checkbox;
    
    public CheckBox(String filterLabel, int x, int y) {
        this.checkbox = new JCheckBox();
        checkbox.setBounds(x, y, 200, 20);
        checkbox.setSelected(true);
        checkbox.setText(filterLabel);
    }
    
    

}
