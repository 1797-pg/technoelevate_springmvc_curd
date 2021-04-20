package com.te.springmvc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_info")
public class EmployeeBean {

	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column(name="dob")
	private String birthdate;
	
	@Column
	private String password;
}
