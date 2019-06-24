package ViewPackage;

import ControllerPackage.GameDifficulty;
import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SetDifficultyPanel extends JPanel {
    private Color backgroundColor = new Color(Constants.BACKGROUND_COLOR_RED, Constants.BACKGROUND_COLOR_GREEN,
            Constants.BACKGROUND_COLOR_BLUE);
    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, Constants.PANELS_FONT_SIZE);
    private Color fontColor = Color.BLACK;
    private View gameView;
    private boolean changeDif = false;
    private Font newFont = new Font(font.getFontName(), Font.BOLD, font.getSize() - 2);

    public SetDifficultyPanel(View view){
        gameView = view;
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(Constants.FRAME_WIDTH, Constants.FIELD_HIGHT);
        this.setLayout(null);
        addEasy();
        addMedium();
        addHard();
    }

    private void setForegroundAndFont(JLabel label){
        label.setForeground(backgroundColor);
        label.setFont(font);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(fontColor);
        g.setFont(font);
        g.drawString("Choose difficulty:", Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/4,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3);
    }

    public boolean changeDifficulty(){
        if (changeDif == true){
            changeDif = false;
            return true;
        }
        return changeDif;
    }

    private void addEasy(){
        JLabel easyButton = new JLabel("EASY");
        easyButton.setForeground(fontColor);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeDif = true;
                gameView.changeDifficulty(GameDifficulty.EASY);
                try{
                    gameView.goToMenu();
                } catch(IOException ex){
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                easyButton.setFont(newFont);
            }
            @Override
            public void mouseExited(MouseEvent e){
                easyButton.setFont(font);
            }
        });
        easyButton.setFont(font);
        this.add(easyButton);
        easyButton.setBounds(Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/4,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3 + font.getSize(),
                Constants.PANELS_FONT_SIZE *4 , Constants.PANELS_FONT_SIZE);
    }

    private void addMedium(){
        JLabel mediumButton = new JLabel("MEDIUM");
        mediumButton.setForeground(fontColor);
        mediumButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeDif = true;
                gameView.changeDifficulty(GameDifficulty.MEDIUM);
                try{
                    gameView.goToMenu();
                } catch(IOException ex){
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                mediumButton.setFont(newFont);
            }
            @Override
            public void mouseExited(MouseEvent e){
                mediumButton.setFont(font);
            }
        });
        mediumButton.setFont(font);
        this.add(mediumButton);
        mediumButton.setBounds(Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/4,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3 + font.getSize()*3,
                Constants.PANELS_FONT_SIZE *5 , Constants.PANELS_FONT_SIZE);
    }

    private void addHard(){
        JLabel hardButton = new JLabel("HARD");
        hardButton.setForeground(fontColor);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeDif = true;
                gameView.changeDifficulty(GameDifficulty.HARD);
                try{
                    gameView.goToMenu();
                } catch(IOException ex){
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                hardButton.setFont(newFont);
            }
            @Override
            public void mouseExited(MouseEvent e){
                hardButton.setFont(font);
            }
        });
        hardButton.setFont(font);
        this.add(hardButton);
        hardButton.setBounds(Constants.CELL_HIGHT * Constants.CELLS_AMOUNT_IN_LINE/4,
                Constants.CELL_WIDTH * Constants.CELLS_AMOUNT_IN_LINE/3 + font.getSize()*5,
                Constants.PANELS_FONT_SIZE *5 , Constants.PANELS_FONT_SIZE);
    }
}
