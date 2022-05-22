package com.practice;

//Testing JUNIT 4 with param test

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

class PrimeNumberChecker {
    public Boolean validate(final Integer primeNumber){
        for(int i = 2; i < (primeNumber / 2); i++){
            if(primeNumber % i == 0){
                return false;
            }
        }
        return true;
    }
}

@RunWith(Parameterized.class)
public class Test1 {

    private Integer inputNumber;
    private Boolean expectedResult;
    private PrimeNumberChecker primeNumberChecker;

    @Before
    public void initialize(){
        primeNumberChecker = new PrimeNumberChecker();
    }

    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments
    // from parameters we defined in primeNumbers() method

    public Test1(Integer inputNumber, Boolean expectedResult){
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers(){
        return Arrays.asList(new Object[][]{
                {2, true},
                {6, false},
                {19, true},
                {22, false},
                {23, false}
        });
    }

    @Test
    public void testPrimeNumberChecker(){
        System.out.println("Parameterized Number is : " + inputNumber);
        assertEquals(expectedResult,
                     primeNumberChecker.validate(inputNumber));
    }
}


