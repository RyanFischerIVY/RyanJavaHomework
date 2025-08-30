

public class conversion {
    public static void main(String[] args) {
        //Sets teh variables
        double foot = 1.0;
        double meter = 20.0;
        System.out.println("Feet     Meters   |   Meters   Feet"); //Formating
        System.out.println("-----------------------------------");
        for (int i = 0; i < 10; i++, foot++, meter += 5) {
            //Prints out the values and formats them correctly
            System.out.printf("%-8.0f%-9.3f|   %-8.0f%-9.3f%n", foot, footToMeter(foot), meter, meterToFoot(meter));
        }
    }

    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    public static double meterToFoot(double meter) {
        return meter * 3.279;
    }
}
