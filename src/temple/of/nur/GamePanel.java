/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Abulele
 */
public class GamePanel extends JPanel {

    Player player = new Player("True Adam", "password123", Denomination.Mage);
    Enemy[] enemies = {new Enemy("Mob-Kun")};

    public static Inventory inventory = new Inventory();
    OptionSets OptionSets = new OptionSets(this);
    GameKeyHandler gkh = new GameKeyHandler(this);
    public int ScreenWidth = 800;
    public int ScreenHeight = 600;


    public OptionSet ActiveOptionSet;

    int Scale = 50;//50x50 pixels
    int[][] Map = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public GamePanel() {
        new Thread(() -> {
            player.DisplayEntityInformation();
            player.x = 350;
            player.y = 250;
            GameLoop();
        }).start();
        addKeyListener(gkh);
        this.setFocusable(true);
        setVisible(true);
        this.setSize(ScreenWidth, ScreenHeight);
        player.Inventory.ItemList = new Item[]{
            new Item("Item 1"),
            new Item("Item 2"),
            new Item("Item 3")};
        player.Inventory.WeaponList = new Weapon[]{
            new Weapon("Weapon 1"),
            new Weapon("Weapon 2"),
            new Weapon("Weapon 3")};
        PopulateInventoryMenu();
        inventory.ItemList = player.Inventory.ItemList;
        inventory.WeaponList = player.Inventory.WeaponList;
    }

    public void GameLoop() {
        while (true) {
            if (!gkh.GamePaused) {
                //movment
                HandlePlayerMovment();
                UpdateCamera();
            }
            //render
            this.repaint();
            try {
                Thread.sleep(16);
            } catch (Exception e) {
                System.out.println("Error message: " + e.getMessage());
                break;
            }
        }
    }
    public void PopulateInventoryMenu(){
        ArrayList<String> Inventory = new ArrayList<>();
        for(Item item: player.Inventory.ItemList){
            Inventory.add(item.Name);
        }
        for(Weapon weapon: player.Inventory.WeaponList){
            Inventory.add(weapon.Name);
        }
        OptionSets.InventoryMenu.Options = new String[Inventory.size()];
        OptionSets.InventoryMenu.Options = Inventory.toArray(OptionSets.InventoryMenu.Options);

    }
    //movement
    public boolean IsColliding(int thisX, int thisY, int thatX, int thatY) {
        return thisX < thatX + Scale && thisX + Scale > thatX && thisY < thatY + Scale && thisY + Scale > thatY;
    }

    public void HandlePlayerMovment() {
        if (gkh.UpPressed) {
            int nextY = player.y - player.speed;
            int Y = (int) (nextY) / Scale;
            //how wide the player is
            int StartX = (player.x - 1) / Scale;
            int EndX = ((player.x - 1) + Scale) / Scale;
            StartX = (player.x - (Map[Y][StartX] == 1 ? 0 : 1)) / Scale;
            EndX = ((player.x - (Map[Y][StartX] == 1 ? 0 : 1)) + Scale) / Scale;
            if (enemies.length > 0) {
                for (Enemy enemy : enemies) {
                    if (!IsColliding(player.x, nextY, enemy.x, enemy.y)
                            && (Map[Y][StartX] == 0 && Map[Y][EndX] == 0)) {
                        player.y -= player.speed;
                    }
                }
            } else if (Map[Y][StartX] == 0 && Map[Y][EndX] == 0) {
                player.y -= player.speed;
            }
        }
        if (gkh.DownPressed) {
            int nextY = player.y + player.speed - 1;
            int Y = (int) (nextY + Scale) / Scale;
            int StartX = (player.x - 1) / Scale;
            int EndX = ((player.x - 1) + Scale) / Scale;
            StartX = (player.x - (Map[Y][StartX] == 1 ? 0 : 1)) / Scale;
            EndX = ((player.x - (Map[Y][StartX] == 1 ? 0 : 1)) + Scale) / Scale;
            if (enemies.length > 0) {
                for (Enemy enemy : enemies) {
                    if (!IsColliding(player.x, nextY, enemy.x, enemy.y)
                            && (Map[Y][StartX] == 0 && Map[Y][EndX] == 0)) {
                        player.y += player.speed;
                    }
                }
            } else if (Map[Y][StartX] == 0 && Map[Y][EndX] == 0) {
                player.y += player.speed;
            }
        }
        if (gkh.LeftPressed) {
            int nextX = player.x - player.speed + 1;
            int X = (int) (nextX) / Scale;
            int StartY = (player.y - 1) / Scale;
            int EndY = ((player.y - 1) + Scale) / Scale;
            StartY = (player.y - (Map[StartY][X] == 1 ? 0 : 1)) / Scale;
            EndY = ((player.y - (Map[EndY][X] == 1 ? 0 : 1)) + Scale) / Scale;
            if (enemies.length > 0) {
                for (Enemy enemy : enemies) {
                    if (!IsColliding(nextX, player.y, enemy.x, enemy.y)
                            && (Map[StartY][X] == 0 && Map[EndY][X] == 0)) {
                        player.x -= player.speed;
                    }
                }
            } else if (Map[StartY][X] == 0 && Map[EndY][X] == 0) {
                player.x -= player.speed;
            }
        }
        if (gkh.RightPressed) {
            int nextX = player.x + player.speed - 1;
            int X = (int) (nextX + Scale) / Scale;
            int StartY = (player.y - 1) / Scale;
            int EndY = ((player.y - 1) + Scale) / Scale;
            StartY = (player.y - (Map[StartY][X] == 1 ? 0 : 1)) / Scale;
            EndY = ((player.y - (Map[EndY][X] == 1 ? 0 : 1)) + Scale) / Scale;
            if (enemies.length > 0) {
                for (Enemy enemy : enemies) {
                    if (!IsColliding(nextX, player.y, enemy.x, enemy.y)
                            && (Map[StartY][X] == 0 && Map[EndY][X] == 0)) {
                        player.x += player.speed;
                    }
                }
            } else if (Map[StartY][X] == 0 && Map[EndY][X] == 0) {
                player.x += player.speed;
            }
        }
    }

