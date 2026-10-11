/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Abulele
 */
class GamePanel extends JPanel implements KeyListener {
    
    public GamePanel() {
        new Thread(() -> {
            player.DisplayPlayerInformation();
            GameLoop();
        }).start();
        addKeyListener(this);
        this.setFocusable(true);
        setVisible(true);
        this.setSize(800, 600);
        //System.out.println("Panel Width: " + this.getWidth()
                //+"\nPanel Height: " + this.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(player.x, player.y, player.width, player.height);
        g.dispose();
    }
    Player player = new Player("True Adam", "password123", Denomination.Mage);

    public void GameLoop() {
        while (true) {
            //handle player movement
            if (UpPressed) {
                player.y -= player.speed;
            }
            if (DownPressed) {
                player.y += player.speed;
            }
            if (LeftPressed) {
                player.x -= player.speed;
            }
            if (RightPressed) {
                player.x += player.speed;
            }
            this.repaint();
            //render
            //Sleep
            try {
                Thread.sleep(16);
            } catch (Exception e) {
                System.out.println("Error message: " + e.getMessage());
                break;
            }
        }
    }
    public boolean UpPressed;
    public boolean DownPressed;
    public boolean LeftPressed;
    public boolean RightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed: " + e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                UpPressed = true;
            }
            case KeyEvent.VK_A -> {
                LeftPressed = true;
            }
            case KeyEvent.VK_S -> {
                DownPressed = true;
            }
            case KeyEvent.VK_D -> {
                RightPressed = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased: " + e.getKeyChar());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                UpPressed = false;
            }
            case KeyEvent.VK_A -> {
                LeftPressed = false;
            }
            case KeyEvent.VK_S -> {
                DownPressed = false;
            }
            case KeyEvent.VK_D -> {
                RightPressed = false;
            }
        }
    }
    
}
