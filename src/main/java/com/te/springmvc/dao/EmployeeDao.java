package com.te.springmvc.dao;

import com.te.springmvc.EmployeeBean;

public interface EmployeeDao {

	public EmployeeBean authenticate(int id,String password);
	public EmployeeBean getEmployee(int id);
	public boolean deleteEmpData(int id);
}
