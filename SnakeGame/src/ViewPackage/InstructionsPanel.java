package ViewPackage;

import GameModel.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class InstructionsPanel extends JPanel {
    private View gameView;
    private Color backgroundColor = new Color(Constants.BACKGROUND_COLOR_RED, Constants.BACKGROUND_COLOR_GREEN,
            Constants.BACKGROUND_COLOR_BLUE);
    private Font font = new Font(Font.SANS_SERIF, Font.BOLD, Constants.PANELS_FONT_SIZE);
    private Color fontColor = Color.BLACK;
    private Font newFont = new Font(font.getFontName(), Font.BOLD, font.getSize() - 2);

    public InstructionsPanel(View view){
        gameView = view;
        this.setOpaque(true);
        this.setBackground(backgroundColor);
        this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT);
        this.setLayout(null);
        addBackToMenuButton();
        addArrowsImage();
    }

    private void addArrowsImage(){
        ImageIcon icon = new ImageIcon("src\\resources\\arrows.jpg");
        icon = new ImageIcon(icon.getImage().getScaledInstance(Constants.BUTTON_WIDTH,
                Constants.BUTTON_HIGHT*2, Image.SCALE_DEFAULT));
        JLabel arrows = new JLabel(icon);
        arrows.setBounds(Constants.CELL_WIDTH*Constants.INDENT + font.getSize()*7 ,
                Constants.FRAME_HIGHT/5 - font.getSize(),
                Constants.BUTTON_WIDTH, Constants.BUTTON_HIGHT*2);
        this.add(arrows);
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
        g.setFont(font);
        g.setColor(fontColor);
        g.drawString("To move your snake use ", Constants.CELL_WIDTH*Constants.INDENT,
                Constants.CELL_HIGHT * Constants.INDENT);
        g.drawString("this keyboard keys:", Constants.CELL_WIDTH*Constants.INDENT,
                Constants.CELL_HIGHT * Constants.INDENT  + font.getSize() );
        g.drawString("Press P to pause the game", Constants.CELL_WIDTH*Constants.INDENT,
                Constants.FRAME_HIGHT/2);
    }
}
