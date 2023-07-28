package com.map;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Emp> emp;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pid, String projectName, List<Emp> emp) {
		super();
		this.pid = pid;
		this.projectName = projectName;
		this.emp = emp;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmp() {
		return emp;
	}

	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}
}
