/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatedsequence.fileInput;

/**
 *
 * @author brianho
 */
public class OCanada {
    private int id;
    private String path;
    
    public OCanada (int id, String path) {
        this.id = id;
        this.path = path;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getPath() {
        return path;
    }
}
