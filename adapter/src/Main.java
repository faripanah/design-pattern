//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter date = new CalendarToNewDateAdapter(2025, 9, 25);
        System.out.println("Initial date: " + date);


        date.advanceDays(10);
        System.out.println("After +10 days: " + date);

        date.setYear(2000);
        date.setMonth(1);
        date.setDay(1);
        System.out.println("Changed to: " + date);


        date.advanceDays(-1);
        System.out.println("After -1 day: " + date);
        }
    }
