import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
* This program demonstrates console input.
* 
* @author Trevor Douglas
*/
public class EmployeeTest
{
	Employee[] employeeList = new Employee[100];


	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		EmployeeTest employeeTest = new EmployeeTest();

		int loopCount = 0;
		try 
		{

			Scanner fileIn = new Scanner(Paths.get("FakeEmployee.csv"));

			while (fileIn.hasNextLine()) 
			{
				String line = fileIn.nextLine();
				String [] information = line.split(",");
				String firstName = information[0];
				String lastName = information[1];
				String address = information[2];
				String phoneNumber = information[3];
				String hireDay = information[4];
				double salary = Double.valueOf(information[5]).doubleValue();
				//System.out.print(firstName+" "+lastName+" "+address+" "+phoneNumber+" "+salary+"\n");
				employeeTest.employeeList[loopCount] = new Employee(firstName, lastName, address, phoneNumber, hireDay, salary);
				loopCount++;
			}
			fileIn.close();		
		}
		 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.print(loopCount + " employee was read from file. \n");
		//read in end up here.
	
		System.out.print("Entry\n1 to display the list by the largest salary \n2 to display the list by last name alphabetical \n3 to exit: ");
		int choose = Integer.parseInt(in.nextLine());
		
		
		if(choose == 1)
		{
			//sort the list by salary
			for(int i = 0; i<loopCount-1;i++)
			{
				for(int j = 1; j <loopCount -i;j++)
				{
					if(employeeTest.employeeList[j-1].getSalary() < employeeTest.employeeList[j].getSalary())
					{
						String tempFirstName = employeeTest.employeeList[j-1].getFirstName();
						String tempLastName = employeeTest.employeeList[j-1].getLastName();
						String tempAddress = employeeTest.employeeList[j-1].getAddress();
						String tempPhoneNumber = employeeTest.employeeList[j-1].getPhoneNumber();
						String tempHireDay = employeeTest.employeeList[j-1].getHireDay();
						double tempSalary = employeeTest.employeeList[j-1].getSalary();
						
						employeeTest.employeeList[j-1].setFirstName(employeeTest.employeeList[j].getFirstName());
						employeeTest.employeeList[j-1].setLastName(employeeTest.employeeList[j].getLastName());
						employeeTest.employeeList[j-1].setAddress(employeeTest.employeeList[j].getAddress());
						employeeTest.employeeList[j-1].setPhoneNumber(employeeTest.employeeList[j].getPhoneNumber());
						employeeTest.employeeList[j-1].setHireDay(employeeTest.employeeList[j].getHireDay());
						employeeTest.employeeList[j-1].setSalary(employeeTest.employeeList[j].getSalary());
						
						employeeTest.employeeList[j].setFirstName(tempFirstName);
						employeeTest.employeeList[j].setLastName(tempLastName);
						employeeTest.employeeList[j].setAddress(tempAddress);
						employeeTest.employeeList[j].setPhoneNumber(tempPhoneNumber);
						employeeTest.employeeList[j].setHireDay(tempHireDay);
						employeeTest.employeeList[j].setSalary(tempSalary);
						
					}
				}
			}
			
			for(int j = 0; j<loopCount; j++)
			{
				// display output on console
				
				System.out.print("Hello, " + employeeTest.employeeList[j].getFirstName() + " "
				+ employeeTest.employeeList[j].getLastName() + "."
				+ " You are live in " +employeeTest.employeeList[j].getAddress() + ","
				+ " your phone number is "+employeeTest.employeeList[j].getPhoneNumber() + ","
				+ "  you make: $ " + employeeTest.employeeList[j].getSalary() + "\n");
				
			}
		}
		//end of choose 1
		
		else if(choose == 2)
		{
			char []firstChar = new char[100];
			for(int k=0; k<loopCount;k++)
			{
				
				firstChar[k] =  employeeTest.employeeList[k].getLastName().charAt(0);
			}
			
			for(int i = 0; i<loopCount-1;i++)
			{
				for(int j = 1; j <loopCount -i;j++)
				{
					if(firstChar[j-1] > firstChar[j])
					{
						char temp  = firstChar[j-1];
						firstChar[j-1] = firstChar[j];
						firstChar[j] = temp;
						
						String tempFirstName = employeeTest.employeeList[j-1].getFirstName();
						String tempLastName = employeeTest.employeeList[j-1].getLastName();
						String tempAddress = employeeTest.employeeList[j-1].getAddress();
						String tempPhoneNumber = employeeTest.employeeList[j-1].getPhoneNumber();
						String tempHireDay = employeeTest.employeeList[j-1].getHireDay();
						double tempSalary = employeeTest.employeeList[j-1].getSalary();
						
						employeeTest.employeeList[j-1].setFirstName(employeeTest.employeeList[j].getFirstName());
						employeeTest.employeeList[j-1].setLastName(employeeTest.employeeList[j].getLastName());
						employeeTest.employeeList[j-1].setAddress(employeeTest.employeeList[j].getAddress());
						employeeTest.employeeList[j-1].setPhoneNumber(employeeTest.employeeList[j].getPhoneNumber());
						employeeTest.employeeList[j-1].setHireDay(employeeTest.employeeList[j].getHireDay());
						employeeTest.employeeList[j-1].setSalary(employeeTest.employeeList[j].getSalary());
				
						employeeTest.employeeList[j].setFirstName(tempFirstName);
						employeeTest.employeeList[j].setLastName(tempLastName);
						employeeTest.employeeList[j].setAddress(tempAddress);
						employeeTest.employeeList[j].setPhoneNumber(tempPhoneNumber);
						employeeTest.employeeList[j].setHireDay(tempHireDay);
						employeeTest.employeeList[j].setSalary(tempSalary);						
					}
				}
			}
			
			for(int j = 0; j<loopCount; j++)
			{
				// display output on console
				
				System.out.print("Hello, " + employeeTest.employeeList[j].getFirstName() + " "
				+ employeeTest.employeeList[j].getLastName() + "."
				+ " You are live in " +employeeTest.employeeList[j].getAddress() + ","
				+ " your phone number is "+employeeTest.employeeList[j].getPhoneNumber() + ","
				+ "  you make: $ " + employeeTest.employeeList[j].getSalary() + "\n");
								
			}
		}
		
		else if(choose == 3)
		{
			System.out.print("User select exit, program ended");
			Runtime.getRuntime().exit(0);
		}
		else
		{
			System.out.print("Unknow entry, program ended");
			Runtime.getRuntime().exit(0);
		}
		
	}
}
