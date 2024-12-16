package com.saabtech.model;
import java.util.HashMap;

public class DataProcessor {
    private HashMap<Long, SAABObject> objectHash = new HashMap<>();
    
    /**
     * Extracts data values from input string. Will add new objects to HashMap for new unique ID values found.
     * @param inData String value from server data. Example might look like:
     * "ID=10136551266900;X=204;Y=18;TYPE=3"
     * Each unique ID represents an object with coordinates (x, y) and object type. 
     */
    public void processInputString(String inData) {
        String[] parts = inData.split(";");
        long id = Long.parseLong(parts[0].split("=")[1]);
        int x = Integer.parseInt(parts[1].split("=")[1]);
        int y = Integer.parseInt(parts[2].split("=")[1]);
        int type = Integer.parseInt(parts[3].split("=")[1]);
        
        if(!existsInHashMap(id)) {
            addObjectToHashMap(id, x, y, type);
        } else {
            updateObjectXandY(id, x, y);
        }
    }
    
    
    /**
     * Will add SAABObject to HashMap
     * @param id key value for SAABObjects
     * @param x coordinate value for SAABObject
     * @param y coordinate value for SAABObject
     * @param type object type value for SAABObject
     */
    public void addObjectToHashMap(long id, int x, int y, int type) {
        SAABObject newObject = new SAABObject(id, x, y, type);
        objectHash.put(id, newObject);
        System.out.println("NEW ID <" + id + "> was added to {hashMap} with x, y = <" + x + ", " + y + "> type: " + type + "\n");
    }
    
    /**
     * Will check if given object id already exists in the object HashMap
     * @param id key value for SAABObjects
     * @return 'true' if id doesn't exist in HashMap, else 'false'
     */
    private boolean existsInHashMap(long id) {
        return objectHash.containsKey(id);
    }
    
    /**
     * get function for HashMap
     * @return HashMap with saabObjects
     */
    public HashMap<Long, SAABObject> getHashMap() {
        return this.objectHash;
    }
    
    /**
     * overwrites object x and y coordinates with new x and y coordinates. 
     * @param id long key value of SAABObjcet
     * @param newX new X coordinates
     * @param newY new Y coordinates
     */
    private void updateObjectXandY(long id, int newX, int newY) {
        SAABObject obj = objectHash.get(id);
        obj.setX(newX);
        obj.setY(newY);
        System.out.println("ID <" + id + "> was updated to x, y = <" + newX + ", " + newY + ">\n");
    }
    
    /**
     * Debug function that prints out all existing objects in HashMap once with attributes
     */
    public void printAllObjectsInCommand() {
        System.out.println("Current list of objects:");
        objectHash.forEach((id, saabObject) -> {
            System.out.println("ID: " + id 
                       + ", X: " + saabObject.x 
                       + ", Y: " + saabObject.y 
                       + ", Type: " + saabObject.type 
                       + ", Color: " + saabObject.colorName);
        });
        System.out.println("");
    }
    
    
}
