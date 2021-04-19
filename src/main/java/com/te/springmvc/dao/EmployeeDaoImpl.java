package com.te.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeeBean authenticate(int id, String pwd) {

       EntityManagerFactory factory=Persistence.createEntityManagerFactory("springdb");
       EntityManager manager=factory.createEntityManager();
       EmployeeBean bean= manager.find(EmployeeBean.class,id);
       if(bean!=null) {
    	   if(bean.getPassword().equals(pwd)) {
    		   System.out.println("login successful");
    		   return bean;
    	   }else {
    		   System.out.println("invalid");
    		   return null;
    	   }
       }else{
		   System.out.println("user not found");
		   return null;
	   }
		
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		 EntityManagerFactory factory=Persistence.createEntityManagerFactory("springdb");
	       EntityManager manager=factory.createEntityManager();
	       EmployeeBean bean= manager.find(EmployeeBean.class,id);
	       if(bean!=null) {
	    		   System.out.println(" successful");
	    		   return bean;
	    	   }else {
	    		   System.out.println("invalid");
	    		   return null;
	    	   }
	      
	}

	@Override
	public boolean deleteEmpData(int id) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("springdb");
	       EntityManager manager=factory.createEntityManager();
	       EntityTransaction transaction=manager.getTransaction();
	       EmployeeBean bean= manager.find(EmployeeBean.class,id);
	       transaction.begin();
		   manager.remove(bean);
		  transaction.commit();
		  if(bean!=null) {
			  System.out.println("deleted");
			  return true;
		  }
		  else {
			  System.out.println("not deleted");
			  return false;
		  }
		
		
	}

}
