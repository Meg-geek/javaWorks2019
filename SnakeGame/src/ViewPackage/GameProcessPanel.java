package ViewPackage;

import ControllerPackage.GameDifficulty;
import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayDeque;

public class GameProcessPanel extends JPanel {
    private ArrayDeque<Point> snakeBody;
    private Point curApple;
    private Color snakeColor = new Color(Constants.SNAKEBODY_COLOR_RED, Constants.SNAKEBODY_COLOR_GREEN,
            Constants.SNAKEBODY_COLOR_BLUE);
    private Color backgroundColor = new Color(Constants.BACKGROUND_COLOR_RED, Constants.BACKGROUND_COLOR_GREEN,
            Constants.BACKGROUND_COLOR_BLUE);
    private Color borderColor = Color.BLACK;
    private Color fontColor = Color.BLACK;
    private Image appleIcon;
    private int score = 0;
    private int highScore = 0;
    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
   // private String difficultyString[] = {"easy", "medium", "hard"};
    private int lineSnakeWidth = 3;
    private GameDifficulty difficulty = GameDifficulty.EASY;

    public GameProcessPanel(ArrayDeque<Point> beginSnakeBody, Point beginApple, GameDifficulty newDifficulty) {
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT);
        snakeBody = beginSnakeBody;
        curApple = beginApple;
        appleIcon = new ImageIcon("src\\resources\\appleIcon.jpg").getImage().getScaledInstance(Constants.CELL_WIDTH - 2,
                Constants.CELL_HIGHT - 2, Image.SCALE_DEFAULT);
        difficulty = newDifficulty;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(fontColor);
        g.setFont(font);
        String gameState = "Apples eaten : " + Integer.toString(score)
                + "    Difficulty: " + difficulty + "    Your highscore: " + highScore;
        g.drawString(gameState, Constants.CELL_HIGHT * 4,
                Constants.CELL_WIDTH );
        g.setColor(borderColor);
        for (int i = 1; i < Constants.CELLS_AMOUNT_IN_LINE; i++){
            for (int j = 1; j < Constants.CELLS_AMOUNT_IN_LINE; j++){
                g.drawOval(Constants.CELL_WIDTH * 2 + j * Constants.CELL_WIDTH,
                        Constants.CELL_HIGHT * 2 + i * Constants.CELL_HIGHT,
                        1, 1);
            }
        }
        for (int i = 0; i <= 1; i++){
            g.drawLine(Constants.CELL_WIDTH * 2, Constants.CELL_HIGHT * 2 ,
                    Constants.CELL_WIDTH * 2 + (1 - i)*Constants.CELLS_AMOUNT_IN_LINE * Constants.CELL_WIDTH,
                    Constants.CELL_HIGHT * 2 + i*Constants.CELLS_AMOUNT_IN_LINE * Constants.CELL_HIGHT);
            g.drawLine(Constants.CELL_WIDTH * 2 + Constants.CELLS_AMOUNT_IN_LINE * Constants.CELL_WIDTH,
                    Constants.CELL_HIGHT * 2 + Constants.CELLS_AMOUNT_IN_LINE * Constants.CELL_HIGHT,
                    Constants.CELL_WIDTH * 2 + (1 - i)*Constants.CELLS_AMOUNT_IN_LINE * Constants.CELL_WIDTH,
                    Constants.CELL_HIGHT * 2 + i*Constants.CELLS_AMOUNT_IN_LINE * Constants.CELL_HIGHT);
        }

        g.setColor(snakeColor);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(lineSnakeWidth));
        for (Point snakePart : snakeBody){
            g2.draw(new Rectangle2D.Double(Constants.CELL_WIDTH*2 + lineSnakeWidth + Constants.CELL_WIDTH * snakePart.x,
                    Constants.CELL_HIGHT*2 + lineSnakeWidth +Constants.CELL_HIGHT * snakePart.y,
                    Constants.CELL_WIDTH - lineSnakeWidth - 1,
                    Constants.CELL_HIGHT - lineSnakeWidth - 1));
        }
        g.drawImage(appleIcon, Constants.CELL_WIDTH * 2 + Constants.CELL_WIDTH * curApple.x + 2,
                Constants.CELL_HIGHT * 2 + Constants.CELL_HIGHT * curApple.y + 2, this);
    }

    public void refreshInfo(ArrayDeque<Point> refreshSnakeBody, Point refreshApple, int refreshScore,
                            int refreshHighScore){
        snakeBody = refreshSnakeBody;
        curApple = refreshApple;
        score = refreshScore;
        highScore = refreshHighScore;
    }
}
