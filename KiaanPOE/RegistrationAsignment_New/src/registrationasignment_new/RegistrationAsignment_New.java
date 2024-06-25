/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationasignment_new;

import javax.swing.JOptionPane;

/**
 *
 * @author jay
 */
public class RegistrationAsignment_New {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
     String username;
     String password;
     String firstname;
     String lastname;
     
     
     
     firstname = JOptionPane.showInputDialog("Please enter your firstname");
     lastname = JOptionPane.showInputDialog("Please enter your lastname");
     
        
     username = JOptionPane.showInputDialog("please enter your username for registration that contains 5 charactes and has an (_)");
     //this snippet of code cheks the username before creating a logn object
     boolean usrCheckusername=false;
     
        if ((username.contains("_") && username.length()<=5)) {
            JOptionPane.showMessageDialog(null, "username is fine");
        } else {
            JOptionPane.showMessageDialog(null, "username is not fine");
            while (!usrCheckusername) {
                username = JOptionPane.showInputDialog("please enter your username for registration that contains 5 charactes and has an (_)");
                if ((username.contains("_") && username.length()<=5)) {
                    usrCheckusername=true;
                } else {
                usrCheckusername=false;
                }
                
            }
            
            
            
        }
        
        
     
      password = JOptionPane.showInputDialog("Please enter password for registartion that contains atleast 8 characters, 1 symbol and one upper case letter");
                     String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$";
                     password.matches(regex);
      boolean usercheckpassword = false;
      
        if (password.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Password is meets the requirements");
        } else {
            JOptionPane.showMessageDialog(null, "Password does not meet the critera");
            while (!usercheckpassword) {
                 password = JOptionPane.showInputDialog("Please enter password for registartion that contains atleast 8 characters, 1 symbol and one upper case letter");
                 if (password.matches(regex)) {
                    usercheckpassword = true;
                } else {
                     usercheckpassword = false;
                }
            }
        }

//        username="test_";
//        password="12345678!Rr";
//        firstname="dsfs";
//        lastname="dfdf";


        String enteredUsername = JOptionPane.showInputDialog("Enter your username:");
        String enteredPassword = JOptionPane.showInputDialog("Enter your password:");
        
        
      Login login = new Login(username, password, firstname, lastname);
       
      JOptionPane.showMessageDialog(null, login.registerUser());
      boolean loginvariable = login.loginUser(enteredPassword,enteredUsername);
      
      JOptionPane.showMessageDialog(null, login.loginUser(enteredPassword, enteredUsername));
      
      JOptionPane.showConfirmDialog(null, login.returnLoginStatus(loginvariable));
      
      
      
     
      
      /*Title: re attempt
      Author: OpenAI (Provided by chatGPT
      Date: `11 April 2024
      code version: 1
      availability: OpenAI
      
      */


int attempts = 3;

while (attempts > 0) {
    // Assume enteredPassword and enteredUsername are defined elsewhere in your code
    if (!login.loginUser(enteredPassword, enteredUsername)) {
        // Prompt the user with the option to try again or exit
        int option = JOptionPane.showConfirmDialog(null, "Password is not correctly formatted. Attempts left: " + attempts +
                "\nWould you like to attempt it again?", "Login Attempt", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Decrement attempts before asking for new input
            attempts--;
            // Ask for new username and password
            enteredUsername = JOptionPane.showInputDialog("Enter username:");
            enteredPassword = JOptionPane.showInputDialog("Enter password:");
        } else if (option == JOptionPane.NO_OPTION) {
            // Exit the program if the user selects 'No'
            System.exit(0);
        }
    } else {
        // Inform the user of a successful login
        JOptionPane.showMessageDialog(null, "Successful");
        
    }

    
    
    //Part 3
   
    Search_Task taskmanager = new Search_Task(attempts);
    
    boolean continuation = false;
    while (continuation == false) {
      
        
        int response = Integer.parseInt(JOptionPane.showInputDialog(
                null, 
                "1. Add Task\n2. Show Report\n3. Exit", 
                "Task Manager", 
                JOptionPane.QUESTION_MESSAGE));
         
switch (response) {
    
            case 1 -> {
              
                int noOftasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the amount of tasks"));
                for (int i = 0; i < noOftasks; i++) {
                    Task task = Task.addTask(i+1);
                    taskmanager.addTask(task);
                    
                    
                }
                
                }
                 
            case 2 ->  {
                
            
              taskmanager.OptionSelected();
            
            }

            case 3 -> {
                JOptionPane.showMessageDialog(null, "You have ended Program");
                continuation = true;
            }
           
            default -> JOptionPane.showMessageDialog(null, "You canceled or pressed Escape.");
        }
        }
        
        
        
    }
       
        
       
} 

        
    }
    
    
    
    
    









 