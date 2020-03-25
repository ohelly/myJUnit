package myjunit;

import myjunit.reflection.StartTests;

import java.lang.reflect.InvocationTargetException;

public class App 
{
    public static void main( String[] args ) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        StartTests.start("myjunit.test.calc");
    }
}
