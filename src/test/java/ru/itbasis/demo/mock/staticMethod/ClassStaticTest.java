package ru.itbasis.demo.mock.staticMethod;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/** Created by borz on 06.07.13. */
@Test(groups = {"static", "noMock"})
public class ClassStaticTest {
	@DataProvider
	public Object[][] data() throws Exception {
		return new Object[][]{{"", "value"}, {"test", "valuetest"}};
	}

	@Test
	public void testGetValueVoid() throws Exception {
		Assert.assertEquals(ClassStatic.getValue(), "value");
	}

	@Test(dataProvider = "data", dependsOnMethods = {"testGetValueVoid"})
	public void testGetValueAttribute(final String v, final String r) throws Exception {
		Assert.assertEquals(ClassStatic.getValue(v), r);
	}
}
