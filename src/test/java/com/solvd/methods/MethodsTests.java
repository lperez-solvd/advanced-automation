package com.solvd.methods;

import com.solvd.utils.RetryUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodsTests {

    @Test (description = "Introducing certain base price should calculate the final price with taxes" , retryAnalyzer = RetryUtil.class)
    public void testMethods() {
        MethodsToTest methods = new MethodsToTest();

        double totalWithTaxes = methods.getTotalWithTaxes(1);

        // Will intentionally fail
        Assert.assertEquals(totalWithTaxes, 1.4, "The total price with taxes in not correct");

    }

}
