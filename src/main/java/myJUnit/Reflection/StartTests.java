package myJUnit.Reflection;

import myJUnit.Annotation.After;
import myJUnit.Annotation.Before;
import myJUnit.Annotation.MyJUnitException;
import myJUnit.Annotation.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StartTests {
	public static void start(String path) {
		List<Class<?>> listOfClasses = loadClassesFromPath(path);
		if (listOfClasses.size() == 0)
			throw new MyJUnitException("Не удалось найти классы из данного пакета");
		listOfClasses.forEach(StartTests::startMethods);
	}

	private static void startMethods(Class<?> aClass) {
		Object obj;
		try {
			obj = aClass.getConstructor().newInstance();
		getAnnotationsMethods(aClass, Test.class)
				.forEach(method -> runThis(method,
						getAnnotationsMethods(aClass, After.class),
						getAnnotationsMethods(aClass, Before.class), obj));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private static void runThis(Method method, List<Method> afterList, List<Method> beforeList, Object obj) {
		System.out.printf("Name testMethod: %s\n", method.getName());
		try {
			beforeList.forEach(beforeMethod -> {
				try {
					beforeMethod.invoke(obj);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			});
			method.invoke(obj);
			afterList.forEach(afterMethod -> {
				try {
					afterMethod.invoke(obj);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<Class<?>> loadClassesFromPath(String path) {
		return new Reflections(path, new SubTypesScanner(false))
				.getAllTypes()
				.stream()
				.map(StartTests::tryFoundClass)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	private static Class<?> tryFoundClass(String name) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	private static List<Method> getAnnotationsMethods(Class<?> aClass, Class annotate) {
		return Arrays.stream(aClass.getMethods())
				.filter(method -> method.getAnnotation(annotate) != null)
				.collect(Collectors.toList());
	}

}
