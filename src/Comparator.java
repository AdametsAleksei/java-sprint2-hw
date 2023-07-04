public class Comparator {
    public void compare(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        for (Integer month : monthlyReport.monthlyReport.keySet()){
            if (monthlyReport.getSumIncome(month) == yearlyReport.getSumIncome(month)){
                System.out.println("В месяце - " + month + " нет расхождений по прибыли.");
            }else {
                System.out.println("В месяце - " + month + " расхождение, в доходах, на сумму - "
                        + (yearlyReport.getSumIncome(month) - monthlyReport.getSumIncome(month)));
            }if (monthlyReport.getSumExpenses(month) == yearlyReport.getSumExpenses(month)){
                System.out.println("В месяце - " + month + " нет расхождений по расходам.");
            }else {
                System.out.println("В месяце - " + month + " расхождение, в расходах, на сумму - "
                        + (yearlyReport.getSumExpenses(month) - monthlyReport.getSumExpenses(month)));
            }
        }
        System.out.println("Сравнение завершено, всё сходится, поздравляю!");
    }
}
