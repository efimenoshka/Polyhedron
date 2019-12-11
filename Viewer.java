import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {

    private Cube cube;

    public Viewer (Cube c) {
        cube = c;
        setSize(360,360);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.WHITE);
        g2d.clearRect(0,0, getWidth(),getHeight());

        //super.paintComponents(g);

        g2d.setColor(new Color (0, 0, 0, 254));
        g2d.translate(getWidth()/2,getHeight()/2);

        g2d.drawLine(0-getWidth()/2,0,getWidth()/2,0);
        g2d.drawLine(0,0-getHeight()/2,0,getHeight()/2);

        cube.draw(g2d);




    }


}
