
package nodepad;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame   implements ActionListener
{   
        JTextArea area;
        JScrollPane pane;
        String text="";
       Notepad()
       {   
            setBounds(0,0,1920,1080);
            this.setLayout(null);
           this.getContentPane().setBackground(Color.WHITE);
         //  this.setIconImage(null);
           JMenuBar menu=new JMenuBar();
           JMenu file=new JMenu("File");
           JMenuItem newdoc=new JMenuItem("New");
           newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));//two key are used here 1.N,ctrl;
           newdoc.addActionListener(this);
           JMenuItem  open=new JMenuItem("Open");
           open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
           open.addActionListener(this);
           JMenuItem save=new JMenuItem("Save");
           save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
           save.addActionListener(this);
           JMenuItem print=new JMenuItem("Print");
           print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
           print.addActionListener(this);
           JMenuItem exit=new JMenuItem("Exit");
           exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
           exit.addActionListener(this);
           file.add(newdoc);
           file.add(open);
           file.add(save);
           file.add(print);
           file.add(exit);
           JMenu edit=new JMenu("Edit");
           JMenuItem copy=new JMenuItem("Copy");
           copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));//two key are used here 1.N,ctrl;
            copy.addActionListener(this);
           JMenuItem  paste=new JMenuItem("Paste");
           paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
           paste.addActionListener(this);
           JMenuItem cut=new JMenuItem("cut");
           cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
           cut.addActionListener(this);
           JMenuItem delete=new JMenuItem("delete");
           delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
           delete.addActionListener(this);
           edit.add(copy);
           edit.add(paste);
           edit.add(cut);
           edit.add(delete);
           JMenu help=new JMenu("Help");
           JMenuItem Help=new JMenuItem("About notepad");
           Help.addActionListener(this);
           help.add(Help);
           menu.add(file);
           menu.add(edit);
           menu.add(help);
           setJMenuBar(menu);
           area=new JTextArea();
           area.setFont(new Font("SAN SERIF",Font.PLAIN,20));
           area.setLineWrap(true);
           area.setWrapStyleWord(true);
           pane=new JScrollPane(area);
           pane.setBounds(0,0,1920,1080);
           pane.setBorder(BorderFactory.createEmptyBorder());
           
           add(pane,BorderLayout.CENTER);
       }
    public static void main(String[] args)
    {
      new Notepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
       if(ae.getActionCommand().equals("New"))
       {
           area.setText("");
       }
       else if(ae.getActionCommand().equals("Open"))
       {
               JFileChooser chooser=new JFileChooser();
               chooser.setAcceptAllFileFilterUsed(false);
               FileNameExtensionFilter fil=new FileNameExtensionFilter("only .txt files","txt");
               chooser.addChoosableFileFilter(fil);
                int action=chooser.showOpenDialog(this);
               if(action!=JFileChooser.APPROVE_OPTION)
              {
               return;
              }
               File file=chooser.getSelectedFile();
               try 
               {
                   BufferedReader in=new BufferedReader(new FileReader(file));
                   area.read(in,null);
               }
               catch(Exception e){}
            
       }
       
       else if(ae.getActionCommand().equals("Save"))
       {
           JFileChooser choose=new JFileChooser();
           choose.setApproveButtonText("Save");
           int action=choose.showOpenDialog(this);
           if(action!=JFileChooser.APPROVE_OPTION)
           {
               return;
           }
          
           
           File f=new File(choose.getSelectedFile()+".txt");
           BufferedWriter outputfile=null;
           
            try
            {
              outputfile= new BufferedWriter(new FileWriter(f));   
              area.write(outputfile);
            }
           catch(Exception e){}
           
       }
       else if(ae.getActionCommand().equals("Print"))
       {
               try
               {
                   area.print();
               }
               catch(Exception e){}
       }
       else if(ae.getActionCommand().equals("Exit"))
       {
           new Notepad().setVisible(false);
       }
       
       else if(ae.getActionCommand().equals("Copy"))
       {
           text=area.getSelectedText();
       }
       else if(ae.getActionCommand().equals("Paste"))
       {
           area.insert(text,area.getCaretPosition());
       }
       
       else if(ae.getActionCommand().equals("cut"))
       {
           text=area.getSelectedText();
           area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
       }
       else if(ae.getActionCommand().equals("delete"))
       {
         area.setText("");
       }
       
       else if(ae.getActionCommand().equals("About notepad"))
       {
          new about().setVisible(true);
       }
    }
    
}
