package vzdornov.algo;

/**
 * Hello world!
 *
 */
public class App 
{
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


    public static int fibSQRT(int n) {
        double goldValue = Math.sqrt(5);
        double phi = (goldValue + 1) / 2;
        return (int)(binPow(phi,n) / goldValue + 0.5);
    }

    public static int fibRecursive(int n) {
        if( n > 2 ) {
            return 1;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main( String[] args )
    {
    }
}
