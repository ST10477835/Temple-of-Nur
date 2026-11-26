/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Abulele
 */
public class OptionSets {
    public static GamePanel GamePanel;
    public OptionSets(GamePanel GamePanel){
        this.GamePanel = GamePanel;
    }
    
    public static OptionSet InventoryMenu = new OptionSet("", new String[]{""}, 0){
        @Override
        public void Draw(Graphics g) {
            //overlay
            Color semiTransparentGray = new Color(128, 128, 128, 128);
            g.setColor(semiTransparentGray);
            g.fillRect(0, 0, GameFrame.FrameWidth, GameFrame.FrameHeight);

            int Line = 100;
            String PauseText = "Game Paused";//Monospace characters all have the same width so all text should be capitalized
            g.setFont(GamePanel.HeaderFont);
            g.setColor(Color.BLACK);
            g.drawString(PauseText, GamePanel.GetCenterXCoord(g.getFontMetrics(), PauseText), Line);
            g.setFont(GamePanel.BasicFont);
            //pause header
            //options
            for (String option : GamePanel.ActiveOptionSet.Options) {
                g.setFont(GamePanel.OptionFont);
                g.setColor(Color.BLACK);
                if (option.equals(GamePanel.ActiveOptionSet.Options[GamePanel.ActiveOptionSet.i])) {
                    g.setFont(GamePanel.SelectedOptionFont);
                    g.setColor(Color.WHITE);
                }
                Line += g.getFontMetrics().getHeight();
                g.drawString(option, GamePanel.GetCenterXCoord(g.getFontMetrics(), option), Line);
            }
        }
    };
    public static OptionSet PauseMenu = new OptionSet("Game Paused", new String[]{"Continue", "Check Inventory", "Exit Game"}, 0) {
        @Override
        public void OptionHandler() {
            switch (this.i) {
                case 0 ->
                    Continue();
                case 1 ->
                    CheckInventory();
                case 2 ->
                    ExitGame();
            }
        }

        @Override
        public void Draw(Graphics g) {
            //overlay
            Color semiTransparentGray = new Color(128, 128, 128, 128);
            g.setColor(semiTransparentGray);
            g.fillRect(0, 0, GameFrame.FrameWidth, GameFrame.FrameHeight);

            int Line = 100;
            String PauseText = "Game Paused";//Monospace characters all have the same width so all text should be capitalized
            g.setFont(GamePanel.HeaderFont);
            g.setColor(Color.BLACK);
            g.drawString(PauseText, GamePanel.GetCenterXCoord(g.getFontMetrics(), PauseText), Line);
            g.setFont(GamePanel.BasicFont);
            //pause header
            //options
            for (String option : GamePanel.ActiveOptionSet.Options) {
                g.setFont(GamePanel.OptionFont);
                g.setColor(Color.BLACK);
                if (option.equals(GamePanel.ActiveOptionSet.Options[GamePanel.ActiveOptionSet.i])) {
                    g.setFont(GamePanel.SelectedOptionFont);
                    g.setColor(Color.WHITE);
                }
                Line += g.getFontMetrics().getHeight();
                g.drawString(option, GamePanel.GetCenterXCoord(g.getFontMetrics(), option), Line);
            }
        }

        public void Continue() {
            if (this.LastOptionSet != null) {
                GamePanel.ActiveOptionSet = this.LastOptionSet;
            } else {
                GamePanel.ActiveOptionSet = null;
                GamePanel.gkh.GamePaused = false;
            }
        }

        public void CheckInventory() {
            GamePanel.ActiveOptionSet = InventoryMenu;
            GamePanel.ActiveOptionSet.LastOptionSet = PauseMenu;
        }

        public void ExitGame() {
            System.exit(0);
        }
    };
}
