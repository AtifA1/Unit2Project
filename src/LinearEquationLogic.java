import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner myScanner;

    public LinearEquationLogic() {
        myScanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Linear Equation Calculator!");

        while (true) {
            LinearEquation equation = createEquation();
            System.out.println("Line Info:");
            System.out.println(equation.lineInfo());

            double xValue = getXValueFromUser();
            System.out.println("Coordinate for x = " + xValue + ": " + equation.coordinateForX(xValue));

            if (!repeat()) { //if you don't enter yes, the program will stop
                break;
            }
        }
    }

    private LinearEquation createEquation() {
        System.out.print("Enter x1: ");
        int x1 = myScanner.nextInt();
        System.out.print("Enter y1: ");
        int y1 = myScanner.nextInt();
        System.out.print("Enter x2: ");
        int x2 = myScanner.nextInt();
        System.out.print("Enter y2: ");
        int y2 = myScanner.nextInt();
        return new LinearEquation(x1, y1, x2, y2);
    }

    private double getXValueFromUser() {
        System.out.print("Enter an x value: ");
        return myScanner.nextDouble();
    }

    private boolean repeat() {
        System.out.print("Do you want to enter another pair of coordinates? (yes/no): ");
        String response = myScanner.next();
        return response.equals("yes");
    }
}
