package ViewPackage;

import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ScoresPanel extends JPanel {
    private View gameView;
    private Color backgroundColor = new Color(Constants.BACKGROUND_COLOR_RED, Constants.BACKGROUND_COLOR_GREEN,
            Constants.BACKGROUND_COLOR_BLUE);
    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, Constants.PANELS_FONT_SIZE);
    private Color fontColor = Color.BLACK;
    private Font newFont = new Font(font.getFontName(), Font.BOLD, font.getSize() - 2);
    int easyHighScore = 0;
    int mediumHighScore = 0;
    int hardHighScore = 0;

    public ScoresPanel(View view, int[] highScores){
        gameView = view;
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT);
        this.setLayout(null);
        if (highScores.length >= 3){
            easyHighScore = highScores[0];
            mediumHighScore = highScores[1];
            hardHighScore = highScores[2];
        }
        addBackToMenuButton();
    }

    private void addBackToMenuButton(){
        JLabel button = new JLabel("BACK TO MENU");
        button.setForeground(fontColor);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameView.goToMenu();
                } catch(IOException ex) {
                    ex.printStackTrace();
                    System.exit(1);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(newFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(font);
            }
        });
        button.setFont(font);
        this.add(button);
        button.setBounds(Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/4,
                Constants.FRAME_HIGHT - Constants.CELL_HIGHT * 7,
                Constants.PANELS_FONT_SIZE *10 , Constants.PANELS_FONT_SIZE);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(fontColor);
        g.setFont(font);
//        g.drawString("HIGHSCORES", Constants.CELL_WIDTH*Constants.INDENT,
//                Constants.CELL_HIGHT *Constants.INDENT);
        g.drawString("DIFFICULTY/HIGHSCORE", Constants.CELL_WIDTH*Constants.INDENT,
                Constants.CELL_HIGHT *Constants.INDENT + font.getSize()*2);
        g.drawString("EASY: " + Integer.toString(easyHighScore), Constants.CELL_WIDTH*Constants.INDENT,
                Constants.CELL_HIGHT *Constants.INDENT + font.getSize()*4);
        g.drawString("MEDIUM: " + Integer.toString(mediumHighScore), Constants.CELL_WIDTH*Constants.INDENT,
                Constants.CELL_HIGHT *Constants.INDENT + font.getSize()*6);
        g.drawString("HARD: " + Integer.toString(hardHighScore), Constants.CELL_WIDTH*Constants.INDENT,
                Constants.CELL_HIGHT *Constants.INDENT + font.getSize()*8);
    }
}
