package ViewPackage;

import GameModel.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundView extends JPanel {
      private Image backgroundImage;

      public BackgroundView(){}

      public BackgroundView(String imagePath) throws IOException {
          backgroundImage = ImageIO.read(new File(imagePath)).
                 getScaledInstance(Constants.FRAME_WIDTH, Constants.FRAME_HIGHT, Image.SCALE_DEFAULT) ;
          this.setLayout(new BorderLayout());
      }
      @Override
      public void paintComponent(Graphics g){
        g.drawImage(backgroundImage, 0, 0, null);
      }
}
