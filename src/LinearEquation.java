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
    public double distance() {  //Calculates the distance between the two points
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.round(Math.sqrt(dx * dx + dy * dy) * 100.0) / 100.0;
    }
    public double slope() { //Calculates the slope between the two points
        return Math.round(((double) (y2 - y1) / (x2 - x1)) * 100.0) / 100.0;
    }

    public double yIntercept() { //Calculates the y-intercept using the first coordinate
        return Math.round((y1 - (slope() * x1)) * 100.0) / 100.0;
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



}
