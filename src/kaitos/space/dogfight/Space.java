package kaitos.space.dogfight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.input.KeyCode;
import javax.swing.JPanel;

public class Space extends JPanel {
    
    final int marginX;
    final int marginY;
    private Protag kaito;
    private Enemy despairbot;
    private Timer timer;
    
    public Space() {
        super();
        marginX = 10;
        marginY = 10;
        kaito = new Protag(1080,430,0,0,new Color(141,96,119,255),20,"Kaito");
        despairbot = new Enemy(360,430,0,0,new Color(255,89,238,255),20,"Despair Bot");
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 100);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK); 
        drawStars(g);
        
        kaito.draw(g);
        despairbot.draw(g);
        
        g.dispose();
    }
    
    public void run() {
        repaint();
    }
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            wallCollisions(kaito);
            wallCollisions(despairbot);
            protagVsEnemy(kaito,despairbot);            
            kaito.update();
            despairbot.update();
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kaito.setDX(1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            kaito.setDX(-1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            kaito.setDY(1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            kaito.setDY(-1);
        }
        run();
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
            kaito.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
            kaito.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_UP)
            kaito.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_DOWN)
            kaito.setDY(0);
    }

    
    private void drawStars(Graphics g) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 1500; i++) {
            int randAlpha = (int) (Math.random() * 255);
            int randR = (int) (Math.random() * 255);
            int randG = (int) (Math.random() * 255);
            int randB = (int) (Math.random() * 255);
            int randSize = (int) (Math.random() * 4) + 1;
            g.setColor(new Color(121,99,181,randAlpha));
            x = (int) (Math.random() * 1500);
            y = (int) (Math.random() * 1500);
            g.fillOval(x, y, randSize, randSize);
            System.out.println("Location: ("+x+", "+y+") "+"Size: "+randSize+" "+"Color: ("+randR+","+randG+","+randB+","+randAlpha+")");
        }
    }
    
    private void protagVsEnemy(Protag p, Enemy e) {
        if ((p.getX() + 20) >= e.getX() && (p.getY() + 20) >= e.getY()) {
            if (p.getX() <= (e.getX() + 20) && p.getY() <= (e.getY() + 20)) {
                e.kill(e);
            }
        }  
    }
    
    private void wallCollisions(Character c) {
        if (c.getX() <= 0 || c.getX() >= this.getWidth()-20 ) {
            c.reverseX();
        }
        if (c.getY() <= 0 || c.getY() >= this.getHeight()-20 ) {
            c.reverseY();
        }
    }
}
