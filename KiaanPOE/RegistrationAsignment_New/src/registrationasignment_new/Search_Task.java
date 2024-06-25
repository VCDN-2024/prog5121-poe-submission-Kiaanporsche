/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationasignment_new;

import javax.swing.JOptionPane;
/*Title: array list
      Author: Co-pilot (Provided by chatGPT
      Date: `12 June 2024
      code version: 1
      availability: OpenAI
      
      */

/**
 *
 * @author jay
 */
public class Search_Task {
    
 //   private Task[] Tasks;
    
   // private int Taskcount;
    
    
    private Task[] tasks;
    private int task_Count;

    
    
     public Search_Task(int maxtasks) {
        
       tasks = new Task[maxtasks];
       task_Count = 0;
        
    }
     
     
      
  
    public void addTask(Task task) {
        if (task_Count < tasks.length) {
           
            tasks[task_Count] = task;
            task_Count++;
        } else {
           
            JOptionPane.showMessageDialog(null,"The Task array is full, no more tasks can be added" );
        }
    }
    
    
    

    public void displayDoneTasks() {
        JOptionPane.showMessageDialog(null,"Tasks with the status 'Done':" );
       
        for (int i = 0; i < task_Count; i++) {
            if ("Done".equals(tasks[i].getTaskstatus())) {
                JOptionPane.showMessageDialog(null, "The Developer is: " + tasks[i].getDeveloperDetails() + "\n" +"Task Name is : " + tasks[i].getTaskname() + "\n" +"Task Duration is: " + tasks[i].getTaskduration());
            }
        }
    }
    
    
    
    public Task displayLongestTask() {
        if (task_Count == 0) {
            return null;
        }

        Task longestTask = tasks[0];
        for (int i = 1; i < task_Count; i++) {
            if (tasks[i].getTaskduration() > longestTask.getTaskduration()) {
                longestTask = tasks[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Task with the longest duration:\n");
        sb.append("Developer: ").append(longestTask.getDeveloperDetails()).append(", Task Duration: ").append(longestTask.getTaskduration()).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
        return longestTask;
    }


    
    
    
    

    public String displayReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task Collection Report:\n");
        for (int i = 0; i < task_Count; i++) {
            sb.append("Task Name: ").append(tasks[i].getTaskname()).append("\n");
            sb.append("Developer: ").append(tasks[i].getDeveloperDetails()).append("\n");
            sb.append("Task Description: ").append(tasks[i].getTaskDescription()).append("\n");
            sb.append("Task Duration: ").append(tasks[i].getTaskduration()).append(" hours\n");
            sb.append("Task ID: ").append(tasks[i].getTaskId()).append("\n");
            sb.append("Task Status: ").append(tasks[i].getTaskstatus()).append("\n");
            sb.append("----------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    /*Title: delete array
      Author: Co-pilot 
      Date: `12 June 2024
      code version: 1
      availability: OpenAI
      
      */
    
    
    
    
    public String deleteTaskByName(String name){
        for (int i = 0; i < task_Count; i++) {
            if (tasks[i].getTaskname().equalsIgnoreCase(name)) {
                //inner loop
                for (int j = i; j < task_Count -1; j++) {
                    tasks[i]= tasks[j + 1];
                }
                task_Count--;
                JOptionPane.showMessageDialog(null,"Success","Task deleted successfully", JOptionPane.INFORMATION_MESSAGE);
                return "Entry " + name + " successfully deleted";
            }
        } 
        JOptionPane.showMessageDialog(null,"Error", "Task not found", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    

    
    
    


     /*Title: searchbydeveloper
      Author: Co-pilot 
      Date: `12 June 2024
      code version: 1
      availability: OpenAI
      
      */
    

     public Task searchTasksByDeveloper(String developer) {
    StringBuilder foundTasks = new StringBuilder("Tasks found by developer '" + developer + "':\n");
    boolean found = false;
    Task foundTask = null;

    for (int i = 0; i < task_Count; i++) {
        if (tasks[i] != null && tasks[i].getDeveloperDetails().equalsIgnoreCase(developer)) {
            foundTasks.append(tasks[i].printTaskDetails()).append("\n");
            found = true;
            // Assuming you want to return the first matching task
            foundTask = tasks[i];
        }
    }

    if (!found) {
        foundTasks.append("No tasks found for developer: ").append(developer);
    }

    JOptionPane.showMessageDialog(null, foundTasks.toString());

    return foundTask;
}



   
//    public void searchTasksByDeveloper(String developer) {
//        StringBuilder foundTasks = new StringBuilder("Tasks found by developer '" + developer + "':\n");
//        boolean found = false;
//
//        for (int i = 0; i < task_Count; i++) {
//            if (tasks[i].getDeveloperDetails().equalsIgnoreCase(developer)) {
//                foundTasks.append(tasks[i].printTaskDetails()).append("\n");
//                found = true;
//            }
//        }
//
//        if (!found) {
//            foundTasks.append("No tasks found for developer: ").append(developer);
//        }
//
//        JOptionPane.showMessageDialog(null, foundTasks.toString());
//        
//    }

 
    
     

    
    
    
    public Task searchTaskByName(String taskName) {
    for (int i = 0; i < task_Count; i++) {
        if (tasks[i].getTaskname().equalsIgnoreCase(taskName)) {
            JOptionPane.showMessageDialog(null, "Task Name: " + tasks[i].getTaskname() + "\nDeveloper: " + tasks[i].getDeveloperDetails() + "\nTask Status: " + tasks[i].getTaskstatus());
            return tasks[i]; // Return the found task
        }
    }
    JOptionPane.showMessageDialog(null, "Task not found.");
    return null; // Return null if no match is found
}

     
    
     

     
     
    

    public void OptionSelected()
    {
        int choice;
        while (true) {
            String [] choices = 
            {
                "Tasks that are 'Done'",
                "Task with the longest Duration",
                "Search for Task by Name",
                "Search by Developer",
                "Delete Task by Task Name",
                "Display Report",
                "Exit"

            };
            
            StringBuilder menuMessage = new StringBuilder();
            for (int i = 0; i <choices.length; i++) {
                menuMessage.append(i + 1).append(".").append(choices[i]).append("\n");
                
                
            }
            //Show a dialog box with the menu options and get the users selection
            String selectedOptions = JOptionPane.showInputDialog(null,menuMessage.toString(),"Task Managerf",JOptionPane.PLAIN_MESSAGE);
            
            
            
            if (selectedOptions == null) {
                break;
                
            }
            
            
           
            //convert the users choice to an integter
             choice = Integer.parseInt(selectedOptions);
            
            
            switch (choice) {
                case 1 : displayDoneTasks();
                break;
                    
                   case 2: displayLongestTask();
                   break;
                    
                    
                    case 3 : {
                        String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
                        searchTaskByName(taskName);
                        break;
                }
                    
                    
                     case 4 : {
                         String developer = JOptionPane.showInputDialog("Enter the developer name to search:");
                         searchTasksByDeveloper(developer);
                         break;
                }
                    
                     case 5 : {
                         String taskNameToDelete = JOptionPane.showInputDialog("Enter the task name to delete:");
                         deleteTaskByName(taskNameToDelete);
                         break;
                }
                    
                     case 6 : displayReport();
                    break;
                    
                     case 7 : System.exit(0);    
                     break;
                       
                     default : throw new AssertionError();
                
            }
        }
        
    }
    
    
    
      
}
     
     
    