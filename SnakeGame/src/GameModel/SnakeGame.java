package GameModel;

import ControllerPackage.Controller;
import ControllerPackage.GameDifficulty;
import ViewPackage.View;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
//import java.util.MyObservable;

public class SnakeGame extends MyObservable {
    private int score = 0;
    private Snake snake = new Snake();
    private int highScore = 0;
    private boolean newGame, gameOver = false;
    private Point curApple = null;
    private GameDifficulty difficulty = GameDifficulty.EASY;
    private int[] highScores = {0, 0, 0};

    public SnakeGame(Controller controller) throws IOException {
        generateApple();
        snake = new Snake();
        score = 0;
        newGame = false;
        loadData();
    }

    public void moveSnake(){
        int beginLength = snake.getSnakeLength();
        if(!snake.move(curApple)){
            gameOver();
            notifyObservers();
            return;
        }

        if (beginLength < snake.getSnakeLength()){
            score++;
            generateApple();
        }
        notifyObservers();
    }

    private void gameOver(){
        gameOver = true;
        if (score > highScore){
            highScore = score;
            switch(difficulty){
                case EASY:
                    if(score > highScores[0])
                        highScores[0] = score;
                    break;
                case MEDIUM:
                    if(score > highScores[1])
                        highScores[1] = score;
                    break;
                case HARD:
                    if(score > highScores[2])
                        highScores[2] = score;
                    break;
                default:
                    break;
            }
        }
        newGame = true;
    }

    private void generateApple(){
        int x = (int)( Math.random() * Constants.CELLS_AMOUNT_IN_LINE );
        int y = (int)(Math.random() * Constants.CELLS_AMOUNT_IN_LINE);
        while (snake.snakeBody.contains(new Point(x,y))){
            x = (int)( Math.random() * Constants.CELLS_AMOUNT_IN_LINE );
            y = (int)(Math.random() * Constants.CELLS_AMOUNT_IN_LINE);
        }
        curApple = new Point(x,y);
    }

    public void setDirection(Direction newDirection){
        snake.setDirection(newDirection);
    }

    private void clearModel(){
        snake = new Snake();
        score = 0;
        newGame = true;
        generateApple();
    }

    public void startGame(){
        if (newGame){
            snake = new Snake();
            score = 0;
            newGame = false;
            generateApple();
            gameOver = false;
        }
        notifyObservers();
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public Direction getDirection(){
        return snake.getCurDirection();
    }

    public void changeDifficulty(GameDifficulty newDifficulty){
        difficulty = newDifficulty;
        highScore = 0;
    }

    public ArrayDeque<Point> getSnakeBody(){
        return snake.snakeBody;
    }

    public Point getCurApple(){
        return curApple;
    }

    private void loadData() throws IOException{
        Path pathToFile = Paths.get("./SnakeData.txt");
        String line;
        if (Files.exists(pathToFile)) {
            InputStream in = Files.newInputStream(pathToFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            int index = 0;
            while ((line = reader.readLine()) != null && index < 3) {
                if (line.length() > 0)
                    highScores[index] = Integer.parseInt(line);
                index++;
            }
            reader.close();
        }
    }

    private void saveData() throws IOException{
        Path pathToFile = Paths.get("./SnakeData.txt");
        OutputStream out = Files.newOutputStream(pathToFile);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        for(int score : highScores){
            writer.write(Integer.toString(score));
            writer.newLine();
        }
        writer.close();
    }

    public int[] getHighScores(){
        return highScores;
    }

    public void quit() throws IOException{
        saveData();
    }

    public int getCurrentScore(){
        return score;
    }

    public int getHighScore(){
        return highScore;
    }
}
