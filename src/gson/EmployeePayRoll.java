package gson;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;


public class EmployeePayRoll implements Serializable{
	
		private  int id;
    	private  String name;
		private  double salary;
		
		
	    public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public double getSalary() {
			return salary;
		}
		
		
		static List<EmployeePayRoll> list = new ArrayList<>();
		File file = new File("E:\\eclipseworkspace\\employeepayroll\\employee_directory\\Employee.txt");
	    ObjectOutputStream oos = null;
		
	     public EmployeePayRoll() {
			// TODO Auto-generated constructor stub
		}
		public EmployeePayRoll(int id , String name , double salary) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.name = name ;
			this.salary = salary ;
		}
		
		public  void getdata() throws Exception, IOException
	    {
		 Scanner in = new Scanner(System.in);

		 System.out.println("ENTER NO.OF ENTRIES TO BE ENTERED : ");
		 int n = in.nextInt();
		 
		     for(int i = 0 ; i < n; i++ )
		     {  System.out.println("ENTER EMPLOYEE ID : ");
		       id = in.nextInt();
		       System.out.println("ENTER EMPLOYEE NAME : ");
		       name = in.next();
		       System.out.println("ENTER EMPLOYEE SALARY : ");
		       salary = in.nextDouble(); 
		       
		      list.add(new EmployeePayRoll(id , name ,salary));
		     }
		      oos = new ObjectOutputStream(new FileOutputStream(file));
	         oos.writeObject(list);
	         oos.close();
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
			//creating object of gson jar
			Gson gson = new Gson();       
			
			File file = new File("E:\\eclipseworkspace\\employeepayroll\\Employee.txt");
			file.createNewFile();
		 
			ObjectInputStream ois = null;
			if(file.exists()== true) {
				ois = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<EmployeePayRoll>)ois.readObject(); 
				ois.close();
				}
			
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


