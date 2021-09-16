package com.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity
@Service
public class OutputModel {

	@Id
	@GeneratedValue
	private long id;
	private String compareOutput;
	private String unCommonOutput;
	private String commonOutput;
	
	public OutputModel() {
		
	}
	
	public OutputModel(String compareOutput,String unCommonOutput,String commonOutput) {
		this.commonOutput = commonOutput;
		this.compareOutput = compareOutput;
		this.unCommonOutput = unCommonOutput;
	}


	public String getCompareOutput() {
		return compareOutput;
	}

	public void setCompareOutput(String compareOutput) {
		this.compareOutput = compareOutput;
	}

	public String getUnCommonOutput() {
		return unCommonOutput;
	}

	public void setUnCommonOutput(String unCommonOutput) {
		this.unCommonOutput = unCommonOutput;
	}

	public String getCommonOutput() {
		return commonOutput;
	}

	public void setCommonOutput(String commonOutput) {
		this.commonOutput = commonOutput;
	}
	
	
	
}
