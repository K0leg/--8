package company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        // Додавання заходів
        schedule.addEvent(new Event("Лекція з Java", "15.12.2024 10:00", "Кімната 101"));
        schedule.addEvent(new Event("Спортивний матч", "16.12.2024 18:30", "Стадіон"));
        schedule.addEvent(new Event("День відкритих дверей", "14.12.2024 14:00", "Актова зала"));

        // Виведення усіх заходів
        BoxPrinter.print("Усі заходи:");
        schedule.printAllEvents();

        BoxPrinter.print("////////////////////////");

        // Пошук заходів за датою
        System.out.print("Введіть дату (dd-MM-yyyy), щоб знайти заходи: ");
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();

        try {
            // Парсинг дати у форматі dd-MM-yyyy
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputDate, formatter);

            List<Event> eventsOnDate = schedule.getEventsByDate(date);

            BoxPrinter.print("Заходи на " + date.format(formatter) + ":");
            for (Event event : eventsOnDate) {
                System.out.println(event);
            }
        } catch (Exception e) {
            BoxPrinter.print("Помилка: Неправильний формат дати. Введіть у форматі dd-MM-yyyy.");
        }

        BoxPrinter.print("////////////////////////");

        // Видалення минулих заходів
        BoxPrinter.print("Видалення старих заходів...");
        schedule.removePastEvents();

        BoxPrinter.print("Оновлений список заходів:");
        schedule.printAllEvents();
    }
}