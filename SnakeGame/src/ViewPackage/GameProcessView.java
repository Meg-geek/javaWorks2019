package ViewPackage;

import GameModel.Constants;
import GameModel.Snake;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayDeque;

public class GameProcessView {
    private JFrame gameFrame;
    private View gameView;
    private BackgroundView background;
    private ArrayDeque<Point> snakeBody;
    private Point curApple;
    private Color snakeColor = new Color(Constants.SNAKEBODY_COLOR_RED, Constants.SNAKEBODY_COLOR_GREEN,
            Constants.SNAKEBODY_COLOR_BLUE);

    public GameProcessView(JFrame frame, View view, ArrayDeque<Point> beginSnakeBody, Point beginApple) throws IOException {
        gameFrame = frame;
        gameView = view;
        background = new BackgroundView("fieldBackground.jpg");
        snakeBody = beginSnakeBody;
        curApple = beginApple;
    }

    public void startGame(){

        gameFrame.setContentPane(background);
        gameFrame.setVisible(true);
    }
}
