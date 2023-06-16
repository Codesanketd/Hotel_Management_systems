
package hotel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setSize(1366,565);
        setLocation(100,100);
        setLayout(null);//dont use default layout
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        
                Image i3 = il.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
        JLabel image =new JLabel(il);//jlable use to get text on frame
        image.setBounds(0,0,1566,565);//setLayout
        add(image);
        
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 420, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);
        
        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,50);
        image.add(next);
        next.setBackground(Color.white);
        next.setFont(new Font("serif",Font.PLAIN,28));
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        setVisible(true);
        
        while(true){                      //text hide and visible
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
              text.setVisible(true);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
        } 
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }    
       
    public static void main(String[] args) {
        new HotelManagementSystem();
        
        
    }
    
}
