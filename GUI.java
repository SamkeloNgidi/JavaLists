
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.IOException;
   
public class GUI extends JFrame implements ActionListener 
{
    public int count=0;	
    Song Varray[]=new Song[10]; 
    
    JLabel s1 = new JLabel ("  "); 
    JLabel s2 = new JLabel ("  "); 
    JLabel s3 = new JLabel ("  "); 
    JLabel s4 = new JLabel ("  "); 
    JLabel s5 = new JLabel ("  "); 
    JLabel s6 = new JLabel ("  "); 
    JLabel s7 = new JLabel ("  ");
    JLabel s8 = new JLabel ("  ");
    JLabel s9 = new JLabel ("  ");
    JLabel s10 = new JLabel ("  ");
    JLabel s11 = new JLabel ("  ");
    JLabel s12 = new JLabel ("  ");
    JLabel s13 = new JLabel ("  ");
    JLabel s14 = new JLabel ("  ");
  	   
    JTextField t1 = new JTextField("",7);
    JTextField t6 = new JTextField("",7);
          
    JButton create = new JButton("Create List");
    JButton display = new JButton("Display List");
    JButton add = new JButton("Add SONG");
    JButton remove = new JButton("Remove SONG");
    JButton save = new JButton("Save");
    JButton load = new JButton("Load");
    JButton exit = new JButton("Exit"); 
      
    JTextArea list = new JTextArea("",20,14);
    JScrollPane scroll = new JScrollPane(list,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      
    JPanel p2 = new JPanel(new BorderLayout()); 
    JPanel p1 = new JPanel(new GridLayout(10,2));
    JPanel p3 = new JPanel(new GridLayout(1,3));
    
    public GUI()
    {
        super("Songs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        save.addActionListener(this);  
        create.addActionListener(this);  
        load.addActionListener(this);  
        display.addActionListener(this);  
        remove.addActionListener(this);  
        exit.addActionListener(this);  
        add.addActionListener(this);  
        display.setVisible(false);
        
        p1.add(create);
        //p1.add(s1);
        p1.add(display);
        //p1.add(s2);
        p1.add(add);
        p1.add(s3);
        p1.add(s4);
        p1.add(s5);
        p1.add(s6);
        p1.add(s11);
        p1.add(t6);
        p1.add(s7);
        p1.add(remove);
        p1.add(s8);
        p1.add(s9);
        p1.add(s10);
        p1.add(s12);
        p1.add(s13);
        p1.add(s14);
        p1.add(exit);
        p3.add(save);
        p3.add(load);
        p2.add("South",p1);
        p2.add("Center",p3);
        p2.add("North",scroll);
              	
        setContentPane(p2);      
    }
      
    public static void main(String[] args)
    {
       GUI aFrame = new GUI();
       aFrame.setSize(400,700);
       aFrame.setVisible(true);
       aFrame.setResizable(true);
    }
      
    public void actionPerformed(ActionEvent e)
    {
        Object s = e.getSource();
        SongList snglist = new  SongList();
         
        if(s == create)
        {
            snglist.createList();  
            display.setVisible(true);
            JOptionPane.showMessageDialog(null,"List Created");
        }  
        else if(s == display)
        {
            list.setText ("");
            for(int i = 0; i <= count; i++)
            {
		list.setText(list.getText() + "\n" + Varray[i].getSName());
            }
            
        } 
        else if(s == add)
        {
            String a = JOptionPane.showInputDialog(null, "Enter Song Name:", "SName", JOptionPane.QUESTION_MESSAGE);
		
            System.out.println(count);
		
            Varray[count] = new Song(a);
            count = count+1;
            
            JOptionPane.showMessageDialog(null,"Successful, click display list");//
  
        }
        else if(s == save)
        {
            JOptionPane.showMessageDialog(null,snglist.Save());
        } 
        else if(s == load)
        {

        Varray[0]=new Song("Vent");
        Varray[1]=new Song("SMA");
        Varray[2]=new Song("Overload");
        Varray[3]=new Song("King");
            
        count = 4;
        
        //new changes
        JOptionPane.showMessageDialog(null,"Data load successful, click display list");
        display.setVisible(true);
        } 
        else if(s == remove)
        {
            Song v = snglist.removeSong(Integer.parseInt(t6.getText().trim()));
            JOptionPane.showMessageDialog(null,"This song has been REMOVED\nSong Name"+ v.getSName());
        }
        else if(s == exit)
        {
            snglist.Exit();
        }
    }  
}
