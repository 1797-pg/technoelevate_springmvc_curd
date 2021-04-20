package com.te.springmvc.servicelayer;

import com.te.springmvc.EmployeeBean;

public interface EmployeeService {
	
	public EmployeeBean authenticate(int id,String password);
	public EmployeeBean getEmployee(int id);
	public boolean deleteEmpData(int id);
	public boolean addEmployee(EmployeeBean bean);
}
