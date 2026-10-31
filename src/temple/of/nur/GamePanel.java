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
    
    Player player = new Player("True Adam", "password123", Denomination.Mage);
    Enemy enemy = new Enemy("Mob-Kun");
    public GamePanel() {
        new Thread(() -> {
            player.DisplayEntityInformation();
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
        g.drawRect(enemy.x, enemy.y, enemy.width, enemy.height);
        g.dispose();
    }

    public boolean IsColliding(int thisX, int thisY, int thatX, int thatY) {
        return thisX < thatX + 50 && thisX + 50 > thatX && thisY < thatY + 50 && thisY + 50 > thatY;
    }
    public void GameLoop() {
        while (true) {
            //handle player movement
            if (UpPressed) {
            int nextY = player.y - player.speed;
            int Y = (nextY) / 50;
            int StartX = (player.x) / 50;
            int EndX = (player.x+50)/50;
            if(!IsColliding(player.x, nextY, enemy.x, enemy.y)) player.y -= player.speed;
        }
        if (DownPressed) {
            int nextY = player.y + player.speed;
            int Y = (nextY + 50)/ 50;
            int StartX = player.x / 50;
            int EndX = (player.x+50)/50;
            if(!IsColliding(player.x, nextY, enemy.x, enemy.y)) player.y += player.speed;
        }
        if (LeftPressed) {
            int nextX = player.x - player.speed;
            int X = (nextX) /50;
            int StartY = player.y / 50;
            int EndY = (player.y+50)/50;
            if(!IsColliding(nextX, player.y, enemy.x, enemy.y)) player.x -= player.speed;
        }
        if (RightPressed) {
            int nextX = player.x + player.speed;
            int X = (nextX +50) /50;
            int StartY = (player.y) / 50;
            int EndY = (player.y+50)/50;
            if(!IsColliding(nextX, player.y, enemy.x, enemy.y)) player.x += player.speed;
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
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W,KeyEvent.VK_UP -> UpPressed = true;
            case KeyEvent.VK_A,KeyEvent.VK_LEFT -> LeftPressed = true;
            case KeyEvent.VK_S,KeyEvent.VK_DOWN -> DownPressed = true;
            case KeyEvent.VK_D,KeyEvent.VK_RIGHT -> RightPressed = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W,KeyEvent.VK_UP -> UpPressed = false;
            case KeyEvent.VK_A,KeyEvent.VK_LEFT -> LeftPressed = false;
            case KeyEvent.VK_S,KeyEvent.VK_DOWN -> DownPressed = false;
            case KeyEvent.VK_D,KeyEvent.VK_RIGHT -> RightPressed = false;
        }
    }
    
}
