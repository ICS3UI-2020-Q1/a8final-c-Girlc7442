import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JButton increaseBtn;
  JButton resetBtn;

  JLabel increaseLabel;
  JLabel counterLabel;

  JTextField increaseField;
  JTextField counterField;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);

    //initialize the labels
    increaseLabel = new JLabel("Increase By:");
    counterLabel = new JLabel("Counter:");

    //set coordinates and size
    increaseLabel.setBounds(50,140,150,25);
    counterLabel.setBounds(50,200,150,25);

    //initialize the text fields
    increaseField = new JTextField("0");
    counterField = new JTextField("0");

    //disable the text field so the user can't use it
    counterField.setEnabled(false);

    //set coordinates and size 
    increaseField.setBounds(210,130,150,50);
    counterField.setBounds(210,190,150,50);

    //initialize the buttons
    increaseBtn = new JButton("Increase");
    resetBtn = new JButton("Reset");

    //set coordinates and size 
    increaseBtn.setBounds(50,75,120,25);
    resetBtn.setBounds(230,75,120,25);

    //add an action listener to the buttons
    increaseBtn.addActionListener(this);
    resetBtn.addActionListener(this);

    //set the action command on the buttons
    increaseBtn.setActionCommand("increase");
    resetBtn.setActionCommand("reset");

    //add the labels to the mainPanel
    mainPanel.add(increaseLabel);
    mainPanel.add(counterLabel);

    //add the text fields to the mainPanel
    mainPanel.add(increaseField);
    mainPanel.add(counterField);

    //add the buttons to the mainPanel
    mainPanel.add(increaseBtn);
    mainPanel.add(resetBtn);

    //add the panel to the window
    frame.add(mainPanel);  

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //initialize an accumulator
    int counter = 0;

    if(command.equals("increase")){
      //get the text from each text box
      String firstText = increaseField.getText();
      String SecondText = counterField.getText();

      //change the string into an integer
      int increaseAmount = Integer.parseInt(firstText);
      int counterStart = Integer.parseInt(SecondText);

      //adds the increaseAmount to the counter
      counter = counterStart + increaseAmount;

      //print the counter into the counterField
      counterField.setText("" + counter);

      //prevents the counter from going over 10
      if(counter >= 10){
        counterField.setText("10");
      }
    }else if(command.equals("reset")){
      //resets the count to 0
      counterField.setText("0");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
