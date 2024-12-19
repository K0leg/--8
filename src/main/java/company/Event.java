package company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private LocalDateTime dateTime;
    private String location;

    // Конструктор
    public Event(String name, String dateTimeString, String location) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.name = name;
        this.dateTime = LocalDateTime.parse(dateTimeString, formatter);
        this.location = location;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return "Захід: " + name + ", Дата: " + dateTime.format(formatter) + ", Місце: " + location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}