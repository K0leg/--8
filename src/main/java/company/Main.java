import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        Scanner scanner = new Scanner(System.in);

        // Додавання заходів
        schedule.addEvent(new Event("Лекція з Java", LocalDateTime.of(2024, 12, 15, 10, 0), "Кімната 101"));
        schedule.addEvent(new Event("Спортивний матч", LocalDateTime.of(2024, 12, 16, 18, 30), "Стадіон"));
        schedule.addEvent(new Event("День відкритих дверей", LocalDateTime.of(2024, 12, 14, 14, 0), "Актова зала"));

        System.out.println("Усі заходи:");
        schedule.printAllEvents();

        // Пошук заходів за датою
        System.out.print("Введіть дату (yyyy-MM-dd), щоб знайти заходи: ");
        String inputDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Event> eventsOnDate = schedule.getEventsByDate(date);

        System.out.println("Заходи на " + date + ":");
        for (Event event : eventsOnDate) {
            System.out.println(event);
        }

        // Видалення минулих заходів
        System.out.println("Видалення старих заходів...");
        schedule.removePastEvents();

        System.out.println("Оновлений список заходів:");
        schedule.printAllEvents();
    }
}