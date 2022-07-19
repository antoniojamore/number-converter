import java.util.Scanner;

public class NumberConverter {
    
    public static void main(String[] args) {
        // create objects for methods and keyboard scanner
        Scanner in = new Scanner(System.in);
        NumberConverter conv = new NumberConverter();

        // welcome the user
        System.out.println("Welcome to the Number Converter program!");
        System.out.println("By Antonio Amore for CSIT 270 - EC Project");

        // 0 - go to main menu
        // 1 - binary to decimal
        // 2 - decimal to binary
        // 3 - exit program
        int option = 0;
        while(option != 3) {
            // main menu
            System.out.println();
            System.out.println("Please make a selection...");
            System.out.println(" [1] Convert binary to decimal");
            System.out.println(" [2] Convert decimal to binary");
            System.out.println(" [3] Exit program");
            System.out.print(" >> ");

            // set option to integer input
            option = in.nextInt();
            System.out.println();
            if(option < 1 || option > 3) {
                // less than 1 or greater than 3? user is a silly goose. 
                option = 0;
                System.out.println("[!] You must choose an option from 1 to 3. Try again. ");
            } else if(option == 1) {
                // binary to decimal
                System.out.println(" == [ Binary to Decimal Converter ] == ");
                System.out.print(" Binary number: ");
                int binaryNum = in.nextInt();
                System.out.println(" Decimal number: " + conv.binaryToDecimal(binaryNum));
            } else if(option == 2) {
                // decimal to binary
                System.out.println(" == [ Decimal to Binary Converter ] == ");
                System.out.print(" Decimal number: ");
                int decimalNum = in.nextInt();
                System.out.println(" Binary number: " + conv.decimalToBinary(decimalNum));
            } else if(option == 3) {
                // end program
                System.out.println("Goodbye! Thank you for using the program.");
            } else {
                // this shouldn't happen but just in case.
                System.out.println("Something went wrong. Sending you back to the main menu...");
                option = 0;
            }
        }
        // close input scanner to prevent issues
        in.close();
    }

    // binary to decimal
    private int binaryToDecimal(int binaryNum) {
        int decimalNum = 0;
        int base = 1;
        int temp = binaryNum;
        while(temp > 0) {
            int last = temp % 10;
            temp = temp / 10;
            decimalNum += last * base;
            base = base * 2;
        }
        return decimalNum;
    }

    // decimal to binary
    private int decimalToBinary(int decimalNum) {
        int binaryNum = 0;
        int temp = 0;
        while (decimalNum != 0) {
            int remainder = decimalNum % 2;
            double temp2 = Math.pow(10, temp);
            binaryNum += remainder * temp2;
            decimalNum /= 2;
            temp++;
        }
        return binaryNum;
    }
}