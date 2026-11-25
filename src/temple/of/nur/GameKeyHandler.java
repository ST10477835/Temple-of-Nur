/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Abulele
 */
public class GameKeyHandler implements KeyListener{
    public boolean UpPressed;
    public boolean DownPressed;
    public boolean LeftPressed;
    public boolean RightPressed;
    
    public GameKeyHandler(JPanel GamePanel){
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP ->
                UpPressed = true;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT ->
                LeftPressed = true;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN ->
                DownPressed = true;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT ->
                RightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP ->
                UpPressed = false;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT ->
                LeftPressed = false;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN ->
                DownPressed = false;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT ->
                RightPressed = false;
        }
    }

    
}
