package vzdornov.algo;

public class App 
{
    // pow
    public static double iterPow(double val,int exp) {
        double result = 1;

        if (exp == 0)
            return result;

        double multiplier = exp < 0 ? 1.0/val : val;
        int e = exp < 0 ? -exp : exp;

        for (int i = 1; i <= e; i++) {
            result *= multiplier;
        }
        return result;
    }

    public static double recursivePow(double val, int exp) {
        double result = 1;
        double multiplier = exp < 0 ? 1.0/val : val;
        int e = exp < 0 ? -exp : exp;
        if (e == 0)
            return result;
        if (e == 1)
            return multiplier;
        else if (e % 2 == 0)
            return recursivePow(multiplier * multiplier, e >> 1);
        else
            return multiplier*(recursivePow(multiplier * multiplier, (e - 1) >> 1));
    }

    public static double binPow(double val, int exp) {
        double result = 1;
        double multiplier = exp < 0 ? 1.0/val : val;
        int e = exp < 0 ? -exp : exp;

        if ((e & 1) > 0) {
            result *= multiplier;
        }
        e >>= 1;
        while (e > 0) {
            multiplier *= multiplier;
            if ((e & 1) > 0) {
                result *= multiplier;
            }
            e >>= 1;
        }
        return result;
    }


    // fib
    public static int fibSQRT(int n) {
        double goldValue = Math.sqrt(5);
        double phi = (goldValue + 1) / 2;
        return (int)(binPow(phi,n) / goldValue + 0.5);
    }

    public static int fibRecursive(int n) {
        if( n < 2 ) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibTopDownDinProg(int[] fibs,int n) {

        if( n < 2 ) {
            fibs[n] = n;
            return n;
        }

        if( fibs[n] != 0 ){
            return fibs[n];
        }
        
        fibs[n] = fibTopDownDinProg(fibs,n - 1) + fibTopDownDinProg(fibs,n - 2);
        return fibs[n];
    }

    public static int fibBottomUpDinProg(int n) {
        if( n < 2 ) {
            return n;
        }
        int fib0 = 0;
        int fib1 = 1;
        int fibn = 0;

        for( int q = 2; q <= n; q++ ) {
            fibn = fib0 + fib1;
            fib0 = fib1;
            fib1 = fibn;
        }

        return fibn;
    }

    // prime
    public static boolean isPrimeBruteForce(int n) {
        if( n == 1 ){
            return  false;
        }
        for( int q = 2; q*q <= n; q++ ) {
            if( n%q == 0 ) return false;
        }
        return true;
    }

    public static int countPrimesBruteForce(int n) {
        int s = 0;
        for( int q = 1; q <= n; q++ ) {
            if( isPrimeBruteForce(q) ) s++;
        }
        return s;
    }

    public static int countPrimesSieve(int n) {

        if (n < 2) {
            return 0;
        }

        int s = n + 1 - 2;
        int[] sieve = new int[n + 1];
        sieve[0] = 1;
        sieve[1] = 1;

        for (int q = 2; q * q <= n; q++) {
            if (sieve[q] == 0) {
                // то вычеркнем кратные k
                for (int k = q * q; k <= n; k += q) {
                    if (sieve[k] == 0) {
                        sieve[k] = 1;
                        s--;
                    }
                }
            }
        }

        return s;
    }

    public static void main( String[] args )
    {

        int a = countPrimesSieve(16);
        System.out.println(a);
    }
}
