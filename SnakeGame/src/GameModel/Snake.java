package GameModel;

import java.util.*;
import java.awt.Point;

public class Snake {
    public ArrayDeque<Point> snakeBody = new ArrayDeque<Point>();
    private static final int BEGIN_LENGTH = 3;
    private int length = BEGIN_LENGTH;
    private Direction direction = Direction.UP;

    public Snake(){
        for (int i = 0; i < 3; i++) {
            snakeBody.addFirst(new Point(Constants.CELLS_AMOUNT_IN_LINE /2,
                    Constants.CELLS_AMOUNT_IN_LINE /2 - i));
        }
    }

    public boolean move(Point appleLocation){
        int newHeadX = snakeBody.getFirst().x, newHeadY = snakeBody.getFirst().y;
        switch(direction){
            case UP:
                --newHeadY;
                break;
            case DOWN:
                ++newHeadY;
                break;
            case LEFT:
                --newHeadX;
                break;
            case RIGHT:
                ++newHeadX;
                break;
            default:
                break;
        }
        if (!cellIsCorrect(newHeadX, newHeadY)){
            return false;
        }

        snakeBody.addFirst(new Point(newHeadX, newHeadY));
        ++length;
        if (appleLocation.x != newHeadX || appleLocation.y != newHeadY) {
            snakeBody.removeLast();
            --length;
        } else {
            ++length;
        }
        return true;
    }

    public int getSnakeLength(){
        return length;
    }

    public void setDirection(Direction newDirection){
        direction = newDirection;
    }

    public Direction getCurDirection(){
        return direction;
    }

    private boolean cellIsCorrect(int newX, int newY){
        boolean isPositive = (newX >= 0) && (newY >= 0);
        boolean isInField = (newX < Constants.CELLS_AMOUNT_IN_LINE) && (newY < Constants.CELLS_AMOUNT_IN_LINE);
        boolean isntSnake = !snakeBody.contains(new Point(newX, newY));
        return (isInField && isntSnake && isPositive);
    }
}
