import java.math.BigInteger;
import java.util.Scanner;


public class ProgAssignmentM3A2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Takes in the input
        System.out.print("Enter the first rational number: ");
        BigInteger n1 = input.nextBigInteger();
        BigInteger d1 = input.nextBigInteger();
        Rational r1 = new Rational(n1, d1);

        System.out.print("Enter the second rational number: ");
        BigInteger n2 = input.nextBigInteger();
        BigInteger d2 = input.nextBigInteger();
        Rational r2 = new Rational(n2, d2);
        //does all the operations to the inputs
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());

        input.close();
    }


    public static class Rational extends Number implements Comparable<Rational> {
        // Data fields for numerator and denominator
        private BigInteger numerator = BigInteger.ZERO;
        private BigInteger denominator = BigInteger.ONE;

        /** Construct a rational with default properties */
        public Rational() {
            this(BigInteger.ZERO, BigInteger.ONE);
        }

        /** Construct a rational with specified numerator and denominator */
        public Rational(BigInteger numerator, BigInteger denominator) {
            BigInteger gcd = numerator.gcd(denominator);
            BigInteger sign = denominator.signum() > 0 ? BigInteger.ONE : BigInteger.valueOf(-1);

            this.numerator = numerator.multiply(sign).divide(gcd);
            this.denominator = denominator.abs().divide(gcd);
        }

        /** Find GCD of two numbers */
        private static long gcd(long n, long d) {
            long n1 = Math.abs(n);
            long n2 = Math.abs(d);
            int gcd = 1;

            for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
            }

            return gcd;
        }

        /** Return numerator */
        public BigInteger getNumerator() {
            return numerator;
        }

        /** Return denominator */
        public BigInteger getDenominator() {
            return denominator;
        }

        /** Add a rational number to this rational */
        public Rational add(Rational secondRational) {
                BigInteger n = numerator.multiply(secondRational.denominator)
                .add(denominator.multiply(secondRational.numerator));
                BigInteger d = denominator.multiply(secondRational.denominator);
                return new Rational(n, d);
        }

        /** Subtract a rational number from this rational */
        public Rational subtract(Rational secondRational) {
            BigInteger n = numerator.multiply(secondRational.denominator)
            .subtract(denominator.multiply(secondRational.numerator));
            BigInteger d = denominator.multiply(secondRational.denominator);
            return new Rational(n, d);
        }

        /** Multiply a rational number by this rational */
        public Rational multiply(Rational secondRational) {
            BigInteger n = numerator.multiply(secondRational.numerator);
            BigInteger d = denominator.multiply(secondRational.denominator);
            return new Rational(n, d);
        }

        /** Divide a rational number by this rational */
        public Rational divide(Rational secondRational) {
            BigInteger n = numerator.multiply(secondRational.denominator);
            BigInteger d = denominator.multiply(secondRational.numerator);
            return new Rational(n, d);
        }

        @Override
        public String toString() {
            if (denominator == BigInteger.ONE)
            return numerator + "";
            else
            return numerator + "/" + denominator;
        }

        @Override // Override the equals method in the Object class
        public boolean equals(Object other) {
            if (!(other instanceof Rational)) return false;
        Rational o = (Rational) other;
        return numerator.equals(o.numerator) && denominator.equals(o.denominator);
        }

        @Override // Implement the abstract intValue method in Number
        public int intValue() {
            return (int)doubleValue();
        }

        @Override // Implement the abstract floatValue method in Number
        public float floatValue() {
            return (float)doubleValue();
        }

        @Override // Implement the doubleValue method in Number
        public double doubleValue() {
            return numerator.doubleValue() / denominator.doubleValue();
        }

        @Override // Implement the abstract longValue method in Number
        public long longValue() {
            return (long)doubleValue();
        }

        @Override // Implement the compareTo method in Comparable
        public int compareTo(Rational o) {
            BigInteger n1 = numerator.multiply(o.getDenominator());
            BigInteger n2 = denominator.multiply(o.getNumerator());
            return n1.compareTo(n2);
        }
    }



}
