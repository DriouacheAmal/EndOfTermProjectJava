package PersonalFinanceTracker;

import java.util.HashMap;
import java.util.Map;

public class Process {

    // We have to store transaction data linked to incomes and expenses
    // by using HashMap
    //This map will store the incomes categorized by their categories (represented as strings)
    // with their corresponding amounts (represented as doubles).
    private final Map<String, Double> incomes;
    private final Map<String, Double> expenses;


//Constructor
    public Process() {
        incomes = new HashMap<>();
        expenses = new HashMap<>();
    }
// Methods
    public void processTransactions(Transactions transactions) {
        if (transactions.getType().equalsIgnoreCase("incomes")) {
            incomes.put(transactions.getCategory(), incomes.getOrDefault(transactions.getCategory(), 35000.0) + transactions.getAmount());
        } else if (transactions.getType().equalsIgnoreCase("expense")) {
            expenses.put(transactions.getCategory(), expenses.getOrDefault(transactions.getCategory(), 3000.0) + transactions.getAmount());
        }
    }
    public Map<String, Double> getIncomes() {
        return incomes;
    }

    public Map<String, Double> getExpenses() {
        return expenses;
    }

}
/*class is responsible for processing transactions, categorizing them into incomes and expenses, and providing methods
to retrieve these categorized data outside the class.
 */



