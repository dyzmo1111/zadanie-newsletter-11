package pl.javastart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Runner {
	public static void main(String[] args) {

		System.out.println("Nazwa klasy: ");
		Scanner scanner = new Scanner(System.in);
		String className = scanner.next();
		invokeMethod(className, "show");
	}

	public static void invokeMethod(String className, String methodName) {

		String packageName = Runner.class.getPackage().getName();
		String path = packageName + "." + className;

		try {
			Class<?> cl = Class.forName(path);
			Constructor<?> cons = cl.getDeclaredConstructors()[0];
			cons.setAccessible(true);
			Object obj = cons.newInstance("JavaStart");
			Method m = obj.getClass().getDeclaredMethod(methodName);
			m.invoke(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}
}
