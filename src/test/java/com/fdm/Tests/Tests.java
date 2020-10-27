package com.fdm.Tests;

import org.junit.Test;
import org.mockito.Mock;
import com.fdm.Generate.Extractor;
import com.fdm.Generate.FetchUrlsApp;



public class Tests {
	
	@Mock
	Extractor mockExt;

	@Test
	public void test_thatExtractor_canExtractTheFirstURL() {
		int param1 = 1000000;
		int param2 = 1000999;
		FetchUrlsApp app = new FetchUrlsApp(mockExt , param1, param2);
		//pretend i wrote a proper test
		//pretend i wrote morrre code
	}

}
