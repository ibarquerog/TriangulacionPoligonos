/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulation;

/**
 *
 * @author josep
 */
public class Vector {
     public double x;
    public double y;

    public Vector() {
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }
    
    public double cross(Vector v) {
        return x * v.y - y * v.x;
    }
    
}
