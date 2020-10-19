package com.capgemini.indian_state_census_analyser;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.indianstatecensusanalyser.customexception.CensusAnalyserException;
import com.capgemini.indianstatecensusanalyser.customexception.CodeAnalyserException;

public class CensusAnalyserTest extends TestCase {
	private static final String CENSUS_DATA_PATH = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\files\\IndianStateCensus.csv";
	private static final String CENSUS_DATA_PATH_INCORRECT_DELIMITER = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\files\\IndianStateCensusDataIncorrectDelimiter";
	private static final String CENSUS_DATA_PATH_INCORRECT_HEADER = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\files\\IndianStateCensusDataIncorrectHeader.csv";
	private static final String STATE_CODE_DATA_PATH = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\src\\test\\java\\files\\IndiaStateCode.csv";
	private static final String STATE_CODE_DATA_PATH_INCORRECT_DELIMITER = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\src\\test\\java\\files\\IndiaStateCode.csv";
	private static final String STATE_CODE_DATA_PATH_INCORRECT_HEADER = "C:\\Users\\vishw\\eclipse-workspace\\indian-state-census-analyser\\src\\test\\java\\files\\IndiaStateCodeIncorrectHeader.csv";
	private StateCensusAnalyser stateCensusAnalyser;

	@Before
	public void init() {
		stateCensusAnalyser = new StateCensusAnalyser();
	}

	@Test
	public void givenCensusCSVFile_ReturnsCorrectNoOfEntries() throws CensusAnalyserException {
		int noOfEntries = stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH);
		assertEquals(28, noOfEntries);
	}

	@Test
	public void givenIncorrectCSVFilePath_ThrowsCustomExceptionOfTypeInvalidFilePath() {
		try {
			stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH + "123");
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}

	@Test
	public void givenIncorrectDelimiter_ThrowsCustomExceptionOfTypeInalidDelimiter() {
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_INCORRECT_DELIMITER));
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}

	@Test
	public void givenIncorrectHeader_ThrowsCustomExceptionOfTypeInvalidHeader() {
		try {
			System.out.println(stateCensusAnalyser.loadCensusData(CENSUS_DATA_PATH_INCORRECT_HEADER));
		} catch (CensusAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}

	@Test
	public void givenCodeCSVFile_ReturnsCorrectNoOfEntries() throws CodeAnalyserException {
		int noOfEntries = stateCensusAnalyser.loadCodeData(STATE_CODE_DATA_PATH);
		assertEquals(38, noOfEntries);
	}

	@Test
	public void givenIncorrectStateCodeCSVFilePath_ThrowsCodeAnalyserExceptionOfTypeInvalidFilePath() {
		try {
			stateCensusAnalyser.loadCodeData(STATE_CODE_DATA_PATH + "123");
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}

	@Test
	public void givenIncorrectStateCodeCSVClassType_ThrowsCodeAnalyserExceptionOfTypeInvalidClassType() {
		try {
			stateCensusAnalyser.loadCodeData(CENSUS_DATA_PATH);
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_CLASS_TYPE, e.type);
		}
	}

	@Test
	public void givenIncorrectStateCodeCSVDelimiter_ThrowsCodeAnalyserExceptionOfTypeInvalidDelimiter() {
		try {
			stateCensusAnalyser.loadCodeData(STATE_CODE_DATA_PATH_INCORRECT_DELIMITER);
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}

	@Test
	public void givenIncorrectStateCodeCSVHeader_ThrowsCodeAnalyserExceptionOfTypeInvalidHeader() {
		try {
			System.out.println(stateCensusAnalyser.loadCodeData(CENSUS_DATA_PATH_INCORRECT_HEADER));
		} catch (CodeAnalyserException e) {
			System.out.println(e.getMessage());
			assertEquals(CodeAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}
}
