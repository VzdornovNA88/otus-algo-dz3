package vzdornov.algo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

// import java.math.BigInteger;
// import java.util.Collection;

class AppTest 
{

    double [][] powResults = {
        { 1  ,1  ,1                   , 1                  , 1                  ,  1                },
        { 0  ,1  ,2                   , 3                  , 4                  ,  5                },
        { 0  ,1  ,4                   , 9                  ,16                  , 25                },
        { 0  ,1  ,8                   ,27                  ,64                  ,125                },
        { 0  ,1  ,Math.pow(2,4)   ,Math.pow(3,4)   ,Math.pow(4,4)   ,Math.pow(5,4)  },
        { 0  ,1  ,Math.pow(2,5)   ,Math.pow(3,5)   ,Math.pow(4,5)   ,Math.pow(5,5)  },
        { 0  ,1  ,Math.pow(2,6)   ,Math.pow(3,6)   ,Math.pow(4,6)   ,Math.pow(5,6)  },
        { 0  ,1  ,Math.pow(2,7)   ,Math.pow(3,7)   ,Math.pow(4,7)   ,Math.pow(5,7)  },
        { 0  ,1  ,Math.pow(2,8)   ,Math.pow(3,8)   ,Math.pow(4,8)   ,Math.pow(5,8)  },
        { 0  ,1  ,Math.pow(2,9)   ,Math.pow(3,9)   ,Math.pow(4,9)   ,Math.pow(5,9)  },
        { 0  ,1  ,Math.pow(2,10)  ,Math.pow(3,10)  ,Math.pow(4,10)  ,Math.pow(5,10) },
        { 0  ,1  ,Math.pow(2,11)  ,Math.pow(3,11)  ,Math.pow(4,11)  ,Math.pow(5,11) },
    };

    double[] powResults1 = {};

    int rows = powResults.length;
    int cols = powResults[0].length;

    int[] fibs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

    static Map<Integer,Integer> primes; 

static {
        Map<Integer, Integer> hMap = new HashMap<Integer,Integer>();
        
        hMap.put(10, 4); 
        hMap.put(1, 0);
        hMap.put(2, 1);
        hMap.put(3, 2);
        hMap.put(4, 2);
        hMap.put(5, 3);
        hMap.put(100, 25);
        hMap.put(1000, 168);
        hMap.put(10000, 1229);
        hMap.put(100000, 9592);
        hMap.put(1000000, 78498);
        hMap.put(10000000, 664579);
        hMap.put(100000000, 5761455);
        hMap.put(1000000000, 50847534);
        hMap.put(123456789, 7027260);
        
        primes = Collections.unmodifiableMap(hMap);
    }
// @BeforeAll
	// public static void init(){
	// 	System.out.println("Before All init() method called");
	// }

    @DisplayName("Iter evaluation power of numder method test")
    @Test
    void testIterPow() {

        for( int q = 0; q < rows; q++ ) {
            for( int k = 0; k < cols; k++ ) {
                Assertions.assertEquals(powResults[q][k],App.iterPow(k,q));
            }
        }

        Assertions.assertEquals(0.0625,App.iterPow(4,-2));
        Assertions.assertEquals(Math.pow(123456789,0),App.iterPow(123456789,0));

        for( int q = 1; q < 11; q++ ) {
            int power = (int)Math.pow(10,q);
            double base = 1.0 + 1.0 / (double)power;
            Assertions.assertEquals((float)Math.pow(base,power),(float)App.iterPow(base,power));
        }
    }

    @Test
    void testRecursivePow() {

        for( int q = 0; q < rows; q++ ) {
            for( int k = 0; k < cols; k++ ) {
                Assertions.assertEquals(powResults[q][k],App.recursivePow(k,q));
            }
        }
        
        Assertions.assertEquals(0.0625,App.recursivePow(4,-2));
        Assertions.assertEquals(Math.pow(123456789,0),App.recursivePow(123456789,0));

        for( int q = 1; q < 11; q++ ) {
            int power = (int)Math.pow(10,q);
            double base = 1.0 + 1.0 / (double)power;
            Assertions.assertEquals((float)Math.pow(base,power),(float)App.recursivePow(base,power));
        }
    }

    @Test
    void testBinPow() {

        for( int q = 0; q < rows; q++ ) {
            for( int k = 0; k < cols; k++ ) {
                Assertions.assertEquals(powResults[q][k],App.binPow(k,q));
            }
        }

        Assertions.assertEquals(0.0625,App.binPow(4,-2));
        Assertions.assertEquals(Math.pow(123456789,0),App.binPow(123456789,0));

        for( int q = 1; q < 11; q++ ) {
            int power = (int)Math.pow(10,q);
            double base = 1.0 + 1.0 / (double)power;
            Assertions.assertEquals((float)Math.pow(base,power),(float)App.binPow(base,power));
        }
    }

    @Test
    void testFibBottomUpDinProg() {
        for ( int q = 0; q < fibs.length; q++ ) {
            Assertions.assertEquals(fibs[q],App.fibBottomUpDinProg(q));
        }
    }

    @Test
    void testFibRecursive() {
        for ( int q = 0; q < fibs.length; q++ ) {
            Assertions.assertEquals(fibs[q],App.fibRecursive(q));
        }
    }

    @Test
    void testFibSQRT() {
        for ( int q = 0; q < fibs.length; q++ ) {
            Assertions.assertEquals(fibs[q],App.fibSQRT(q));
        }
    }

    @Test
    void testFibTopDownDinProg() {
        int[] fibs_ = new int[fibs.length];
        for ( int q = 0; q < fibs.length; q++ ) {
            Assertions.assertEquals(fibs[q],App.fibTopDownDinProg(fibs_,q));
        }
    }

    @Test
    void testCountPrimesBruteForce() {
        for (Map.Entry<Integer, Integer> entry : primes.entrySet()) { 
            Assertions.assertEquals(entry.getValue(),App.countPrimesBruteForce(entry.getKey())); 
        }
    }

    @Test
    void testCountPrimesSieve() {
        for (Map.Entry<Integer, Integer> entry : primes.entrySet()) { 
            Assertions.assertEquals(entry.getValue(),App.countPrimesSieve(entry.getKey())); 
        }
    }


    // @DisplayName("benchmark")
	// @Test
    // void testBenchCountLuckyDinProgMethod() {
    //     Options opt = new OptionsBuilder()
    //             .include(AppBenchmark.class.getSimpleName())
    //             .forks(1)
    //             .build();

    //     try {
    //         new Runner(opt).run();
    //     } catch (RunnerException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }
}
