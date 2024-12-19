package company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEventsByDate(LocalDate date) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getDateTime().toLocalDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    public void removePastEvents() {
        events.removeIf(event -> event.getDateTime().isBefore(LocalDateTime.now()));
    }

    public void printAllEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}