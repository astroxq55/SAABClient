package com.saabtech.model;

import java.awt.Color;

public class SAABObject {
    public long id;
    public int x, y, type;
    public Color color;
    public String colorName;
    public int diameter = 10; // objects graphical diameter
    public int category;
    
    
    
    public SAABObject(long id, int x, int y, int type) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.type = type;
        setColor(type);
        setCategory(type);
    }
    
    public long getID() {
        return this.id;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getType() {
        return this.type;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public int getCategory() {
        return this.category;
    }
    
    @Override
    public String toString() {
        return "SAABObject{id= " + id + ", x= " + x + ", y= " + y + ", type= " + type + "}";
    }
    
    public void setX(int newX) {
        this.x = newX;
    }
    
    public void setY(int newY) {
        this.y = newY;
    }

    public void setType(int newType) {
        this.type = newType;
        setColor(newType);
    }
    
    /**
     * set Object color depending on type
     * @param type int value [1,3]
     */
    private void setColor(int type) {
        switch (type) {
            case 1 -> {this.color = Color.RED; this.colorName = "Red";}
            case 2 -> {this.color = Color.GREEN; this.colorName = "Green";}
            case 3 -> {this.color = Color.BLUE; this.colorName = "Blue";}
        }
    }
    
    /**
     * set object category depending on type
     * @param type int value [1,3]
     */
    private void setCategory(int type) {
        switch (type) {
            case 1 -> {this.category = 1;}
            case 2 -> {this.category = 1;}
            case 3 -> {this.category = 2;}
        }
    }
}
