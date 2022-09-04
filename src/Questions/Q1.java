package Questions;

import java.util.Scanner;


import empAbsImp.EmpImpl;
import jdbc.EmpException;

public class Q1 {

   public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("Enter id to get info about salary");
	
	int id = s.nextInt();
	
	EmpImpl e1 = new EmpImpl();
	
			try {
				int sal = e1.getSalary(id);
				System.out.println(sal);
			} catch (EmpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
}
}
