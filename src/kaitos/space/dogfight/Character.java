package kaitos.space.dogfight;

import java.awt.Color;
import java.awt.Graphics;

public class Character {
    //Fields (Variables)
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Color color;
    private int size;
    private String name;
    
    //Constructor
    public Character() { //no-args
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        color = new Color(141,96,119,255);
        size = 20;
        name = "name";
    }
    
    public Character(int x, int y, int dx, int dy, Color color, int size, String name) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
        this.size = size;
        this.name = name;
    }
    
    //Getters
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getName() {
        return name;
    }
    
    //Setters
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setDX(int dx) {
        this.dx = dx;
    }
    
    public void setDY(int dy) {
        this.dy = dy;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    //Public Methods
    public void draw(Graphics g) {
        g.setColor(color);
        g.fill3DRect(x, y, size, size, true);
    }
    
    public void kill () {
        grow();
    }
    
    public void move(int dx, int dy) {
        x += dx * 8;
        y += dy * 8;
    }
    
    public void reverseX() {
        x *= -1;
    }
    
    public void reverseY() {
        y *= -1;
    }
    
    public void update() {
        move(dx, dy);
    }
    
    
    //Private Methods
    private void grow() {
        size *= 1.05;
    }
}
