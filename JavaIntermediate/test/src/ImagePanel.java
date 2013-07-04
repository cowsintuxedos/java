import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class ImagePanel extends JPanel {
    BufferedImage image;
 
    public ImagePanel(BufferedImage image) {
        this.image = image;
    }
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw image centered.
        int x = (getWidth() - image.getWidth())/2;
        int y = (getHeight() - image.getHeight())/2;
        g.drawImage(image, x, y, this);
    }
 
    public static void main(String[] args) throws IOException {
        String path = "images/sand.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        ImagePanel contentPane = new ImagePanel(image);
        // You'll want to be sure this component is opaque
        // since it is required for contentPanes. Some
        // LAFs may use non-opaque components.
        contentPane.setOpaque(true);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        // Add components.
        for(int j = 0; j < 8; j++) {
            gbc.gridwidth = ((j+1)%2 == 0) ? GridBagConstraints.REMAINDER
                                           : GridBagConstraints.RELATIVE;
            contentPane.add(new JButton("button " + (j+1)), gbc);
        }
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(contentPane);
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
