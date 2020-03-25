package myjunit.reflection;

import myjunit.annotation.After;
import myjunit.annotation.Before;
import myjunit.annotation.MyJUnitException;
import myjunit.annotation.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StartTests {
	private final static StartTests framework = new StartTests();

	public static void start(String path) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		List<Class<?>> listOfClasses = framework.loadClassesFromPath(path);
		if (listOfClasses.size() == 0)
			throw new MyJUnitException("Не удалось найти классы из данного пакета");
		for (Class<?> listOfClass : listOfClasses) {
			framework.getMethodsForTestsFromClass(listOfClass);
		}
	}

	private void getMethodsForTestsFromClass(Class<?> aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Object obj = aClass.getConstructor().newInstance();
		List<Method> methodsWithTestAnnotation = getAnnotationsMethods(aClass, Test.class);
		List<Method> methodsWithBeforeAnnotation = getAnnotationsMethods(aClass, Before.class);
		List<Method> methodsWithAfterAnnotation = getAnnotationsMethods(aClass, After.class);

		for (Method method : methodsWithTestAnnotation) {
			startMethodsWithBeforeAfterAnnotation(methodsWithBeforeAnnotation, obj);
			startMethodsWithTestAnnotation(method, obj);
			startMethodsWithBeforeAfterAnnotation(methodsWithAfterAnnotation, obj);
		}
	}

	private void startMethodsWithTestAnnotation(Method method, Object obj) throws InvocationTargetException, IllegalAccessException {
		System.out.printf("Name testMethod: %s\n", method.getName());
		method.invoke(obj);
	}

	private void startMethodsWithBeforeAfterAnnotation(List<Method> methods, Object obj) throws InvocationTargetException, IllegalAccessException {
		for (Method method : methods) {
			method.invoke(obj);
		}
	}

	private List<Class<?>> loadClassesFromPath(String path) {
		return new Reflections(path, new SubTypesScanner(false))
				.getAllTypes()
				.stream()
				.map(framework::tryFoundClass)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	private Class<?> tryFoundClass(String name) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	private List<Method> getAnnotationsMethods(Class<?> aClass, Class annotate) {
		return Arrays.stream(aClass.getMethods())
				.filter(method -> method.getAnnotation(annotate) != null)
				.collect(Collectors.toList());
	}

}
