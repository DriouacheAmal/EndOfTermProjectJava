package PersonalFinanceTracker;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PersonalFinancialTracker {
    private static final String INPUT_PROMPT = "transaction.txt";
    private static final String OUTPUT_PROMPT = "financialReport.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the transaction file: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter the path for the financial report file: ");
        String outputFilePath = scanner.nextLine();

        try {
            Process processor = new Process();
            processTransactions(inputFilePath, processor);
            FinancialReport financialReport = new FinancialReport();
            financialReport.generateReport(outputFilePath, processor.getIncomes(), processor.getExpenses());
            System.out.println("Report generated successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        scanner.close();
    }

    private static void processTransactions(String INPUT_PROMPT, Process processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PROMPT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.err.println("Exit invalid transaction: " + line);
                    continue;
                }

                String date = parts[0];
                String type = parts[1];
                String category = parts[2];
                double amount = Double.parseDouble(parts[3]);

                Transactions transaction = new Transactions();
                processor.processTransactions(transaction);

                System.out.println("Date: " + date);
                System.out.println("Type: " + type);
                System.out.println("Category: " + category);
                System.out.println("Amount: " + amount);
                System.out.println();

            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
