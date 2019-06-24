package ControllerPackage;

import GameModel.Constants;
import GameModel.Direction;
import GameModel.SnakeGame;
import ViewPackage.View;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Controller {
    private ActionListener taskPerformer;
    private Timer timer;
    private int timerDelay = Constants.DIFFICULTY_EASY;
    private SnakeGame gameModel;
    private boolean buttonPressed;
    private boolean gameIsPaused = false;
    private boolean isGameStarted = false;
    private GameDifficulty difficulty = GameDifficulty.EASY;
    private View view;

    public Controller() throws IOException {
        gameModel = new SnakeGame(this);
        view = new View(gameModel, this);
        gameModel.addObserver(view);
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModel.moveSnake();
                if (gameModel.isGameOver()){
                    gameOver();
                }
            }
        };
    }

    public void go(){
        timer = new Timer(timerDelay, taskPerformer);
    }

    public void directionKeyPressed(KeyEvent pressedButton){
        int keyPressed = pressedButton.getKeyCode();
        if (!isGameStarted){
            isGameStarted = true;
            timer.start();
        }
        Direction curDir = gameModel.getDirection();
        switch (keyPressed){
            case KeyEvent.VK_UP:
                if (curDir != Direction.DOWN) {
                    gameModel.setDirection(Direction.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (curDir != Direction.UP) {
                    gameModel.setDirection(Direction.DOWN);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (curDir != Direction.RIGHT) {
                    gameModel.setDirection(Direction.LEFT);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (curDir != Direction.LEFT) {
                    gameModel.setDirection(Direction.RIGHT);
                }
                break;
            case KeyEvent.VK_P:
                if (!gameIsPaused){
                    gameIsPaused = true;
                    timer.stop();
                } else {
                    gameIsPaused = false;
                    timer.start();
                }
            default:
                break;
        }
    }

    public void setDifficulty(GameDifficulty difficulty){
        if (difficulty == GameDifficulty.EASY){
            timerDelay = Constants.DIFFICULTY_EASY;
        }
        if (difficulty == GameDifficulty.MEDIUM){
            timerDelay = Constants.DIFFICULTY_MEDIUM;
        }
        if (difficulty == GameDifficulty.HARD){
            timerDelay = Constants.DIFFICULTY_HARD;
        }
        timer = new Timer(timerDelay, taskPerformer);
    }

    private void gameOver(){
        timer.stop();
        isGameStarted = false;
    }

    public void startNewGame(){
        timer.start();
    }
}
