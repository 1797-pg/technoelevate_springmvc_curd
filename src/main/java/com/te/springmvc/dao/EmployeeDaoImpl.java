package com.te.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.springmvc.EmployeeBean;
import com.te.springmvc.customexception.EmployeeExp;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceUnit
	EntityManagerFactory factory;
	@Override
	public EmployeeBean authenticate(int id, String pwd) {

		try {
       
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
		   throw new EmployeeExp("user not found");
		   
	   }
		}catch(Exception e){
			throw new EmployeeExp("user not found");
		}
		
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		 
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

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		
	       EntityManager manager=factory.createEntityManager();
	       EntityTransaction transaction=manager.getTransaction();
	       EmployeeBean info= manager.find(EmployeeBean.class,bean.getId());
	       if(info!=null) {
	    	   info.setId(bean.getId());
	       }
	       if(info.getName()!=null) {
	    	 info.setName(bean.getName());
	       }
	       if(info.getBirthdate()!=null) {
	    	   info.setBirthdate(bean.getBirthdate());
	       }
	       boolean isAdded=false;
	       transaction.begin();
	       manager.persist(info);
	       transaction.commit();
	       isAdded=true;
	       return isAdded;
	      
		
	}
	

}
