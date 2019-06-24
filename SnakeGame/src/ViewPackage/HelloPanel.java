package ViewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HelloPanel extends JPanel {

    public HelloPanel(){
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.GRAY);


    }

}
