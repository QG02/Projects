package ClockProj;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Clock Object
public class Clock extends JFrame{

    //create variables
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    

    //Clock constructor
    Clock(){

        //Window Format
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);

        //time, day, date display format
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E");
        dateFormat = new SimpleDateFormat("MM,dd,yyyy");
        
        //Time Label
        timeLabel = new JLabel(); //new JLabel
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));//changes font type to Verdana and font size to 50
        timeLabel.setForeground(new Color(0xFFFFFF)); //sets foreground color to white
        timeLabel.setBackground(Color.black); //sets background color to black
        timeLabel.setOpaque(true); //Label set to opaque

        //Day Label
        dayLabel = new JLabel(); //new JLabek
        dayLabel.setFont(new Font("New Times Roman",Font.PLAIN,35));//changes font type to Times New Roman and font size to 35

        dateLabel = new JLabel(); //new JLabel
        dateLabel.setFont(new Font("New Times Roman", Font.PLAIN, 35));//changes font type to Times New Roman and font size to 35
        
        this.add(timeLabel);//add time label to window
        this.add(dayLabel);//add day label to window
        this.add(dateLabel); //add date label to window
        this.setVisible(true); //set visibility to true

        setTime(); //this method gets the current time, date, and day.
    }
    public void setTime(){
        while(true){
        time = timeFormat.format(Calendar.getInstance().getTime());//current time
        timeLabel.setText(time); 

        day = dayFormat.format(Calendar.getInstance().getTime()); //current day
        dayLabel.setText(day);

        date = dateFormat.format(Calendar.getInstance().getTime()); //current date
        dateLabel.setText(date);

        try{
            Thread.sleep(1000); //refreshes every millisecond
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        }
    }
}