package PersonalFinanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FinancialReport {

    public void generateReport(String OUTPUT_PROMPT, Map<String, Double> incomes, Map<String, Double> expenses) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PROMPT))) {
            writer.println("Financial Report");
            writer.println("---------------");
            writer.println("Total Income: " + getTotal(incomes));
            writer.println("Total Expenses: " + getTotal(expenses));
            writer.println("Net Savings: " + (getTotal(incomes) - getTotal(expenses)));
            writer.println("Expense Breakdown:");
            for (Map.Entry<String, Double> entry : expenses.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }

        }

    }
    private double getTotal(Map<String, Double> map) {
        double total = 0;
        for (double value : map.values()) {
            total += value;
        }
        return total;
    }
}
