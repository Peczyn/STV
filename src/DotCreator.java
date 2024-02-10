import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class DotCreator {
    public static boolean threadRunning = false;
    public static boolean isRunning = false;
    public static int dotsLimit = 1000;
    static ArrayList<Ellipse2D> dots = new ArrayList<>();

    DotCreator(){
        dots.add(new Ellipse2D.Float((float) 345, (float) 45,10,10));
        dots.add(new Ellipse2D.Float(95, 545,10,10));
        dots.add(new Ellipse2D.Float(595,545,10,10));

        System.out.println(DotThread.currentThread().isAlive());
        if(!threadRunning){
            (new DotCreator.DotThread()).start();
        }


//        (new DotCreator.DotThread()).start();
    }

    static class DotThread extends Thread{
        @Override
        public void run(){
            threadRunning = true;
            while(true) {
                while(isRunning && dots.size()<dotsLimit+3) {
                    Random rand = new Random();
                    int corner = rand.nextInt(3);


                    float x = ((float) dots.getLast().getX() + (float) dots.get(corner).getX()) / 2;
                    float y = ((float) dots.getLast().getY() + (float) dots.get(corner).getY()) / 2;

                    dots.add(new Ellipse2D.Float(x+2, y+2, 2, 2));

                    try {
                        sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }




}
