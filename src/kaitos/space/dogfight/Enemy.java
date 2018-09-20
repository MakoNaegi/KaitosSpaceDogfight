package kaitos.space.dogfight;

import java.awt.Color;

public class Enemy extends Character {
    //Constructor
    public Enemy(int x, int y, int dx, int dy, Color color, int size, String name) {
        super(x, y, dx, dy, color, size, name);
    }
    @Override
    public void update() {
        super.setDX( (int) (Math.random()*3) - 1 );
        super.setDY( (int) (Math.random()*3) - 1 );
        super.update();
    }
}
