import javax.swing.*;
import java.awt.*;


public class TJPanel extends JPanel{
    TJPanel() {
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.f),Color.BLACK)); //ustawiamy obrzeza Jpanelu
        (new AnimationThread()).start();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        for(int i=3; i< DotCreator.dots.size(); i++)
        {
            g2d.setColor(Color.darkGray);
            g2d.fill(DotCreator.dots.get(i));
            g2d.setColor(Color.black);
            g2d.draw(DotCreator.dots.get(i));
        }

        for(int i=0; i<3; i++)
        {
            g2d.setColor(Color.red);
            g2d.fill(DotCreator.dots.get(i));
            g2d.setColor(Color.black);
            g2d.draw(DotCreator.dots.get(i));
        }

        g2d.drawString("Current dots:"+ (DotCreator.dots.size()-3), 30,30);
    }


    class AnimationThread extends Thread{
        @Override
        public void run(){
            while(true)
            {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
            }
        }
    }


}
