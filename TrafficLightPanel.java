import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TrafficLightPanel extends JPanel implements ActionListener {
  
  JRadioButton redButton;
  JRadioButton yelButton;
  JRadioButton greButton;

  Color redColor;
  Color yelColor;
  Color greColor;

  TrafficLightPanel() {

    setBounds(0, 0, 250, 350);
    setBackground(Color.WHITE);
    redButton = new JRadioButton("Stop");
    yelButton = new JRadioButton("Wait");
    greButton = new JRadioButton("Go");

    redButton.setSelected(true);
    redColor = Color.RED;
    yelColor = Color.GRAY;
    greColor = Color.GRAY;

    ButtonGroup gp = new ButtonGroup();
    gp.add(redButton);
    gp.add(yelButton);
    gp.add(greButton);

    add(redButton);
    add(yelButton);
    add(greButton);

    redButton.addActionListener(this);
    yelButton.addActionListener(this);
    greButton.addActionListener(this);

  }

  public void actionPerformed(ActionEvent e) {

    if(redButton.isSelected() == true) {
      redColor = Color.RED;
      yelColor = Color.GRAY;
      greColor = Color.GRAY;
    }

    else if(yelButton.isSelected() == true) {
      redColor = Color.GRAY;
      yelColor = Color.YELLOW;
      greColor = Color.GRAY;
    }

    else if (greButton.isSelected() == true) {
      redColor = Color.GRAY;
      yelColor = Color.GRAY;
      greColor = Color.GREEN;
    }

    repaint();
  }

  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    g.setColor(Color.BLACK);
    g.fillRect(50, 50, 150, 250);

    g.setColor(redColor);
    g.fillOval(100,80,50,50);

    g.setColor(yelColor);
    g.fillOval(100,150,50,50);

    g.setColor(greColor);
    g.fillOval(100,220,50,50);
  }

}

class TrafficLight {

  public static void main(String[] args) {

    JFrame frame = new JFrame();

    frame.setLayout(null);
    frame.setSize(250,350);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    TrafficLightPanel t = new TrafficLightPanel();
    frame.add(t);
  }
}

