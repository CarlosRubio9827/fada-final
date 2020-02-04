/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

/**
 *
 * @author juan3
 */
public class Encomienda {
    
    private int index;
    private int x;
    private int y;
    
     public Encomienda() {
    }

    public Encomienda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Encomienda(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    
    @Override
    public String toString() {
        return "Encomienda{" + "[" + x + "," + y + "]" + '}';
    }
    
}
