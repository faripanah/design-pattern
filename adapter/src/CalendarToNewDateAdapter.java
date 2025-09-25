import java.util.Calendar;  //Adaptee
public class CalendarToNewDateAdapter implements NewDateInterface {
    private final Calendar cal;  //object adapter

    public CalendarToNewDateAdapter() {
        this.cal = Calendar.getInstance();
    }

    public CalendarToNewDateAdapter(int year, int month, int day) {
        this();
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    @Override
    public void setDay(int day) {
        cal.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }


        cal.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        cal.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {

        return cal.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return cal.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        cal.add(Calendar.DAY_OF_MONTH, days);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", getYear(), getMonth(), getDay());
    }


    public Calendar getCalendarCopy() {
        return (Calendar) cal.clone();
    }

}
