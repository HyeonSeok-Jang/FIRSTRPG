package Test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlphaTest implements AdjustmentListener
{
 private JFrame frame;
 private Canvas canvas;
 private JScrollBar jsp;
 private Image image;
 private AlphaComposite alphaComposite;
 private Label label;
 
 public AlphaTest()
 {
  image = Toolkit.getDefaultToolkit().getImage("src\\Source\\BackGround\\GIF\\메인화면-용사.png"); //원하는 이미지
  frame = new JFrame();
 
  jsp = new JScrollBar();
  jsp.addAdjustmentListener(this);
  jsp.setMaximum(265);
  jsp.setMinimum(0);
  image = Toolkit.getDefaultToolkit().getImage("src\\Source\\BackGround\\GIF\\메인화면-용사.png");
  label = new Label("alpha = " + jsp.getValue());
 
  canvas = new Canvas(){
   public void paint(Graphics g)
   {   
    alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)jsp.getValue()/255); //alpha값
    Graphics2D g2 = (Graphics2D)g;
    g2.setComposite(alphaComposite);
    g2.drawImage(image, 0, 0, this);   
   }
  };
  frame.add(canvas, BorderLayout.CENTER);
  frame.add(jsp, BorderLayout.EAST);
  frame.add(label, BorderLayout.SOUTH);
  frame.setSize(300,300);
  frame.setVisible(true);
 }

 public void adjustmentValueChanged(AdjustmentEvent e)
 {
 
  if(label != null)
   label.setText("alpha = " + jsp.getValue());
  if(canvas != null)
   canvas.repaint();
 }

 public static void main(String[] args)
 {
  new AlphaTest();
 }
}

