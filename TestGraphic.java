import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class NumberGame extends JPanel {
    private static final int RECT_SIZE = 20;
    private static final int MOVE_SIZE = 10;
    private int rectX = 0;
    private int rectY = 0;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private boolean gameOver = false;

    public NumberGame() {
        setPreferredSize(new Dimension(400, 400));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            moveRectangle(-MOVE_SIZE, 0);
                            break;
                        case KeyEvent.VK_RIGHT:
                            moveRectangle(MOVE_SIZE, 0);
                            break;
                        case KeyEvent.VK_UP:
                            moveRectangle(0, -MOVE_SIZE);
                            break;
                        case KeyEvent.VK_DOWN:
                            moveRectangle(0, MOVE_SIZE);
                            break;
                    }
                    repaint();
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
    }

    private void moveRectangle(int x, int y) {
        rectX += x;
        rectY += y;

        for (int i = 0; i < numbers.size(); i++) {
            int numX = (numbers.get(i) - 1) % 5 * RECT_SIZE;
            int numY = (numbers.get(i) - 1) / 5 * RECT_SIZE;

            if (numX == rectX && numY == rectY) {
                numbers.remove(i);

                if (numbers.isEmpty()) {
                    gameOver = true;
                }
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < numbers.size(); i++) {
            int numX = (numbers.get(i) - 1) % 5 * RECT_SIZE;
            int numY = (numbers.get(i) - 1) / 5 * RECT_SIZE;

            g.drawString(Integer.toString(numbers.get(i)), numX + RECT_SIZE / 2, numY + RECT_SIZE / 2);
        }

        g.setColor(Color.BLACK);
        g.fillRect(rectX, rectY, RECT_SIZE, RECT_SIZE);

        if (gameOver) {
            if (numbers.isEmpty()) {
                g.drawString("YOU WON!", 160, 200);
            } else {
                g.drawString("YOU LOST!", 160, 200);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NumberGame game = new NumberGame();
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
    }
}
