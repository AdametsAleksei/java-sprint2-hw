import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearlyRecord> yearlyReport = new ArrayList<>();
    private boolean isExist = false;

    public void getReport() {
        System.out.println("Отчёт за 2021 год:");
        int sumIncome = 0;
        int sumExpense = 0;
        int sumMonth = 0;
        for (YearlyRecord yearlyRecord : yearlyReport){
            if (sumMonth < yearlyRecord.month){
                sumMonth++;
            }
            if (!yearlyRecord.isExpense) {
                System.out.println("Прибыль за месяц " + sumMonth + " составила - " + yearlyRecord.amount);
                sumIncome += yearlyRecord.amount;
            }else if (yearlyRecord.isExpense) {
                System.out.println("Расход за месяц " + sumMonth + " составила - " + yearlyRecord.amount);
                sumExpense += yearlyRecord.amount;
            }
        }
        System.out.println("Средний расход за все месяцы, составил - " + (sumExpense/sumMonth));
        System.out.println("Средний доход за все месяцы, составил - " + (sumIncome/sumMonth));
    }

    public int getSumIncome(Integer month){
        int incomeSum = 0;
        for (YearlyRecord yearlyRecord : yearlyReport){
            if (yearlyRecord.month == month && !yearlyRecord.isExpense){
                incomeSum += yearlyRecord.amount;
            }
        } return incomeSum;
    }

    public int getSumExpenses(Integer month){
        int expensesSum = 0;
        for (YearlyRecord yearlyRecord : yearlyReport){
            if (yearlyRecord.month == month && yearlyRecord.isExpense){
                expensesSum += yearlyRecord.amount;
            }
        } return expensesSum;
    }
    public boolean isExist(){
        if (isExist){
            return true;
        }
        return false;
    }

    public void createYearlyReport(String pathName){
        FileReader fr = new FileReader();
        ArrayList<String> dataFromFile = fr.readFileContents(pathName);
        for (int i = 1; i < dataFromFile.size(); i++) {
            String[] lineContents = dataFromFile.get(i).split(","); // month,amount,is_expense
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);
            YearlyRecord yearlyRecord = new YearlyRecord(month, amount, isExpense);
            yearlyReport.add(yearlyRecord);
        }
        isExist = true;
    }

}
