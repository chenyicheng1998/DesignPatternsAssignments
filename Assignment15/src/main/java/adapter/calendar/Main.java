package adapter.calendar;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2026);
        date.setMonth(4);
        date.setDay(1);

        System.out.println("Initial date: " + formatDate(date));

        date.advanceDays(10);
        System.out.println("After advancing 10 days: " + formatDate(date));

        date.advanceDays(30);
        System.out.println("After advancing 30 more days: " + formatDate(date));

        date.advanceDays(365);
        System.out.println("After advancing 365 more days: " + formatDate(date));
    }

    private static String formatDate(NewDateInterface date) {
        return String.format("%04d-%02d-%02d", date.getYear(), date.getMonth(), date.getDay());
    }
}

