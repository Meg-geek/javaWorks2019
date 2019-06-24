package ViewPackage;

import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameOverPanel extends JPanel {
    private Color backgroundColor = new Color(Constants.BACKGROUND_COLOR_RED, Constants.BACKGROUND_COLOR_GREEN,
            Constants.BACKGROUND_COLOR_BLUE);
    private int score;
    private int highScore;
    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, Constants.PANELS_FONT_SIZE);
    private Color fontColor = Color.BLACK;
    private View gameView;
    private Font newFont = new Font(font.getFontName(), Font.BOLD, font.getSize() - 2);

    public GameOverPanel(int scoreGame, int highScoreGame, View view){
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT);
        score = scoreGame;
        highScore = highScoreGame;
        this.setLayout(null);
        gameView = view;
        addYesNo();
    }

    private void addYesNo(){
        JLabel yesButton = new JLabel("Yes");
        JLabel noButton = new JLabel("No");
        yesButton.setForeground(fontColor);
        noButton.setForeground(fontColor);
        noButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    gameView.goToMenu();
                } catch(IOException ex){
                    ex.printStackTrace();
                    System.exit(1);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                noButton.setFont(newFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                noButton.setFont(font);
            }
        });

        yesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameView.continueGame();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                yesButton.setFont(newFont);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                yesButton.setFont(font);
            }
        });
        yesButton.setFont(font);
        noButton.setFont(font);
        this.add(yesButton);
        this.add(noButton);
        yesButton.setBounds(Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/3,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3  + Constants.PANELS_FONT_SIZE * 5,
                Constants.PANELS_FONT_SIZE *2 , Constants.PANELS_FONT_SIZE);
        noButton.setBounds(Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/3 + Constants.BUTTON_WIDTH/2,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3  + Constants.PANELS_FONT_SIZE * 5,
                Constants.PANELS_FONT_SIZE *2 , Constants.PANELS_FONT_SIZE);
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(fontColor);
        g.setFont(font);
        g.drawString("Your score: " + Integer.toString(score),
                Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/3,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3
                );
        g.drawString("Highscore: " + Integer.toString(highScore),
                Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/3,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3  + Constants.PANELS_FONT_SIZE * 2
        );
        g.drawString("Try again?", Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/3,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3  + Constants.PANELS_FONT_SIZE * 4);

    }
}
