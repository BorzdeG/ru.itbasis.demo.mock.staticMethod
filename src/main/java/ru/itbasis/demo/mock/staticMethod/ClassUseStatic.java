package ru.itbasis.demo.mock.staticMethod;

/** Created by borz on 08.07.13. */
public class ClassUseStatic {
	public String getValue() {
		return ClassStatic.getValue() + "noStatic";
	}
}
