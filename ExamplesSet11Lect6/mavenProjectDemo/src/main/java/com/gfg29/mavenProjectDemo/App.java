package com.gfg29.mavenProjectDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
  
        
        //Maven life phase 
        //clean - will delete the target folder
        //validate - intermediate step if all the files and folder exists or not eg pom
        //compile - compile the entire code in the main folder and create byte can put it to target class folder
        //test - same as compile also checks for test cases
        //package - creates a jar file for the projects and add it to the target folder but will not push to local repo
        //verify - just verify the architecture
        //install - will copy the jar from target folder to local repo .m2 folder
        //site & deploy - used to deploy the changes to remote repo 
   
        
        
        //diff between IP and DNS
        // IP is unique address given to server. since they are difficult to remember.
        //DNS is human readable name assigned to server. they are easy to remeber
        
        //any dependency starting from spring-boot-starter-<something>
        //will have spring boot starter as a parent dependency
        
        
    }
}
