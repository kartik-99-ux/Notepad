
package nodepad;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class about  extends JFrame implements ActionListener
{       JButton b;
      about()
      {
          setBounds(600,200,700,600);
          Image icon=Toolkit.getDefaultToolkit().getImage("nodepad/icons/xyz.png");
          this.setIconImage(icon);
          setLayout(null);
          this.getContentPane().setBackground(Color.WHITE);
       
          ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("nodepad/icons/windows.png"));
          Image i=img1.getImage().getScaledInstance(400,80,Image.SCALE_DEFAULT);
          ImageIcon img2=new ImageIcon(i);
          JLabel lebel=new JLabel(img2);
          lebel.setBounds(150, 50,400,80);
          add(lebel);
           ImageIcon img3=new ImageIcon(ClassLoader.getSystemResource("nodepad/icons/xyz.png"));
          Image i2=img3.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
          ImageIcon img4=new ImageIcon(i2);
          JLabel lebel2=new JLabel(img4);
          lebel2.setBounds(50, 180,100,100);
          add(lebel2);
          JLabel l3=new JLabel("<html>this notepad is built by kartik pandey<br> <mark>What Notepad does</mark><br> note pade is used for writing purpose</html>");
          l3.setBounds(180,100,500,300);
          l3.setFont(new Font("Tahoma",Font.PLAIN,20));
          add(l3);
          b=new JButton("OK");
          b.setBounds(500,400,100,50);
          b.setBackground(Color.YELLOW);
          b.addActionListener(this);
          add(b);
      }
          @Override
        public void actionPerformed(ActionEvent ae) 
                
        {
            this.setVisible(false);
        
        }
    public static void main(String arg[])
    {
      new about().setVisible(true);
    }
}
