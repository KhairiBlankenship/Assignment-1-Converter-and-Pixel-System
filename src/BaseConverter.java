import java.util.Scanner;

public class BaseConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number Base Converter");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Octal");
        System.out.println("4. Hexadecimal");

        System.out.print("Choose the input base (1-4): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the number: ");
        String number = scanner.next();

        int base;

        switch (choice) {
            case 1:
                base = 2;
                break;
            case 2:
                base = 10;
                break;
            case 3:
                base = 8;
                break;
            case 4:
                base = 16;
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        try {
            int decimal = Integer.parseInt(number, base);

            System.out.println("Binary:      " + Integer.toBinaryString(decimal));
            System.out.println("Decimal:     " + decimal);
            System.out.println("Octal:       " + Integer.toOctalString(decimal));
            System.out.println("Hexadecimal: " + Integer.toHexString(decimal).toUpperCase());

        } catch (NumberFormatException e) {
            System.out.println("Invalid number for the selected base.");
        }

        scanner.close();
    }
}
