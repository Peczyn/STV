import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Main extends JFrame {
    TJPanel tjpanel = new TJPanel();

    Main(){
        super("Sierpinski Triangle");
        buildGui();
        new DotCreator();
    }
    void buildGui()
    {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();


        JLabel dotsToMake = new JLabel("Dots to create:");


        Integer[] options = {100,500,1000,2500,5000,10000};
        JComboBox<Integer> comboBox = new JComboBox<>(options);
        comboBox.setSelectedItem(1000);

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        start.addActionListener(e -> DotCreator.isRunning = true);
        stop.addActionListener(e -> DotCreator.isRunning = false);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DotCreator.isRunning = false;
                DotCreator.dots.clear();
                new DotCreator();
                DotCreator.dotsLimit = (int)comboBox.getSelectedItem();
            }
        });

        northPanel.add(dotsToMake);
        northPanel.add(comboBox);
        northPanel.add(start);
        northPanel.add(stop);

        root.add(northPanel, BorderLayout.NORTH);
        root.add(tjpanel, BorderLayout.CENTER);

        setContentPane(root);
    }


    public static void main(String[] args) {
        Main jf = new Main();
        jf.setSize(700,700);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setVisible(true);



    }
}