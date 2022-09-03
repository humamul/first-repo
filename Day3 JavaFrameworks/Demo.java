package com.masai.app1;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	
	
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
	//this method calls persistence.xml into memory , need only one per data base,  it will take the logical name , create a connection pool,
		// A heavy wgt obj needed only one;
		
		
		EntityManager em = emf.createEntityManager();
		//one per use case(DAO Method) we need Entity Manager;
                //using emf we make Entity Manager object
		// JPA appl -> EntMan -> ORM engine -> JDBC -> DB(forward query to database)
		
		//DML(insert,update ,delete, = need transactional area  em.getTransaction()
		
		Student s1 = new Student(30, 60, "Ratan");
		
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		
//		em.persist(s1);
//		
//		et.commit();
//		
//		can be written like
//		
//		em.getTransaction().begin();
//		em.persist(s1);
//		em.getTransaction().commit();
	//==============Inserted End================//
		
//		Student s = em.find(Student.class, 10);
//		
//		
//		if(s!=null) {
//			em.getTransaction().begin();
//			em.remove(s);
//			em.getTransaction().commit();
//		}else {
//			System.out.println("Student does not exist");
//		}
//		
		
		//=============Deletion/remove End================//
		
		Student s = em.find(Student.class, 10);//returns the object// this will be in the persistence state, 
		
//		if we call em.clear(); this object will go to detached state and there will be no changes after this state
	
		
		
		
		
		
		if(s!=null) {
			em.getTransaction().begin();
//			em.remove(s);
			s.setMarks(s.getMarks()+100); // s is in persistence state
//after using em.clear() line 63, if you use em.merge(s) then it will update the table;
			
			em.getTransaction().commit();
			System.out.println("Marks is graced");
		}else {
			System.out.println("Student does not exist");
		}
		
		em.close(); // call on em obj then all the associated entity
		
		//=============Updating End================//

//1.New State/transient state(not attached with the EM Obj,  Student s = new Student(10,39,"CHa");


		
		
		
//		Student s = em.find(Student.class,12);
//		
//		if(s!=null) {
//			System.out.println(s);
//		}else {
//			System.out.println("Student does not exist");
//		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	
////old method
//	public static void main(String[] args) {
//		System.out.println("Welcome to Maven");
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
////			 TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		String url = "jdbc:mysql://localhost:3306/database";
//		
//		Connection con;
//		try {
//			con = DriverManager.getConnection(url,"root","root");
//		System.out.println(con);	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		
//	}
	
	// go to xml and search in  google -- my sql connector mvn
	
//for xml java 1.8	<!-- maven compiler source  search-->
}
// Maintaining the data - logic we write to implement this part of business application is known Data Access Logic.
// processing = Business/Service Logic
//presenting = presentation logic;

//We can enter All three logic in one class;
//Limitations: Can Mix with eachother, modification in one can affect the other, 
//testing will become complex, logics depend upon each other so can't go parallel 

//all three layers along with data layer 

//presentation will be made using  core =  Servlet/JSP    || frame = Struts/JSF/Spring MVC;  == Frontend
//Service Layer will be made using EJB  ||  Spring;  = backendb  business logic layer is implementing the business rule using language
//Data Access Layer will be made by JDBC   ||  JPA / Hibernate this is backend 
// DAL using JDBC and DAO pattern

// note : to communicate among the layers using loose coupling should be promoted;

