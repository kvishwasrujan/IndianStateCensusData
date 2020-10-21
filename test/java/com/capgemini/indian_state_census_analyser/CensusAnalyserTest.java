package com.capgemini.indian_state_census_analyser;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.indianstatecensusanalyser.customexception.CensusAnalyserException;
import com.capgemini.indianstatecensusanalyser.model.IndiaStateCensus;
import com.google.gson.Gson;

public class CensusAnalyserTest extends TestCase {
	private static final String CENSUS_DATA_PATH = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\files\\IndianStateCensus.csv";
	private static final String CENSUS_DATA_PATH_INCORRECT_DELIMITER = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\files\\IndianStateCensusDataIncorrectDelimiter";
	private static final String CENSUS_DATA_PATH_INCORRECT_HEADER = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\files\\IndianStateCensusDataIncorrectHeader.csv";

	private StateCensusAnalyser stateCensusAnalyser;

	@Before
	public void init() {
		stateCensusAnalyser = new StateCensusAnalyser();
	}

	@Test
	public void givenCensusCSVFile_ReturnsCorrectNoOfEntries() throws CensusAnalyserException {
		int noOfEntries = stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH);
		assertEquals(29, noOfEntries);
	}

	@Test
	public void givenIncorrectCSVFilePath_ThrowsCensusAnalyserExceptionOfTypeInvalidFilePath() {
		try {
			stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH + "123");
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}

	@Test
	public void givenIncorrectCSVClassType_ThrowsCensusAnalyserExceptionOfTypeInvalidClassType() {
		try {
			stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH);
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_CLASS_TYPE, e.type);
		}
	}

	@Test
	public void givenIncorrectDelimiter_ThrowsCensusAnalyserExceptionOfTypeInvalidDelimiter() {
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_INCORRECT_DELIMITER));
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}

	@Test
	public void givenIncorrectHeader_ThrowsCensusAnalyserExceptionOfTypeInvalidHeader() {
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_INCORRECT_HEADER));
		} catch (CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}

	@Test
	public void givenIndianCensusData_WhenSortedOnState_ShouldReturnSortedResult() throws CensusAnalyserException {
		String sortedCensusData = "";
		stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH);
		sortedCensusData = stateCensusAnalyser.getStateWiseSortedCensusData();
		IndiaStateCensus[] censusData = new Gson().fromJson(sortedCensusData, IndiaStateCensus[].class);
		assertEquals("Andhra Pradesh", censusData[0].getStateName());
	}

}
