package codingStyle;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import codingStyle.CodingStyle;

public class CodingStyleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		CodingStyle g = new CodingStyle();
		g.setVisible(true);
	}

}