    //rendering
    //entity scale are the only things that are subject to variable change
    //everything else will follow Scale
    int CameraOffSetX = 0;
    int CameraOffSetY = 0;

    public void UpdateCamera() {
        int mapWidthPx = Map[0].length * Scale; // columns = x
        int mapHeightPx = Map.length * Scale;    // rows = y

        int viewWidth = this.getWidth();
        int viewHeight = this.getHeight();

        // Where the camera WANTS to be so the player is centered
        int targetX = player.x - viewWidth / 2;
        int targetY = player.y - viewHeight / 2;

        // Clamp so we never show past the map edges
        targetX = Math.max(0, Math.min(targetX, mapWidthPx - viewWidth));
        targetY = Math.max(0, Math.min(targetY, mapHeightPx - viewHeight));

        // Smoothly ease toward the target instead of snapping
        double smoothing = 0.5; // 0 = never moves, 1 = instant snap; tune to taste
        CameraOffSetX += (targetX - CameraOffSetX) * smoothing;
        CameraOffSetY += (targetY - CameraOffSetY) * smoothing;

    }

    public static Font HeaderFont = new Font(Font.MONOSPACED, Font.BOLD, 50);
    public static Font OptionFont = new Font(Font.MONOSPACED, Font.BOLD, 25);
    public static Font SelectedOptionFont = new Font(Font.MONOSPACED, Font.BOLD, 30);
    public static Font BasicFont = new Font(Font.MONOSPACED, Font.PLAIN, 13);

    public void DrawPlayer(Graphics g) {
        g.drawRect(player.x - CameraOffSetX, player.y - CameraOffSetY, player.width, player.height);
    }

    public void DrawEnemy(Enemy enemy, Graphics g) {
        g.drawRect(enemy.x - CameraOffSetX, enemy.y - CameraOffSetY, enemy.width, enemy.height);
    }

    public void DrawMap(Graphics g) {
        for (int row = 0; row < Map.length; row++) {
            for (int column = 0; column < Map[row].length; column++) {
                int WorldX = column * Scale - CameraOffSetX;
                int WorldY = row * Scale - CameraOffSetY;

                g.setColor(Map[row][column] == 1 ? Color.GRAY : Color.LIGHT_GRAY);
                g.fillRect(WorldX, WorldY, Scale, Scale);
            }
        }
    }

    public void DrawVignette(Graphics2D g) {
        if (vignetteImage == null
                || vignetteImage.getWidth() != ScreenWidth
                || vignetteImage.getHeight() != ScreenHeight) {
            buildVignette(); // first use, or after a resize
        }
        g.drawImage(vignetteImage, 0, 0, null);
    }

    private BufferedImage vignetteImage;

    public void buildVignette() {
        vignetteImage = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration()
                .createCompatibleImage(ScreenWidth, ScreenHeight, Transparency.TRANSLUCENT);

        Graphics2D vg = vignetteImage.createGraphics();

        Point2D center = new Point2D.Float(ScreenWidth / 2f, ScreenHeight / 2f);
        float radius = Math.max(ScreenWidth, ScreenHeight) * 0.7f;

        float[] dist = {0.0f, 0.65f, 1.0f};
        Color[] colors = {
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 40),
            new Color(0, 0, 0, 200)
        };
        vg.setPaint(new RadialGradientPaint(center, radius, dist, colors));
        vg.fillRect(0, 0, ScreenWidth, ScreenHeight);
        vg.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawMap(g);
        DrawPlayer(g);
        if (enemies.length > 0) {
            for (Enemy enemy : enemies) {
                DrawEnemy(enemy, g);
            }
        }
        if (ActiveOptionSet!=null) {
            ActiveOptionSet.Draw(g);
        }
        DrawVignette((Graphics2D) g);
        g.dispose();
    }

    public int GetCenterXCoord(FontMetrics metrics, String text) {
        int charWidth = metrics.charWidth('M');
        int TextWidth = charWidth * text.length();
        int XCoord = (ScreenWidth / 2) - (TextWidth / 2);
        return XCoord;
    }

    public int GetCenterYCoord(FontMetrics metrics) {
        int charHeight = metrics.getHeight();
        int YCoord = (ScreenHeight / 2) - (charHeight / 2);
        return YCoord;
    }
    public static void drawString(Graphics g, String text, int x, int y) {
                for (String line : text.split("\n"))
                    g.drawString(line, x, y += g.getFontMetrics().getHeight());
            }
}
