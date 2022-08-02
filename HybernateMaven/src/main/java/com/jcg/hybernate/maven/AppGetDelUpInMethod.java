package com.jcg.hybernate.maven;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AppGetDelUpInMethod {

	private SessionFactory sessionFactory = DatabseUtill.buildSessionFactory();

	public void AddMulitpleRecords() {
		User userObj = null;
		Session sessionObj = null;
		try {

			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			for (int i = 101; i <= 105; i++) {
				userObj = new User();
				userObj.setUserid(i);
				userObj.setUsername("Editor " + i);
				userObj.setCreatedBy("Administrator");
				userObj.setCreatedDate(new Date());
				sessionObj.save(userObj);
			}
			System.out.println("Records successfully inserted");
			sessionObj.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occuresd " + e.getMessage());
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	public void AddSingleRecord(User userObj) {
		Session sessionObj = null;
		try {

			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			if (userObj!=null) {
				/*
				 * userObj.setUserid(i); userObj.setUsername("Editor " + i);
				 * userObj.setCreatedBy("Administrator"); userObj.setCreatedDate(new Date());
				 */
				sessionObj.save(userObj);
			}
			System.out.println("Single Record successfully inserted");
			sessionObj.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occuresd " + e.getMessage());
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	public void AddUpdateRecord(User userObj) {
		Session sessionObj = null;
		try {

			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			if (userObj!=null) {
				/*
				 * userObj.setUserid(i); userObj.setUsername("Editor " + i);
				 * userObj.setCreatedBy("Administrator"); userObj.setCreatedDate(new Date());
				 */
				sessionObj.saveOrUpdate(userObj);
			}
			System.out.println("Single Record successfully inserted");
			sessionObj.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occuresd " + e.getMessage());
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	
	public void AddDeleteRecord(User userObj) {
		Session sessionObj = null;
		try {

			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			if (userObj!=null) {
				/*
				 * userObj.setUserid(i); userObj.setUsername("Editor " + i);
				 * userObj.setCreatedBy("Administrator"); userObj.setCreatedDate(new Date());
				 */
				sessionObj.delete(userObj);
			}
			System.out.println("Single Record successfully inserted");
			sessionObj.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occuresd " + e.getMessage());
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	public User AddGetRecord(int userId) {
		Session sessionObj = null;
		User user=null;
		try {

			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			user=(User) sessionObj.get(User.class,userId);
			if(user!=null) {
			System.out.println("Single Record successfully retrived");			
            System.out.println("User Id:: "+user.getUserid());
            System.out.println("User Name :: "+user.getUsername());
            System.out.println("User Created Date:: "+user.getCreatedDate());
            System.out.println("User Created by:: "+user.getCreatedBy());
			}
            sessionObj.getTransaction().commit();
            
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occuresd " + e.getMessage());
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		return user;
	}
}
