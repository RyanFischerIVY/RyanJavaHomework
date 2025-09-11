public class ProgAssignmentM3A1 {
    public static void main(String[] args) {

    }

    public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /** Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created and the radius is " + radius);
    }


    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.radius, o.radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Circle other = (Circle) o;
        return Double.compare(radius, other.radius) == 0;
    }

    }


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
