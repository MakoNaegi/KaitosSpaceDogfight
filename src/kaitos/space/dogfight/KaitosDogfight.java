package kaitos.space.dogfight;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class KaitosDogfight {
    
    public static void main(String[] args) {
        JFrame j = new JFrame("Kaito Momota's Space Dogfight");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(1440, 860);
        Space c = new Space();
        j.add(c);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                c.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                c.keyReleased(e);
            }
        });
    }
    
}
