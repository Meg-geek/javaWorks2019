package GameModel;

public class Cell {
    private int x, y;
    private int state;

    public Cell(int beginX, int beginY, int beginState){
        x = beginX;
        y = beginY;
        state = beginState;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getState(){
        return state;
    }

    public void setState(int newState){
        state = newState;
    }

    public void update(boolean needUpdate){
        if (needUpdate && (state > 0)){
            state--;
        }
    }

    //клетка решает, как она выглядит
    Object getCell(){
        if (state == 0)
            return null;
        if (state > 0)
            return null; //snake body
        if (state < 0)
            return null;
        return null;
    }
}
