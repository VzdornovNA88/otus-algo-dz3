package vzdornov.algo;

import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

// import org.openjdk.jmh.results.RunResult;
// import org.openjdk.jmh.runner.Runner;
// import org.openjdk.jmh.runner.RunnerException;
// import org.openjdk.jmh.runner.options.Options;
// import org.openjdk.jmh.runner.options.OptionsBuilder;

// import java.math.BigInteger;
// import java.util.Collection;

public class AppTest 
{

    double [][] powResults = {
        { 1,1,1, 1, 1,  1 },
        { 0,1,2, 3, 4,  5 },
        { 0,1,4, 9,16, 25 },
        { 0,1,8,27,64,125 },
    };

    int rows = powResults.length;
    int cols = powResults[0].length;

    // @BeforeAll
	// public static void init(){
	// 	System.out.println("Before All init() method called");
	// }

    @Test
    void testIterPow() {

        for( int q = 0; q < rows; q++ ) {
            for( int k = 0; k < cols; k++ ) {
                Assertions.assertEquals(powResults[q][k],App.iterPow(k,q));
            }
        }

        Assertions.assertEquals(0.0625,App.iterPow(4,-2));
    }

    @Test
    void testRecursivePow() {

        for( int q = 0; q < rows; q++ ) {
            for( int k = 0; k < cols; k++ ) {
                Assertions.assertEquals(powResults[q][k],App.recursivePow(k,q));
            }
        }
        
        Assertions.assertEquals(0.0625,App.recursivePow(4,-2));
    }

    @Test
    void testBinPow() {

        for( int q = 0; q < rows; q++ ) {
            for( int k = 0; k < cols; k++ ) {
                Assertions.assertEquals(powResults[q][k],App.binPow(k,q));
            }
        }

        Assertions.assertEquals(0.0625,App.binPow(4,-2));
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
