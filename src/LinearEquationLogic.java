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
            System.out.println("The point of the line is " + equation.coordinateForX(xValue));

            if (repeat()) { //if you don't enter yes, the program will stop
                break;
            }
        }
    }

    private LinearEquation createEquation() {
        System.out.print("Enter Coordinate 1: ");
        String coordinate1 = myScanner.nextLine();

        int x1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf('(') + 1, coordinate1.indexOf(',')));
        int y1 = Integer.parseInt(coordinate1.substring(coordinate1.indexOf(',') + 2, coordinate1.indexOf(')')));

        System.out.print("Enter Coordinate 2: ");
        String coordinate2 = myScanner.nextLine();

        int x2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf('(') + 1, coordinate2.indexOf(',')));
        int y2 = Integer.parseInt(coordinate2.substring(coordinate2.indexOf(',') + 2, coordinate2.indexOf(')')));
        return new LinearEquation(x1, y1, x2, y2); //returns to LinearEquation
    }



    private double getXValueFromUser() {
        System.out.print("Enter an x value: ");
        return myScanner.nextDouble();
    }
    private boolean repeat() {
        System.out.print("Do you want to enter another pair of coordinates? (y/n): ");
        String response = myScanner.nextLine();
        return response.equals("y");
    }
}
