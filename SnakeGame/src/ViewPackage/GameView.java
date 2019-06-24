package ViewPackage;

import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GameView {
    private JFrame gameFrame;
    private BackgroundView background;

    public GameView() throws IOException {
        background = new BackgroundView("main.jpg");
        gameFrame = new JFrame(Constants.GAME_NAME);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtons();
        gameFrame.setContentPane(background);
        //gameFrame.add(background);
        gameFrame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    private void addButtons(){
//        ImageIcon icon = createImageIcon("buttonStart.jpg");
//       icon = new ImageIcon(icon.getImage()
//               .getScaledInstance(Constants.BUTTON_WIDTH,Constants.BUTTON_HIGHT , Image.SCALE_DEFAULT) );
//        JLabel button = new JLabel(icon);
//       // button.setOpaque(false);
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("Button was clicked");
//            }
//        });
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(5,1));
        panel.add(makeStartButton());
        panel.add(makeDiffButton());
        panel.add(makeInstrButton());
        panel.add(makeScoresButton());
        panel.add(makeExitButton());
        background.add(panel, BorderLayout.EAST);
        //background.add(button, BorderLayout.EAST);
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private JLabel makeJLabel(String path){
        ImageIcon icon = createImageIcon(path);
        icon = new ImageIcon(icon.getImage()
                .getScaledInstance(Constants.BUTTON_WIDTH,Constants.BUTTON_HIGHT , Image.SCALE_DEFAULT) );
        JLabel button = new JLabel(icon);
        return button;
    }

    private ImageIcon getSmallerIcon(String path){
        ImageIcon icon = createImageIcon(path);
        icon = new ImageIcon(icon.getImage()
                .getScaledInstance(Constants.BUTTON_WIDTH - Constants.CELL_WIDTH/2,
                        Constants.BUTTON_HIGHT - Constants.CELL_HIGHT/2, Image.SCALE_DEFAULT) );
        return icon;
    }

    private JLabel makeStartButton(){
        JLabel startButton = makeJLabel("buttonStart.jpg");
        startButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start was clicked");
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = startButton.getIcon();
                startButton.setIcon(getSmallerIcon("buttonStart.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(icon);
            }
        });
        return startButton;
    }

    private JLabel makeDiffButton(){
        JLabel diffButton = makeJLabel("buttonDif.jpg");
        diffButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Difficulty was clicked");
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = diffButton.getIcon();
                diffButton.setIcon(getSmallerIcon("ButtonDif.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                diffButton.setIcon(icon);
            }
        });
        return diffButton;
    }

    private JLabel makeInstrButton(){
        JLabel instrButton = makeJLabel("buttonInstr.jpg");
        instrButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Instructions was clicked");
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = instrButton.getIcon();
                instrButton.setIcon(getSmallerIcon("ButtonInstr.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                instrButton.setIcon(icon);
            }
        });
        return instrButton;
    }

    private JLabel makeScoresButton(){
        JLabel scoresButton = makeJLabel("buttonScores.jpg");
        scoresButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Scores was clicked");
            }
        });
        return scoresButton;
    }

    private JLabel makeExitButton(){
        JLabel exitButton = makeJLabel("buttonExit.jpg");
        exitButton.addMouseListener(new MouseAdapter() {
            private Icon icon;
            @Override
            public void mouseClicked(MouseEvent e) {
                gameFrame.dispatchEvent(new WindowEvent(gameFrame, WindowEvent.WINDOW_CLOSING));
            }
            @Override
            public void mouseEntered(MouseEvent e){
                icon = exitButton.getIcon();
                exitButton.setIcon(getSmallerIcon("buttonExit.jpg"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(icon);
            }
        });
        return exitButton;
    }

}
