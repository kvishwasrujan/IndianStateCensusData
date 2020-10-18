package com.capgemini.indian_state_census_analyser;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.indianstatecensusanalyser.customexception.CensusAnalyserException;

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
	public void givenIncorrectCSVFilePath_ThrowsCustomExceptionOfTypeInvalidFilePath(){
		try {
			stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH+"123");
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}
	
	@Test
	public void givenIncorrectDelimiter_ThrowsCustomExceptionOfTypeInalidDelimiter(){
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_INCORRECT_DELIMITER));
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}
	
	@Test
	public void givenIncorrectHeader_ThrowsCustomExceptionOfTypeInvalidHeader(){
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_INCORRECT_HEADER));
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}
}
