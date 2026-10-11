/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.Insets;
import javax.swing.JFrame;

/**
 *
 * @author Abulele
 */
class GameFrame extends JFrame {
    
    public GameFrame() {
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel GamePanel = new GamePanel();
        this.add(GamePanel);
        this.pack();
        Insets Insets = this.getInsets();
        int CalculatedWidth = 800 + Insets.left + Insets.right;
        int CalclulatedHeight = 600 + Insets.bottom + Insets.top;
        this.setSize(CalculatedWidth, CalclulatedHeight);
        System.out.println("Frame Width: " + this.getWidth());
        System.out.println("Frame Height: " + this.getHeight());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
