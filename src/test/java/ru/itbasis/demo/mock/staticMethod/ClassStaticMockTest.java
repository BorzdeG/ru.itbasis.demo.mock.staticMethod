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

/** Created by borz on 06.07.13. */
@Test(groups = {"static", "mock"})
@PrepareForTest({ClassStatic.class})
public class ClassStaticMockTest {

	@Mock
	public ClassStatic classStatic;

	@DataProvider
	public Object[][] data() throws Exception {
		return new Object[][]{{"", "newValue"}, {"test", "newValuetest"}};
	}

	@ObjectFactory
	public IObjectFactory setObjectFactory() {
		return new PowerMockObjectFactory();
	}

	@Test(dependsOnGroups = {"noMock"})
	public void mockGetValueVoid() throws Exception {
		mockStatic(ClassStatic.class);
		when(ClassStatic.getValue()).thenReturn("newValue");
		Assert.assertEquals(ClassStatic.getValue(), "newValue");
	}

	@Test(dataProvider = "data", dependsOnMethods = {"mockGetValueVoid"})
	public void testGetValueAttribute(final String v, final String r) throws Exception {
		mockStatic(ClassStatic.class);
		when(ClassStatic.getValue()).thenReturn("newValue");
		when(ClassStatic.getValue(v)).thenCallRealMethod();
		Assert.assertEquals(ClassStatic.getValue(v), r);
	}
}
