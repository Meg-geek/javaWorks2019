package ViewPackage;

import ControllerPackage.Controller;
import ControllerPackage.GameDifficulty;
import GameModel.Constants;
import GameModel.MyObserver;
import GameModel.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayDeque;

public class View implements MyObserver {
    private SnakeGame gameModel;
    private GameMenuView menuView;
    private JFrame gameFrame;
    private GameProcessPanel gameProcessPanel;
    private GameOverPanel gameOverPanel;
    private ViewListener viewListener;// = new ViewListener();
    private Controller gameController;
    private GameDifficulty difficulty = GameDifficulty.EASY;
    private SetDifficultyPanel setDifficultyPanel;
    private InstructionsPanel instructionsPanel;
    private ScoresPanel scoresPanel;

    public void update(){
        update(gameModel.getSnakeBody(), gameModel.getCurApple(), gameModel.getCurrentScore(),
                gameModel.getHighScore());
    }

    public void update(ArrayDeque<Point> updatedSnakeBody, Point updatedApple, int updatedScore,
                       int highScore){
        if (gameModel.isGameOver()){
            gameOverPanel = new GameOverPanel(updatedScore, highScore, this);
            gameFrame.setContentPane(gameOverPanel);
            gameFrame.setVisible(true);
        }
        gameProcessPanel.refreshInfo(updatedSnakeBody, updatedApple, updatedScore, highScore);
        gameProcessPanel.repaint();
    }

    public View(SnakeGame model, Controller controller) throws IOException {
        gameModel = model;
        setGameFrame();
        menuView = new GameMenuView(gameFrame, this);
        gameController = controller;
        viewListener = new ViewListener(controller);
    }

    public void goToMenu()throws IOException{
        menuView = new GameMenuView(gameFrame, this);
    }

    private void setGameFrame(){
        gameFrame = new JFrame(Constants.GAME_NAME);
        Image icon = Toolkit.getDefaultToolkit().createImage("src\\resources\\snakeIcon.jpg");
        gameFrame.setIconImage(icon);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
    }

    public void continueGame(){
        gameProcessPanel = new GameProcessPanel(gameModel.getSnakeBody(), gameModel.getCurApple(), difficulty);
        gameFrame.setContentPane(gameProcessPanel);
        gameFrame.addKeyListener(viewListener);
        gameFrame.setVisible(true);
        gameModel.startGame();
    }

    public void startGame(){
        gameProcessPanel = new GameProcessPanel(gameModel.getSnakeBody(), gameModel.getCurApple(), difficulty);
        gameFrame.setContentPane(gameProcessPanel);
        gameFrame.addKeyListener(viewListener);
        gameFrame.setVisible(true);
        gameModel.startGame();
    }

    public void setDifficulty(){
        setDifficultyPanel = new SetDifficultyPanel(this);
        gameFrame.setContentPane(setDifficultyPanel);
        gameFrame.setVisible(true);
    }

    public void changeDifficulty(GameDifficulty newDifficulty){
        if (setDifficultyPanel.changeDifficulty()){
            difficulty = newDifficulty;
            gameController.setDifficulty(difficulty);
            gameModel.changeDifficulty(newDifficulty);
        }
    }

    public void goToInstructions(){
        instructionsPanel = new InstructionsPanel(this);
        gameFrame.setContentPane(instructionsPanel);
        gameFrame.setVisible(true);
    }

    public void goToScores(){
        scoresPanel = new ScoresPanel(this, gameModel.getHighScores());
        gameFrame.setContentPane(scoresPanel);
        gameFrame.setVisible(true);
    }

    public void quit() {
        try{
            gameModel.quit();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
