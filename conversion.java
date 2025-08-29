

public class conversion {
    public static void main(String[] args) {

        double foot = 1.0;
        double meter = 20.0;
        System.out.println("Feet     Meters   |   Meters   Feet");
        System.out.println("-----------------------------------");
        for (int i = 0; i < 10; i++, foot++, meter += 5)
            System.out.println(foot + "      " + String.format("%.3f", footToMeter(foot))  + "    |   " + meter + "     " + String.format("%.3f", meterToFoot(meter)));
    }

    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    public static double meterToFoot(double meter) {
        return meter * 3.279;
    }
}
