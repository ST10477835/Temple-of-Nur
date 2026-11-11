/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Abulele
 */
class GamePanel extends JPanel implements KeyListener {

    public boolean UpPressed;
    public boolean DownPressed;
    public boolean LeftPressed;
    public boolean RightPressed;

    Player player = new Player("True Adam", "password123", Denomination.Mage);

    Enemy[] enemies = {new Enemy("Mob-Kun")
    };
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
        addKeyListener(this);
        this.setFocusable(true);
        setVisible(true);
        this.setSize(800, 600);
        //System.out.println("Panel Width: " + this.getWidth()
        //+"\nPanel Height: " + this.getHeight());
    }

    public void GameLoop() {
        while (true) {
            //movment
            HandlePlayerMovment();
            UpdateCamera();
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

    //movement
    public boolean IsColliding(int thisX, int thisY, int thatX, int thatY) {
        return thisX < thatX + Scale && thisX + Scale > thatX && thisY < thatY + Scale && thisY + Scale > thatY;
    }

    public void HandlePlayerMovment() {
        if (UpPressed) {
            int nextY = player.y - player.speed;
            int Y = (int) (nextY) / Scale;
            //how wide the player is
            int StartX = (player.x - 1) / Scale;
            int EndX = ((player.x - 1) + Scale) / Scale;
            StartX = (player.x - (Map[Y][StartX]==1?0:1)) / Scale;
            EndX = ((player.x - (Map[Y][StartX]==1?0:1)) + Scale) / Scale;
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
        if (DownPressed) {
            int nextY = player.y + player.speed - 1;
            int Y = (int) (nextY + Scale) / Scale;
            int StartX = (player.x - 1) / Scale;
            int EndX = ((player.x - 1) + Scale) / Scale;
            StartX = (player.x - (Map[Y][StartX]==1?0:1)) / Scale;
            EndX = ((player.x - (Map[Y][StartX]==1?0:1)) + Scale) / Scale;
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
        if (LeftPressed) {
            int nextX = player.x - player.speed + 1;
            int X = (int) (nextX) / Scale;
            int StartY = (player.y - 1) / Scale;
            int EndY = ((player.y - 1) + Scale) / Scale;
            StartY = (player.y - (Map[StartY][X]==1?0:1)) / Scale;
                EndY = ((player.y - (Map[EndY][X]==1?0:1)) + Scale) / Scale;
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
        if (RightPressed) {
            int nextX = player.x + player.speed - 1;
            int X = (int) (nextX + Scale) / Scale;
            int StartY = (player.y - 1) / Scale;
            int EndY = ((player.y - 1) + Scale) / Scale;
            StartY = (player.y - (Map[StartY][X]==1?0:1)) / Scale;
                EndY = ((player.y - (Map[EndY][X]==1?0:1)) + Scale) / Scale;
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
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

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
            case KeyEvent.VK_V -> {
                int nextX = player.x - player.speed + 1;
                int X = (int) (nextX) / Scale;
                int StartY = (player.y - 1) / Scale;
                int EndY = ((player.y - 1) + Scale) / Scale;
                StartY = (player.y - (Map[StartY][X]==1?0:1)) / Scale;
                EndY = ((player.y - (Map[EndY][X]==1?0:1)) + Scale) / Scale;
                System.out.println("Player coords: {" + player.x + "," + player.y + "}");
                System.out.println("nextX: " + nextX);
                System.out.println("X: " + X);
                System.out.println("StartY: " + StartY);
                System.out.println("EndY: " + EndY);

            }
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
