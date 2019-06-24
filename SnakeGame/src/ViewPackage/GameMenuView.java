package ViewPackage;

import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

public class GameMenuView {
    private JFrame gameFrame;
    private BackgroundView background;
    private View gameView;

    public GameMenuView(JFrame frame, View view) throws IOException{
        gameFrame = frame;
        gameView = view;
        showMenu();
    }

    public void showMenu() throws IOException {
        background = new BackgroundView("src\\resources\\main.jpg");
        addButtons();
        gameFrame.setContentPane(background);
        gameFrame.setVisible(true);
    }

    private void addButtons(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(5,1));
        panel.add(makeStartButton());
        panel.add(makeDiffButton());
        panel.add(makeInstrButton());
        panel.add(makeScoresButton());
        panel.add(makeExitButton());
        background.add(panel, BorderLayout.EAST);
    }

    private JLabel makeJLabel(String path){
        ImageIcon icon = new ImageIcon(path);
        icon = new ImageIcon(icon.getImage()
                .getScaledInstance(Constants.BUTTON_WIDTH,Constants.BUTTON_HIGHT , Image.SCALE_DEFAULT) );
        JLabel button = new JLabel(icon);
        return button;
    }

    private ImageIcon getSmallerIcon(String path){
        ImageIcon icon = new ImageIcon(path);
        icon = new ImageIcon(icon.getImage()
                .getScaledInstance(Constants.BUTTON_WIDTH - Constants.CELL_WIDTH/2,
                        Constants.BUTTON_HIGHT - Constants.CELL_HIGHT/2, Image.SCALE_DEFAULT) );
        return icon;
    }

    private JLabel makeStartButton(){
        JLabel startButton = makeJLabel("src\\resources\\buttonStart.jpg");
        startButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                gameView.startGame();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = startButton.getIcon();
                startButton.setIcon(getSmallerIcon("src\\resources\\buttonStart.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(icon);
            }
        });
        return startButton;
    }

    private JLabel makeDiffButton(){
        JLabel diffButton = makeJLabel("src\\resources\\buttonDif.jpg");
        diffButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                gameView.setDifficulty();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = diffButton.getIcon();
                diffButton.setIcon(getSmallerIcon("src\\resources\\ButtonDif.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){

                diffButton.setIcon(icon);
            }
        });
        return diffButton;
    }

    private JLabel makeInstrButton(){
        JLabel instrButton = makeJLabel("src\\resources\\buttonInstr.jpg");
        instrButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                gameView.goToInstructions();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = instrButton.getIcon();
                instrButton.setIcon(getSmallerIcon("src\\resources\\ButtonInstr.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                instrButton.setIcon(icon);
            }
        });
        return instrButton;
    }

    private JLabel makeScoresButton(){
        JLabel scoresButton = makeJLabel("src\\resources\\buttonScores.jpg");
        scoresButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                gameView.goToScores();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = scoresButton.getIcon();
                scoresButton.setIcon(getSmallerIcon("src\\resources\\buttonScores.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                scoresButton.setIcon(icon);
            }
        });
        return scoresButton;
    }

    private JLabel makeExitButton(){
        JLabel exitButton = makeJLabel("src\\resources\\buttonExit.jpg");
        exitButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e){
                gameView.quit();
                gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = exitButton.getIcon();
                exitButton.setIcon(getSmallerIcon("src\\resources\\buttonExit.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(icon);
            }
        });
        return exitButton;
    }

}
