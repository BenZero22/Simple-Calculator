/* This program is a simple java calculator that allows the user to add, multiple, divide or subtract two integers */

// Import modules required for writing to file and JObject windows

import javax.swing.*;
import java.util.Formatter;

// Declare SimpleCalculator class
public class SimpleCalculator {
    // Declare main class
    public static void main(String[] args) {
        // To allow recursive call on exception - we declared the main menu in a method - line 16
        mainMenu();
    }

    // Declare methods to tidy code
    public static void mainMenu() {
        // Error handling for incorrect user entry
        try{
            // Declare Formatter to write output file
            Formatter out = new Formatter("equations.txt");

            // Initialise main menu option value for while loop
            int operationOption = 100;
            while (operationOption != 0) {
                // Main Menu
                operationOption = Integer.parseInt(JOptionPane.showInputDialog("""
                                        Welcome to a simple Java Calculator
                            Enter number for the operation you would like to perform
                            1. Multiply
                            2. Divide
                            3. Subtract
                            4. Add
                                                
                        0. Quit"""));

                // Declare double variables to calculate with
                double firstInt;
                double secondInt;
                double answer;

                // User want to multiply
                if (operationOption == 1) {
                    // Obtain two integers from user
                    firstInt = Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                    secondInt = Integer.parseInt(JOptionPane.showInputDialog("Enter another number"));

                    // Perform multiplication operation on integers - method on line 110
                    answer = multiplyIntegers(firstInt,secondInt);

                    // Present equation and answer to user
                    JOptionPane.showMessageDialog(null, firstInt + " " + "x" + " " + secondInt +
                            " " + "= " + answer);
                    // Pend to write to file upon out.close().
                    out.format("%s %s %s %s %s %s", firstInt, " x ", secondInt, " = ", answer, "\r\n");
                }

                // User wants to divide
                if (operationOption == 2) {
                    firstInt = Integer.parseInt(JOptionPane.showInputDialog("Enter number"));

                    secondInt = Integer.parseInt(JOptionPane.showInputDialog("Enter another number"));
                    answer = divideIntegers(firstInt,secondInt);
                    JOptionPane.showMessageDialog(null, firstInt + " " + "/" + " " + secondInt +
                            " " + "= " + answer);
                    out.format("%s %s %s %s %s %s", firstInt, " / ", secondInt, " = ", answer, "\r\n");
                }

                // User wants to Subtract
                if (operationOption == 3) {
                    firstInt = Integer.parseInt(JOptionPane.showInputDialog("Enter number"));

                    secondInt = Integer.parseInt(JOptionPane.showInputDialog("Enter another number"));
                    answer = subtractIntegers(firstInt,secondInt);
                    JOptionPane.showMessageDialog(null, firstInt + " " + "-" + " " + secondInt +
                            " " + "= " + answer);
                    out.format("%s %s %s %s %s %s", firstInt, " - ", secondInt, " = ", answer, "\r\n");
                }

                // User wants to add
                if (operationOption == 4) {
                    firstInt = Integer.parseInt(JOptionPane.showInputDialog("Enter number"));

                    secondInt = Integer.parseInt(JOptionPane.showInputDialog("Enter another number"));
                    answer = addIntegers(firstInt,secondInt);
                    JOptionPane.showMessageDialog(null, firstInt + " " + "+" + " " + secondInt +
                            " " + "= " + answer);
                    out.format("%s %s %s %s %s %s", firstInt, " + ", secondInt, " = ", answer, "\r\n");
                }

                // User wants to exit the program
                if (operationOption == 0) {
                    JOptionPane.showMessageDialog(null, """
                            Program has closed!
                            File saved as "equations.txt"
                            """);
                    // Close output file in order to ensure equations are written
                    out.close();
                }
            }
        }
        catch (Exception e){
            // Present user with the particular error (be it string entry or file errors) - in this case, there would
            // be no exception caused for file creation, therefore the message will address user input format error.
            JOptionPane.showMessageDialog(null, "Error!\nPlease enter the number of the " +
                    "corresponding operation you would like to perform");

            // Recursive call to take the user back to the beginning of the main menu
            mainMenu();
        }

    }

    // For practise purposes - I realised that the code would be simpler by performing the operations without using
    // a method
    public static double multiplyIntegers(double firstNum, double secondNum){
        return firstNum * secondNum;
    }
    public static double divideIntegers(double firstNum, double secondNum){
        return firstNum / secondNum;
    }
    public static double subtractIntegers(double firstNum, double secondNum){
        return firstNum - secondNum;
    }
    public static double addIntegers(double firstNum, double secondNum){
        return firstNum + secondNum;
    }
}