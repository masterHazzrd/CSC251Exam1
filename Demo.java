import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<HoneyOrder> orders = new ArrayList<>();

        while (true) {
            System.out.println("Type of Honey:\n1. Orange Blossom\n2. Wildflower\n3. Clover");
            System.out.print("Select the type of honey: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            String honeyType = "";
            switch (choice) {
                case 1:
                    honeyType = "Orange Blossom";
                    break;
                case 2:
                    honeyType = "Wildflower";
                    break;
                case 3:
                    honeyType = "Clover";
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid type of honey.");
                    continue; // Skip to the next iteration of the loop
            }

            System.out.print("Enter the number of pounds ordered: ");
            if (scanner.hasNextInt()) {
                int pounds = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (pounds == 0) {
                    break; // Exit the loop when the user enters 0
                }
                HoneyOrder order = new HoneyOrder(honeyType, pounds);
                orders.add(order);
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); // Clear the invalid input
            }

            System.out.print("Would you like to enter another order of honey (Y/N)?: ");
            String again = scanner.nextLine().trim();
            if (!again.equalsIgnoreCase("Y")) {
                break; // Exit the loop when the user enters anything other than "Y"
            }
        }

        scanner.close();

        System.out.println("\nHoney Sales Report:\n");

        for (HoneyOrder order : orders) {
            System.out.println("Type of honey: " + order.getType());
            System.out.println("Amount (lb): " + order.getPounds());
            System.out.println("Price: $" + String.format("%.2f", order.getTotalPrice()));
            System.out.println("No. 6lb bottles: " + order.getNum6lbBottles());
            System.out.println("No. 3lb bottles: " + order.getNum3lbBottles());
            System.out.println("No. 1lb bottles: " + order.getNum1lbBottles() + "\n");
        }

        int totalOrangeBlossom = 0;
        int totalWildflower = 0;
        int totalClover = 0;

        for (HoneyOrder order : orders) {
            switch (order.getType()) {
                case "Orange Blossom":
                    totalOrangeBlossom += order.getPounds();
                    break;
                case "Wildflower":
                    totalWildflower += order.getPounds();
                    break;
                case "Clover":
                    totalClover += order.getPounds();
                    break;
            }
        }

        System.out.println("The total amount of orange blossom honey sold is " + totalOrangeBlossom + " lb.");
        System.out.println("The total amount of wildflower honey sold is " + totalWildflower + " lb.");
        System.out.println("The total amount of clover honey sold is " + totalClover + " lb.");
    }
}
