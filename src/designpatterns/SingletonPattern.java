package designpatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
// https://www.geeksforgeeks.org/software-design-patterns/
public class SingletonPattern {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleTon singleTonObject = SingleTon.getSingleTonObject();
		System.out.println(singleTonObject.hashCode());
		SingleTon singleTonObject1 = SingleTon.getSingleTonObject();
		System.out.println(singleTonObject1.hashCode());

		// Through reflection you can break the singleton

		Constructor<?>[] constructors = SingleTon.class.getDeclaredConstructors();
		for (Constructor<?> c : constructors) {
			c.setAccessible(true);// should suppress Java access check
			SingleTon newInstance = (SingleTon) c.newInstance();
			System.out.println(newInstance.hashCode());
		}
	}

}

class SingleTon {
	private static SingleTon SINGLETON = new SingleTon();

	private SingleTon() {
	}

	static SingleTon getSingleTonObject() {
		return SINGLETON;
	}
}