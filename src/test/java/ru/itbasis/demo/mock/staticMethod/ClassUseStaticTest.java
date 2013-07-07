package ru.itbasis.demo.mock.staticMethod;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.mockito.MockitoAnnotations.Mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/** Created by borz on 08.07.13. */
@Test(groups = {"useStatic", "mock"}, dependsOnGroups = {"static"})
@PrepareForTest({ClassStatic.class})
public class ClassUseStaticTest {
	@Mock
	public ClassStatic classStatic;

	@DataProvider
	public Object[][] data() throws Exception {
		return new Object[][]{{"newValue1", "newValue1noStatic"}, {"newValue2", "newValue2noStatic"}};
	}

	@ObjectFactory
	public IObjectFactory setObjectFactory() {
		return new PowerMockObjectFactory();
	}

	@Test(dataProvider = "data")
	public void testGetValue(String value, String result) throws Exception {
		mockStatic(ClassStatic.class);
		when(ClassStatic.getValue()).thenReturn(value);
		ClassUseStatic testClass = new ClassUseStatic();
		Assert.assertEquals(result, testClass.getValue());
	}
}
