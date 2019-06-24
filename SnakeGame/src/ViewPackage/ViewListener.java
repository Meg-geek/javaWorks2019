package ViewPackage;

import ControllerPackage.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewListener implements KeyListener {
    private Controller controller;
    private boolean isGameOver = false;

    public ViewListener(Controller controllerToSet){
        controller = controllerToSet;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.directionKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setGameOver(boolean isGameOverNew){
        isGameOver = isGameOverNew;
    }
}
