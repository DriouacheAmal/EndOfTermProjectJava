package PersonalFinanceTracker;

public class Transactions {
    private String date;
    private String type;
    private String category;
    private double amount;

    public void transaction(String date, String type, String category, int amount){
        this.date = date;
        this.type = type;
        this.category = category;
        this.amount = amount;

    }
    public String getDate() {

        return date;
    }

    public String getType() {

        return type;
    }

    public String getCategory() {

        return category;
    }

    public double getAmount() {

        return amount;
    }


}



