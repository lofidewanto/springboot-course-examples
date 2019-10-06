package com.example.demo.server;

public class Employee {

	private long id;

	private double salary;

	public Employee(long id, double salary) {
		this.id = id;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
