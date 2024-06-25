/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationasignment_new;


import javax.swing.JOptionPane;

/**
 *
 * @author jay
 */

import javax.swing.JOptionPane;

public class Task {
    private String taskname;
    private int noOftasks;
    private String taskDescription;
    private String developerDetails;
    private double taskduration;
    private  String taskId;
    private String taskstatus;
    public static double sum = 0;
    
   
    
     public Task(String taskname, double taskduration, String taskDescription, String developerDetails, String taskId, String taskstatus) {
        this.taskname = taskname;
        this.taskduration = taskduration;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskId = taskId;
        this.taskstatus = taskstatus;
    }

    

    public  static String generateTaskId(String taskname, String developerDetails, int noOftasks, String firstname) {
        String firstTwoLetters = taskname.substring(0, 2).toUpperCase();
        String lastThreeLetters = firstname.substring(firstname.length() - 3).toUpperCase();
        return firstTwoLetters + ":" + noOftasks + ":" + lastThreeLetters;
        
    }

     
        
     
    public static double returnTotalHours(double taskduration) {
        sum += taskduration;
        return sum;
    }

    public static boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() <= 50) {
            System.out.println("Task description is valid.");
            return true;
        } else {
            System.out.println("Task description is too long.");
            return false;
        }
    }

    public static String showStatus() {
        String taskstatus = null;
        while (true) {
            String input = JOptionPane.showInputDialog("Please enter the status of the task:\n1. To Do\n2. Done\n3. Doing");
            int taskstat = Integer.parseInt(input);

            switch (taskstat) {
                case 1:
                    taskstatus = "To Do";
                    break;
                case 2:
                    taskstatus = "Done";
                    break;
                case 3:
                    taskstatus = "Doing";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
                    break;
            }

            if (taskstatus != null) {
                break; // Exit the loop when a valid status is set
            }
        }

        return taskstatus;
    }
    
    
    /*Title: String buildeR
      Author: OpenAI (Provided by chatGPT
      Date: `26 May 2024
      code cersion: 1
      availability: OpenAI
      
      */

     
     public static Task addTask(int taskNumber) {
        String taskname = JOptionPane.showInputDialog("Please enter the task name for task " + taskNumber);
        double taskduration = Double.parseDouble(JOptionPane.showInputDialog("Please enter the estimated duration for task " + taskNumber));
        String taskDescription = JOptionPane.showInputDialog("Please enter the task description for task " + taskNumber);
        String firstname = JOptionPane.showInputDialog("Please enter your firstname for task " + taskNumber);
        String lastname = JOptionPane.showInputDialog("Please enter your Surname for task " + taskNumber);
        String developerDetails = firstname + " " + lastname;
        String taskId = generateTaskId(taskname, developerDetails, taskNumber, firstname);
        String taskstatus = showStatus();

        return new Task(taskname, taskduration, taskDescription, developerDetails, taskId, taskstatus);
    }
    
    
    

    public String printTaskDetails() {
        StringBuilder taskDetails = new StringBuilder();
        taskDetails.append("Task Name: ").append(taskname).append("\n");
        taskDetails.append("Task Description: ").append(taskDescription).append("\n");
        taskDetails.append("Developer Details: ").append(developerDetails).append("\n");
        taskDetails.append("Task Duration: ").append(taskduration).append(" hours\n");
        taskDetails.append("Task ID: ").append(taskId).append("\n");
        taskDetails.append("Task Status: ").append(taskstatus).append("\n");
        taskDetails.append("----------------------\n");

        return taskDetails.toString();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public int getNoOftasks() {
        return noOftasks;
    }

    public void setNoOftasks(int noOftasks) {
        this.noOftasks = noOftasks;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public double getTaskduration() {
        return taskduration;
    }

    public void setTaskduration(double taskduration) {
        this.taskduration = taskduration;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus;
    }

    public static double getSum() {
        return sum;
    }

    public static void setSum(double sum) {
        Task.sum = sum;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
