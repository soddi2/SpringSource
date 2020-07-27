package com.java.eclipse_maven_app;

public class App 
{
	public String getMessage(String name) {
		return "Hi, "+name+" . Welcome to Maven World";
	}
	
	public void printMessage(String name) {
		System.out.println("\n******** App Class *******\n");
    	System.out.println( "Hello World!" );
    	System.out.println("\n******** App Class *******\n");
	}
	
    public static void main( String[] args )
    {
    	new App().printMessage("Hong");
    }
}
