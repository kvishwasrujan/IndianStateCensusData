package com.capgemini.indianstatecensusanalyser.model;

import com.opencsv.bean.CsvBindByName;

/**
 * @author vishw
 *
 */
public class CSVStates {

	@CsvBindByName(column = "SrNo")
	private int serialNo;

	@CsvBindByName(column = "State Name")
	private String stateName;

	@CsvBindByName(column = "TIN")
	private int tin;

	@CsvBindByName(column = "StateCode")
	private String stateCode;

	@Override
	public String toString() {
		return "CSVStates [serialNo=" + serialNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode="
				+ stateCode + "]";
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
}
