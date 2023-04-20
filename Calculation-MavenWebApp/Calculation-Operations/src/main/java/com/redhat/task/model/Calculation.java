package com.redhat.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@JsonPropertyOrder({"number1","number2","operation"})
public class Calculation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id; //dummy identifier
	
	@NotNull
	private int Number1;
	
	@NotNull
	private int Number2;
	
	
	@NotNull
	@Size(min=1,max=1,message="Invalid Operator")
	private String Operation; 
	
	
	//getters
	
	public int getNumber1() {
		return Number1;
	}
	
	public int getNumber2() {
		return Number2;
	}
	
	public String getOperation() {
		return Operation;
	}
	
	
	//setters
	
	public void setNumber1(int Number1) {
		this.Number1 = Number1;
	}
	
	public void setNumber2(int Number2) {
		this.Number2 = Number2;
	}
	
	public void setOperation(String Operation) {
		this.Operation = Operation;
	}
}