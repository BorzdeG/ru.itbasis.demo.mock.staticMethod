package ru.itbasis.demo.mock.staticMethod;

/** Created by borz on 06.07.13. */
public class ClassStatic {
	static String getValue() {
		return "value";
	}

	static String getValue(final String s) {
		return getValue() + s;
	}
}