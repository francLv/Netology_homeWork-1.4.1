import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int earning = 0; // доход
        int spending = 0; // расход
        
        while (true) {
            printHeader();
            String input = scanner.nextLine();
            if("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода: ");
                        String moneyStr = scanner.nextLine();
                        System.out.println(" ");
                        int money = Integer.parseInt(moneyStr);
                        earning += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода: ");
                        String expensesStr = scanner.nextLine();
                        System.out.println(" ");
                        int expenses = Integer.parseInt(expensesStr);
                        spending += expenses;
                        break;
                    case 3:
                        int earningTax = taxEarning(earning);
                        int spendingTax = taxEarningMinusSpending(earning, spending);
                        if (earningTax > spendingTax) {
                            printResultEarningSpending(spendingTax,earningTax);
                        } else {
                            printResultEarning(earningTax, spendingTax);
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");
                        System.out.println(" ");
                }
            }
        }
        System.out.println("Прграмма завершена!");
    }

    public static void printHeader() {
        System.out.println("Выберите операцию и введите ее номер: ");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
    }

    public static int taxEarning(int earning) {
        return earning * 6 / 100;
    }

    public static int taxEarningMinusSpending(int earning, int spending) {
        int tax = (earning - spending) * 15 / 100;
        return Math.max(tax, 0);
    }

    public static void printResultEarningSpending (int earningTax, int spendingTax) {
        System.out.println("Мы советуем Вам УСН доходы минус расходы");
        System.out.println("Ваш налог составит: " + spendingTax + " рублей");
        System.out.println("Налог на другой системе: " + earningTax + " рублей");
        System.out.println("Экономия: " + Math.abs(spendingTax - earningTax) + " рублей");
        System.out.println(" ");
    }

    public static void printResultEarning (int earningTax, int spendingTax) {
        System.out.println("Мы советуем Вам УСН доходы");
        System.out.println("Ваш налог составит: " + earningTax + " рублей");
        System.out.println("Налог на другой системе: " + spendingTax + " рублей");
        System.out.println("Экономия: " + Math.abs(spendingTax - earningTax) + " рублей");
        System.out.println(" ");
    }
}
