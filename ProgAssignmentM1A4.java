public class ProgAssignmentM1A4 {
    public static void main(String[] args) {
        regularPolygon polygon1 = new regularPolygon();
        regularPolygon polygon2 = new regularPolygon(6, 4);
        regularPolygon polygon3 = new regularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1: ");
        System.out.println("Perimeter: " + polygon1.getPerimeter());
        System.out.println("Area: " + polygon1.getArea() + "\n");

        System.out.println("Polygon 2: ");
        System.out.println("Perimeter: " + polygon2.getPerimeter());
        System.out.println("Area: " + polygon2.getArea() + "\n");

        System.out.println("Polygon 3: ");
        System.out.println("Perimeter: " + polygon3.getPerimeter());
        System.out.println("Area: " + polygon3.getArea() + "\n");
        

        
    }




    //Class for the regular polygon with all its methods
    public static class regularPolygon {
        private int n = 3;
        private double side = 1.0;
        private double x = 0.0;
        private double y = 0.0;
        //3 contructors to serve different roles
        public regularPolygon() {

        }

        public regularPolygon(int n, double side) {
            this.n = n;
            this.side = side;
        }

        public regularPolygon(int n, double side, double x, double y) {
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }
        //Getters and setters for all important variables
        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public double getSide() {
            return side;
        }

        public void setSide(double side) {
            this.side = side;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
        //Formula to find the perimeter
        public double getPerimeter() {
            return n * side;
        }
        //Formula to find the area
        public double getArea() {
            return (n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n)));
        }
    }
}
