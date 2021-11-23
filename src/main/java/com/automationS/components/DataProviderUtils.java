package com.automationS.components;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderUtils {

    @DataProvider (name = "jsonDataProvider")
    public static Object[][] getJsonTestData(Method method) {
        return null;
    }
}
