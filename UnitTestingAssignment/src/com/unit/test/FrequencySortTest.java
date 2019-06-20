package com.unit.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class FrequencySortTest {
	private FrequencySort fs;
	@Before
	public void setUp()throws Exception {
		fs=new FrequencySort();

	}
	
	@After
	public void tearDown()throws Exception {
		System.gc();

	}

	@Test()
	void testGetSortedByFrequency() {
		String ar[]= {"xyz","abc","xyz","pqr","xyz","pqr","abc","abc","abc"};
		List<String> actualOutput=fs.getSortedByFrequency(ar);
		List<String> expectedOutput= Arrays.asList("abc","xyz","pqr");
		assertThat(actualOutput,is(expectedOutput));
	}

}
