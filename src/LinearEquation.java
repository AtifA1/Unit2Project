public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double distance() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return roundedToHundredth(Math.sqrt(dx * dx + dy * dy));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public double slope() {
        return roundedToHundredth(((double) (y2 - y1) / (x2 - x1)));
    }
    public String equation() { //returns the full equation of the line
        double slope = slope();
        double yIntercept = yIntercept();

        if (slope == 1) {
            return "y = x + " + yIntercept;
        } else if (slope == -1) {
            return "y = -x + " + yIntercept;
        } else if (slope == 0) {
            return "y = " + yIntercept;
        } else if (yIntercept == 0) {
            return "y = " + slope + "x";
        } else if (yIntercept > 0) {
            return "y = " + slope + "x + " + yIntercept;
        } else {
            return "y = " + slope + "x - " + (-yIntercept);
        }
    }
    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance();
    }
    private double roundedToHundredth(double toRound) { //Rounds to the hundreths place
        return Math.round(toRound * 100.0) / 100.0;
    }
    public String coordinateForX(double x) {
        double y = roundedToHundredth(slope() * x + yIntercept());
        return "(" + roundedToHundredth(x) + ", " + y + ")";
    }
}
