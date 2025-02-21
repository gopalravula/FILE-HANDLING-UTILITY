package testingg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations
{
	
	// Reading a File. //
	public static void readFile(String fileName)
	{
		
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
		{
			String line;
			System.out.println("Reading the file Name: "+fileName);
			while((line = reader.readLine())!=null)
			{
				System.out.println(line);
			}
		}
		
		catch (Exception e)
		{
			System.out.println(" Error of the Reading File "+e.getMessage());
		}
	}
	
	
	
	
	// Writting a File. //
	public static void writeFile(String fileName, String content)
	{
		
		try(BufferedWriter writter = new BufferedWriter(new FileWriter(fileName)))
		{
			writter.write(content);
			System.out.println("Content Written by File : "+fileName);
		}
		
		catch (Exception e)
		{
			System.out.println("Error while writting a File: "+e.getMessage());
		}
	}
	
	
	
	// Modifying a File. //
	public static void modifyFile(String fileName, String newContent)
	{
		
		try(BufferedWriter writter = new BufferedWriter(new FileWriter(fileName,true)))
		{
			writter.newLine();
			writter.write(newContent);
			System.out.println("  Content Appended to a File: "+fileName);
		}
		catch (IOException e)
		{
			System.out.println("Error Modifying File: "+e.getMessage());
		}
		
	}
	
	
	// Main Method //
	public static void main(String[] args)
	{
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the fileName with (Extension): ");
		String filename = scanner.nextLine();
		
		
		System.out.println("Choose an Operation: \n1.Readline \n2.Writeline  \n3.modify File ");
		
		int choice = scanner.nextInt();
		
		scanner.nextLine();
		
		switch(choice)
		{
		case 1:
			readFile(filename);
			
			break;
			
		case 2:
			System.out.println("Enter the content to the File: ");
			String content =scanner.nextLine();
			writeFile(filename, content);
			
			break;
			
		case 3:
			
			System.out.println("Enter the Content to the Append File: ");
			String newContent = scanner.nextLine();
			modifyFile(filename, newContent);
			
			break;
			
			default:
				
				System.out.println(" Invalid choice ");
		}
		
		scanner.close();
		
	}
}
