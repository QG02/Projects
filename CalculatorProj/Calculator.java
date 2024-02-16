import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    
    //initialize frame component variables
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[11];
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JButton modButton, sqrButton, sqrtButton, logButton;
    JPanel panel;

    //create variable for font that will be used all across the program
    Font MyFont = new Font("New Time Roman",Font.BOLD,30);
    
    //initialize operation variables
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    //Calculator object constructor
    Calculator(){
        frame = new JFrame("Calculator"); //create the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //set the tab out options
        frame.setSize(500,550); //set frame dimensions
        frame.setLayout(null); 

        textField = new JTextField(); //create text field to hold values
        textField.setBounds(50,25,300,50); //set test field dimensions
        textField.setFont(MyFont); //use the pre made font
        textField.setEditable(false); //set the field to view only

        //array to hold the functions at their individual indexes 
        functionButtons[0] = addButton = new JButton("+");
        functionButtons[1] = subButton = new JButton("-");
        functionButtons[2] = multButton = new JButton("*");
        functionButtons[3] = divButton = new JButton("/");
        functionButtons[4] = decButton = new JButton(".");
        functionButtons[5] = delButton = new JButton("Delete");
        functionButtons[6] = equButton = new JButton("=");
        functionButtons[7] = clrButton = new JButton("Clear");
        functionButtons[8] = modButton = new JButton("%");
        functionButtons[9] = sqrButton = new JButton("^2");
        functionButtons[10] = sqrtButton = new JButton("√");

        //create a for loop that will apply the action listener method to each function button in the array
        for(int i = 0; i < 11; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(MyFont);
            functionButtons[i].setFocusable(false);
        }

        //craete a for loop that will apply the action listener method to each number button
        //and a value for each button
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(MyFont);
            numberButtons[i].setFocusable(false);
        }

        //create 2 seperate buttons for the delete and clear operation
        delButton.setBounds(50,420,145,50);
        clrButton.setBounds(205, 420, 145, 50);

        //new panel container for the function and number buttons
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);
        
        //adding the buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        //add all the components to the frame
        frame.add(panel);
        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }

    @Override
    //actionPerformed() method will contain all the operation methods that will
    //happen based on the button that was pressed
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){ //decimal action
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){ //addition action
           num1 = Double.parseDouble(textField.getText());
           operator = '+';
           textField.setText("");
        }
        if(e.getSource() == subButton){ //subtraction action
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == multButton){ //multiplication action
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){ //division action
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){ //equals action
            num2= Double.parseDouble(textField.getText());
            
            switch(operator){ //switch case that will perform the action based on the action listener input
                case '+':
                result = num1 + num2; //addition case
                break;

                case '-':
                result = num1 - num2; //subtraction case
                break;

                case '*':
                result = num1 * num2; //multiplication case
                break;

                case '/':
                result = num1 / num2; //division case
                break;
            }
            textField.setText(String.valueOf(result)); //create a string from the value of the operation
            num1 = result; //start a new operation with the first number set to the value of the previous operation
        }
        if(e.getSource() == clrButton){
            textField.setText(""); //clear text in field action
        }
        if(e.getSource() == delButton){ //delete text in field action
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length() - 1 ; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }



        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}