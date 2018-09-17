package kaitos.space.dogfight;

//@author Rex Naugle
import java.awt.Color;

public class Protag extends Character {
    
    private int health;

    //Constructor
    public Protag() { //no-args
        super();
        health = 3;
    }
    
    public Protag(int x, int y, int dx, int dy, Color color, int size, String name) {
        super(x, y, dx, dy, color, size, name);
        health = 3;
    }
    
    //Getters
    public int getHealth() {
        return health;
    }
    
    //Public Methods
    public void collect() {
        
    }
    
    public void teleport() {
        
    }
    
    //Private Methods
    private void canTeleport() {
        
    }
    
}
