//ProgAssignmentM2A2.java
//Ryan Fischer
//9-6-2025
//Professor Parrot

import java.util.Scanner;

public class ProgAssignmentM2A2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three sides of the triangle: ");
        double side1;
        double side2;
        double side3;
        //Grabs the user input, if it fails all sides are defaulted to 1.0
        try {
            side1 = input.nextDouble();
            side2 = input.nextDouble();
            side3 = input.nextDouble();
        }
        catch (Exception e) {
            System.out.println("Invalid input. Defaulting all sides to 1.0.");
            side1 = 1.0;
            side2 = 1.0;
            side3 = 1.0;
            input.nextLine(); //<-Clears the invalid input
        }

        System.out.print("Enter a color for your triangle: ");
        String color;
        //Same for color
        try {
            color = input.next();
        }
        catch (Exception e) {
            System.out.println("Invalid input. Defaulting color to white.");
            color = "white";
            input.nextLine(); //<-Clears the invalid input
        }
        //Same for filled
        boolean filled;
        System.out.print("Is the triangle filled (true/false)? ");
        try {
            filled = input.nextBoolean();
        }
        catch (Exception e) {
            System.out.println("Invalid input. Defaulting to false.");
            filled = false;
        }
        
        //Creates your triangle with the data entered
        triangleObject triangle = new triangleObject(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println(triangle.toString());

        System.out.printf("\nThe area of the triangle is %.2f\n", triangle.getArea());
        System.out.printf("The perimeter of the triangle is %.2f\n", triangle.getPerimeter());

        input.close();
    }

    public static class triangleObject extends GeometricObject {
        private double side1 = 1.0;
        private double side2 = 1.0;
        private double side3 = 1.0;

        public triangleObject() {

        }

        public triangleObject(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public double getSide1() {
            return side1;
        }

        public double getSide2() {
            return side2;
        }

        public double getSide3() {
            return side3;
        }

        public void setSide1(double side1) {
            this.side1 = side1;
        }

        public void setSide2(double side2) {
            this.side2 = side2;
        }

        public void setSide3(double side3) {
            this.side3 = side3;
        }
        //Overrides for area and perimeter so they work with the triangle class
        @Override
        public double getArea() {
            double s = (side1 + side2 + side3) / 2.0;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }

        @Override
        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        public String toString() {
            return "Triangle:\n Side 1 = " + side1 + "\n Side 2 = " + side2 + "\n Side 3 = " + side3 + "\n Color = " + getColor()
                    + "\n Filled = " + isFilled();
        }

    }


    //Orignal abstracted class that triangle is built off of
    // GeometricObject.java: The abstract GeometricObject class
    public static abstract class GeometricObject {
        private String color = "white";
        private boolean filled;

        /**Default construct*/
        protected GeometricObject() {
        }

        /**Construct a geometric object*/
        protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        }

        /**Getter method for color*/
        public String getColor() {
        return color;
        }

        /**Setter method for color*/
        public void setColor(String color) {
        this.color = color;
        }

        /**Getter method for filled. Since filled is boolean,
        so, the get method name is isFilled*/
        public boolean isFilled() {
        return filled;
        }

        /**Setter method for filled*/
        public void setFilled(boolean filled) {
        this.filled = filled;
        }

        /**Abstract method findArea*/
        public abstract double getArea();
        /**Abstract method getPerimeter*/
        public abstract double getPerimeter();
    }

}


