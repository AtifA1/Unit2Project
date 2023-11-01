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
    private double roundedToHundredth(double toRound) { //Rounds to the hundreths place
        return Math.round(toRound * 100.0) / 100.0;
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

    public String equation() {
        int deltaY = y2 - y1;
        int deltaX = x2 - x1;

        if (deltaY == 0) {
            // Handle the case of a horizontal line
            return "y = " + y1;
        } else {
            // Handle the slope as a fraction
            int absDeltaY = Math.abs(deltaY);
            int absDeltaX = Math.abs(deltaX);

            String slopePart;

            if (deltaX < 0 && deltaY < 0) {
                absDeltaX = Math.abs(absDeltaX);
                absDeltaY = Math.abs(absDeltaY);
            }

            if (absDeltaX == 1) {
                slopePart = absDeltaY + "x";
            } else {
                slopePart = absDeltaY + "/" + absDeltaX + "x";
            }

            int yInterceptValue = (int) yIntercept();

            String yInterceptPart = "";

            if (yInterceptValue != 0) {
                if (yInterceptValue > 0) {
                    yInterceptPart = " + " + yInterceptValue;
                } else if (yInterceptValue < 0) {
                    yInterceptPart = " - " + Math.abs(yInterceptValue);
                }
            }

            if ((deltaX < 0 && deltaY > 0) || (deltaX > 0 && deltaY < 0)) {
                slopePart = "-" + slopePart;
            }

            return "y = " + slopePart + yInterceptPart;
        }
    }



    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance();
    }
    public String coordinateForX(double x) {
        double y = roundedToHundredth(slope() * x + yIntercept());
        return "(" + roundedToHundredth(x) + ", " + y + ")";
    }
}