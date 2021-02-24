package com.ryanchapin.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/*
 * The following annotations are required because we are Mocking static methods
 * in the classes listed in the PrepareForTest.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Utils.class })
public class AppTest {

    @Test
    public void testAdd() {

        // Prepare the Utils class to be spied.
        PowerMockito.spy(Utils.class);

        // Run the test and get the actual value from the OUT
        int actualValue = App.add("Test1", 1, 1);

        /*
         * To verify the number of times that we called Utils.doSomething we
         * first need to tell the PowerMockito library which class we are
         * verifying and how many times we are verifying that action.
         */
        PowerMockito.verifyStatic(Utils.class, Mockito.times(1));

        /*
         * Then, and this is not at all intuitive, we have to call the method
         * ourselves with the same parameters that we are expecting to have been
         * called. This tells PowerMockito which method invocation is to be
         * verified.
         */
        Utils.doSomething(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());

        assertEquals(2, actualValue);
    }
}
