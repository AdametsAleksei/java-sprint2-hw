import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthlyRecord>> monthlyReport = new HashMap<>();
    private boolean isExist;


    public int getSumIncome(Integer month){
        int incomeSum = 0;
        for (MonthlyRecord monthlyRecord : monthlyReport.get(month)){
            if (!monthlyRecord.isExpense){
                incomeSum += (monthlyRecord.quantity*monthlyRecord.unitPrice);
            }
        } return incomeSum;
    }

    public int getSumExpenses(Integer month){
        int expenseSum = 0;
        for (MonthlyRecord monthlyRecord : monthlyReport.get(month)){
            if (monthlyRecord.isExpense){
                expenseSum += (monthlyRecord.quantity*monthlyRecord.unitPrice);
            }
        } return expenseSum;
    }

    public void getReport() {
        for (Integer month : monthlyReport.keySet()){
            System.out.println("В месяце - " + month);
            getMaxMonthIncome(month);
            getMaxMonthExpense(month);
        }
    }

    private void getMaxMonthIncome(Integer month){
        String itemName = "";
        int sum = 0;
        ArrayList<MonthlyRecord> monthlyRecords = monthlyReport.get(month);
        for (MonthlyRecord monthlyRecord : monthlyRecords){
            if (!monthlyRecord.isExpense) {
                String currentName = monthlyRecord.itemName;
                int currentSum = monthlyRecord.quantity * monthlyRecord.unitPrice;
                if (itemName.equals("")) {
                    itemName = currentName;
                    sum = currentSum;
                } else if (sum < currentSum) {
                    itemName = currentName;
                    sum = currentSum;
                }
            }
        }
        System.out.println("Самый прибыльный товар - " + itemName);
        System.out.println("Доход с этого товара составил -  - " + sum);
    }

    private void getMaxMonthExpense(Integer month){
        String itemName = "";
        int sum = 0;
        ArrayList<MonthlyRecord> monthlyRecords = monthlyReport.get(month);
        for (MonthlyRecord monthlyRecord : monthlyRecords){
            if (monthlyRecord.isExpense) {
                String currentName = monthlyRecord.itemName;
                int currentSum = monthlyRecord.quantity * monthlyRecord.unitPrice;
                if (itemName.equals("")) {
                    itemName = currentName;
                    sum = currentSum;
                } else if (sum < currentSum) {
                    itemName = currentName;
                    sum = currentSum;
                }
            }
        }
        System.out.println("Самая большая категория расходов - " + itemName);
        System.out.println("Сумма расходов по этой категории - " + sum);
    }

    public boolean isExist(){
        return isExist;
    }

    public void createReport(){
        isExist = true;
    }

    public void createMonthlyReport(String fileName, Integer month){
        FileReader fr = new FileReader();
        ArrayList<String> dataFromFile =  fr.readFileContents(fileName);
        if(!dataFromFile.isEmpty()) {
            ArrayList<MonthlyRecord> listMonthlyRecord = new ArrayList<>();
            for (int i = 1; i < dataFromFile.size(); i++) {
                String[] lineContents = dataFromFile.get(i).split(","); //item_name,is_expense,quantity,unit_price
                String name = lineContents[0];
                boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                int quantity = Integer.parseInt(lineContents[2]);
                int unitPrice = Integer.parseInt(lineContents[3]);
                MonthlyRecord monthlyRecord = new MonthlyRecord(name, isExpense, quantity, unitPrice);
                listMonthlyRecord.add(monthlyRecord);
            }
            monthlyReport.put(month, listMonthlyRecord);
            createReport();
        }
    }

}
