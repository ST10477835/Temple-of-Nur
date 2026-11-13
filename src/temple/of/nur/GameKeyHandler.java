/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Abulele
 */
public class GameKeyHandler implements KeyListener{
    public OptionsRepository repo = new OptionsRepository();
    public GamePanel gamePanel;
    
    public GameKeyHandler(KeyListener target, GamePanel gamePanel){
        this.gamePanel = gamePanel;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                if (gamePanel.ActiveOptions != null) {
                    gamePanel.ActiveOptions.i = (gamePanel.ActiveOptions.i <= 0) ? 0 : gamePanel.ActiveOptions.i - 1;//scrolling through a list of options
                } else {
                    gamePanel.UpPressed = true;
                }
            }
            case KeyEvent.VK_A, KeyEvent.VK_LEFT ->
                gamePanel.LeftPressed = true;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                if (gamePanel.ActiveOptions != null) {
                    gamePanel.ActiveOptions.i = (gamePanel.ActiveOptions.i >= gamePanel.ActiveOptions.optionsList.length - 1) ? gamePanel.ActiveOptions.i : gamePanel.ActiveOptions.i + 1;
                } else {
                    gamePanel.DownPressed = true;
                }
            }
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT ->
                gamePanel.RightPressed = true;
            case KeyEvent.VK_ESCAPE -> {
                GamePanel.GamePaused = !GamePanel.GamePaused;
                System.out.println("Game " + (GamePanel.GamePaused ? "Paused" : "Unpaused"));
                gamePanel.ActiveOptions = GamePanel.GamePaused ? repo.PauseMenuOptions : null;
            }
            case KeyEvent.VK_SPACE -> {
                if(GamePanel.GamePaused)gamePanel.ActiveOptions.OptionHandler();
            }
        }
        System.out.println("Options: ");
        if (gamePanel.ActiveOptions != null) {
            for (String option : gamePanel.ActiveOptions.optionsList) {
                System.out.println(option);
            }
            System.out.println("Current Index: " + gamePanel.ActiveOptions.i);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP ->
                gamePanel.UpPressed = false;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT ->
                gamePanel.LeftPressed = false;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN ->
                gamePanel.DownPressed = false;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT ->
                gamePanel.RightPressed = false;
        }
    }
}
