import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Comparator comparator = new Comparator();

         while (true){
            printMenu();
            int command = scanner.nextInt();

            if (command == 1){
                System.out.println("Введите количество месяцев, за которые нужно считать отчёты");
                command = scanner.nextInt();
                for (int i = 1; i < command + 1; i++) {
                    monthlyReport.createMonthlyReport("m.20210" + i + ".csv", i);
                }
                System.out.println("Месячные отчеты считаны.");

            }else if (command == 2){
                //мне кажется предотвратить возможность дублирования годового отчёта логичнее здесь
                if (yearlyReport.isExist()) {
                    System.out.println("Годовой отчёт уже считан");
                }else {
                    yearlyReport.createYearlyReport("y.2021.csv");
                    System.out.println("Годовой отчет считан.");
                }

            }else if (command == 3){
                if(monthlyReport.isExist()){
                    if(yearlyReport.isExist()){
                        comparator.compare(monthlyReport,yearlyReport);
                    }else{
                        System.out.println("Годовой отчёт не считан");
                    }
                }else{
                    System.out.println("Месячные отчёты не считаны.");
                }

            }else if (command == 4){
                if(monthlyReport.isExist()){
                    System.out.println("Информация о месячных отчетах:");
                    monthlyReport.getReport();
                }else {
                    System.out.println("Месячные отчёты не считаны.");
                }

            }else if (command == 5){
                if(yearlyReport.isExist()){
                    System.out.println("Информация о годовом отчете:");
                    yearlyReport.getReport();
                }else {
                    System.out.println("Годовой отчёт не считан.");
                }

            }else if (command == 0){
                System.out.println("Хорошего дня! :)");
                break;
            }else{
                System.out.println("Нет такой команды");
            }
        }
    }

    private static void printMenu(){
        System.out.println("Выберите что вы хотите сделать");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти");
    }
}

