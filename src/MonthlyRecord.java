public class MonthlyRecord {
   String itemName;
   boolean isExpense;
   int quantity,unitPrice;

    public MonthlyRecord(String itemName, boolean isExpense, int quantity, int unitPrice) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
