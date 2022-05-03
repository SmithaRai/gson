package gson;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;


public class EmployeePayRoll {
	
		private  String id;
    	private  String name;
		private  String salary;
		     
		   public String getId() {
				return id;
			}
			
			public String getName() {
				return name;
			}
			
			public String getSalary() {
				return salary;
			}
			
		
		static List<EmployeePayRoll> list = new ArrayList<>();
		
		
	     public EmployeePayRoll() {
			// TODO Auto-generated constructor stub
		}
		public EmployeePayRoll(String id , String name , String salary) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.name = name ;
			this.salary = salary ;
		}
		
		public  void getdata() throws Exception, IOException
	    {
		 Scanner in = new Scanner(System.in);
		 
			File file = new File("Employee.csv");
			FileWriter write = new FileWriter(file);
			CSVWriter csv = new CSVWriter(write);

		 System.out.println("ENTER NO.OF ENTRIES TO BE ENTERED : ");
		 int n = in.nextInt();
		 
		 String header[] = {"id" , "name" , "salary" };
		csv.writeNext(header);

		     for(int i = 0 ; i < n; i++ )
		     {  System.out.println("ENTER EMPLOYEE ID : ");
		       id = in.next();
		       System.out.println("ENTER EMPLOYEE NAME : ");
		       name = in.next();
		       System.out.println("ENTER EMPLOYEE SALARY : ");
		       salary = in.next(); 
		      String data[] = { id , name ,salary };
				csv.writeNext(data);

		      list.add(new EmployeePayRoll(id , name ,salary));    
		     }
		     csv.flush();
			csv.close();	    	
	      }
	   
	   public void display()
	   {
		   System.out.println(list.size());
	      for(int i = 0 ; i < list.size() ; i++ )
	      { 
	    	System.out.println("employee id : "+list.get(i).getId());
		    System.out.println("employee name : "+list.get(i).getName());
	        System.out.println("employee salary : "+list.get(i).getSalary());
	        System.out.println(" ");
	      }
	   }   
	   
	      

		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("--***---EMPLOYEE PAYROLL USING GSON---***---");
			
			Scanner in = new Scanner(System.in);	
			EmployeePayRoll employee = new EmployeePayRoll();
			
					
			File file = new File("Employee.csv");
			FileWriter write = new FileWriter(file);
			CSVWriter csv = new CSVWriter(write);
		 
			
				
			
			System.out.println(" ");
			int a ;
			do {
				
			    System.out.println("******enter your choice******** ");
			    System.out.println("1.INSERT \n 2.DISPLAY ");
			    int choice = in.nextInt();
			   
			         switch(choice)
			              {
				              case 1:
					                employee.getdata();
					                break;
					
				              case 2:
					                employee.display();
					                break;
					 
				       
				            	  
			                  default :
			    	               System.out.println("invalid input");
			               }
			         
		        System.out.println("enter 4 to continue : ");
		        a = in.nextInt();
		        
		     }while( a == 4);
		
		}
	}


