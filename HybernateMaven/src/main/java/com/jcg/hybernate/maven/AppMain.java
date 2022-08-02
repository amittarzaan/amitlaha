package com.jcg.hybernate.maven;

import java.util.Date;

public class AppMain {


	public static void main(String[] args) {
		
		String argument=(args.length > 0 && null != args[0]) ? args[0]: "";
		// TODO Auto-generated method stub
		AppGetDelUpInMethod appGetDelUpInMethod=new AppGetDelUpInMethod();
	   // appGetDelUpInMethod.AddMulitpleRecords();
	    User usr=null;
	  // Insert multiple records part
	   // appGetDelUpInMethod.AddGetRecord(101);	
		
	    //add single records part
	  
	    /*
	    usr=new User();
		usr.setUserid(1000);
		usr.setUsername("amitlaha");
		usr.setCreatedBy("Administrator");
		usr.setCreatedDate(new Date());
		appGetDelUpInMethod.AddSingleRecord(usr); 
		*/
		
		//update single records part
	   
	    /*	
		usr.setCreatedBy("Aarashya");
		appGetDelUpInMethod.AddUpdateRecord(usr);
		System.out.println("updated");
		     */
		//delete single records part
		usr=appGetDelUpInMethod.AddGetRecord(1000);
		appGetDelUpInMethod.AddDeleteRecord(usr);
		System.out.println("deleted");
	    
	    
	    /*
		if(argument!=null&&argument.equalsIgnoreCase("SELECT")) {			
			appGetDelUpInMethod.AddGetRecord(1000);	
			System.out.println("selected");
		}else if(argument!=null&&argument.equalsIgnoreCase("ADD")) {
			usr=new User();
			usr.setUserid(1000);
			usr.setUsername("amitlaha");
			usr.setCreatedBy("Amit Laha");
			appGetDelUpInMethod.AddSingleRecord(usr);
			System.out.println("adde");
		}else if(argument!=null&&argument.equalsIgnoreCase("UPDATE")) {
			
			usr=appGetDelUpInMethod.AddGetRecord(1000);
			usr.setCreatedBy("Aarashya");
			appGetDelUpInMethod.AddUpdateRecord(usr);
			System.out.println("updated");
		}else if(argument!=null&&argument.equalsIgnoreCase("DELETE")) {
			
			usr=appGetDelUpInMethod.AddGetRecord(1000);
			appGetDelUpInMethod.AddDeleteRecord(usr);
			System.out.println("deleted");
			
		}
		*/
	}

}
