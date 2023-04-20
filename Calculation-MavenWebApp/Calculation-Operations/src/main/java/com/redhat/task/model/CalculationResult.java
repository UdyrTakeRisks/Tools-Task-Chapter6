package com.redhat.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationResult {
	
	private int Result;
	
	public CalculationResult(int Result) {
		this.Result = Result;
	}
	
	@JsonProperty("Result")
	public int getResult() {
		return Result; 
	}
	
}
