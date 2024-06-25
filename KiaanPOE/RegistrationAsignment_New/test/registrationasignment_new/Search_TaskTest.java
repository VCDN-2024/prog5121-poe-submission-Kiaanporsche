/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package registrationasignment_new;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author jay
 */
public class Search_TaskTest {
    
     private Search_Task search;
    private Task task1, task2, task3, task4;

    
    public Search_TaskTest() {
        
        
        search = new Search_Task(10);

        task1 = new Task("Create Login", 5, "", "Mike Smith", "", "To Do");
        task2 = new Task("Create Add Features", 8, "", "Edward Harrison", "", "Doing");
        task3 = new Task("Create Reports", 2, "", "Samantha Paulson", "", "Done");
        task4 = new Task("Add Arrays", 11, "", "Glenda Oberholzer", "", "To Do");

        search.addTask(task1);
        search.addTask(task2);
        search.addTask(task3);
        search.addTask(task4);
        
        
        
    }
    
    
    
    
    @Test
    public void testDeveloperArray() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] actualDevelopers = new String[4];
        actualDevelopers[0] = task1.getDeveloperDetails();
        actualDevelopers[1] = task2.getDeveloperDetails();
        actualDevelopers[2] = task3.getDeveloperDetails();
        actualDevelopers[3] = task4.getDeveloperDetails();

        assertArrayEquals(expectedDevelopers, actualDevelopers);
    }

    @Test
    public void testAddTask() {
        
        
        
        
        
    }

    @Test
    public void testDisplayDoneTasks() {
    }

    @Test
    public void testDisplayLongestTask() {
        
         Task expected = task4; // Glenda Oberholzer, Add Arrays, 11
        Task actual = search.displayLongestTask();
        assertNotNull(actual);
        assertEquals(expected.getDeveloperDetails(), actual.getDeveloperDetails());
        assertEquals(expected.getTaskduration(), actual.getTaskduration(), 0.0);
    }


       @Test
    public void testDisplayReport() {
        
        StringBuilder expectedReport = new StringBuilder();
        expectedReport.append("Task Collection Report:\n");
        expectedReport.append("Task Name: Create Login\n");
        expectedReport.append("Developer: Mike Smith\n");
        expectedReport.append("Task Description: \n");
        expectedReport.append("Task Duration: 5.0 hours\n");
        expectedReport.append("Task ID: CR:1:ITH\n");
        expectedReport.append("Task Status: To Do\n");
        expectedReport.append("----------------------\n");

        expectedReport.append("Task Name: Create Add Features\n");
        expectedReport.append("Developer: Edward Harrison\n");
        expectedReport.append("Task Description: \n");
        expectedReport.append("Task Duration: 8.0 hours\n");
        expectedReport.append("Task ID: CR:2:SON\n");
        expectedReport.append("Task Status: Doing\n");
        expectedReport.append("----------------------\n");

        expectedReport.append("Task Name: Create Reports\n");
        expectedReport.append("Developer: Samantha Paulson\n");
        expectedReport.append("Task Description: \n");
        expectedReport.append("Task Duration: 2.0 hours\n");
        expectedReport.append("Task ID: CR:3:SON\n");
        expectedReport.append("Task Status: Done\n");
        expectedReport.append("----------------------\n");

        expectedReport.append("Task Name: Add Arrays\n");
        expectedReport.append("Developer: Glenda Oberholzer\n");
        expectedReport.append("Task Description: \n");
        expectedReport.append("Task Duration: 11.0 hours\n");
        expectedReport.append("Task ID: AD:4:ZER\n");
        expectedReport.append("Task Status: To Do\n");
        expectedReport.append("----------------------\n");

        String actualReport = search.displayReport();

        // Remove whitespace differences for comparison
        assertEquals(expectedReport.toString().replaceAll("\\s+", ""), actualReport.replaceAll("\\s+", ""));
        
        
       
    }

    
////   @Test
////    public void testDisplayReport() {
////        String expectedReport = """
////                Task Collection Report:
//                Task Name: Create Login
//                Developer: Mike Smith
//                Task Description: 
//                Task Duration: 5.0 hours
//                Task ID: CR:1:ITH
//                Task Status: To Do
//                ----------------------
//                Task Name: Create Add Features
//                Developer: Edward Harrison
//                Task Description: 
//                Task Duration: 8.0 hours
//                Task ID: CR:2:SON
//                Task Status: Doing
//                ----------------------
//                Task Name: Create Reports
//                Developer: Samantha Paulson
//                Task Description: 
//                Task Duration: 2.0 hours
//                Task ID: CR:3:SON
//                Task Status: Done
//                ----------------------
//                Task Name: Add Arrays
//                Developer: Glenda Oberholzer
//                Task Description: 
//                Task Duration: 11.0 hours
//                Task ID: AD:4:ZER
//                Task Status: To Do
//                ----------------------
//                """;  
//
//         String actualReport = search.displayReport();
//        assertEquals(expectedReport.replaceAll("\\s+", " "), actualReport.replaceAll("\\s+", " "));
//    }
//
    @Test
    public void testDeleteTaskByName() {
      String taskNameToDelete = "Create Reports";
        String expectedMessage = "Entry " + taskNameToDelete + " successfully deleted";
        String actualMessage = search.deleteTaskByName(taskNameToDelete);
        assertEquals(expectedMessage, actualMessage);

        Task deletedTask = search.searchTaskByName(taskNameToDelete);
        assertNull(deletedTask);
    }

    @Test
    public void testSearchTasksByDeveloper() {
        Task expected = task3; // Create Reports by Samantha Paulson
        Task actual = search.searchTasksByDeveloper("Samantha Paulson");
        assertNotNull(actual);
        assertEquals(expected.getTaskname(), actual.getTaskname());
    }

    @Test
    public void testSearchTaskByName(){
          Task expected = task1; // Create Login by Mike Smith
        Task actual = search.searchTaskByName("Create Login");
        assertNotNull(actual);
        assertEquals(expected.getDeveloperDetails(), actual.getDeveloperDetails());
        assertEquals(expected.getTaskname(), actual.getTaskname());

    }

    @Test
    public void testOptionSelected() {
    }
    
}
