package unit;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.Event;
import com.bikach.ticket.application.domain.model.Seat;
import com.bikach.ticket.application.usecase.ShowAvailableSeats;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowAvailableSeatsTest {

    private final EventRepository eventRepository = mock(EventRepository.class);

    @Test
    public void should_not_show_seats_when_the_event_is_sold_out() {
        // Arrange
        var eventId = "event uuid";
        var sut = new ShowAvailableSeats(eventRepository);
        when(eventRepository.findAvailableSeatsByEventId(eventId)).thenReturn(new Event(List.of()));

        // Act
        var seats = sut.availableSeats(eventId);

        // Assert
        assertThat(seats).isEqualTo(List.of());
    }

    @Test
    public void should_to_have_one_seat_when_only_one_seat_is_available() {
        // Arrange
        var eventId = "event uuid";
        var event = new Event(List.of(new Seat("ref seat")));
        var sut = new ShowAvailableSeats(eventRepository);
        when(eventRepository.findAvailableSeatsByEventId(eventId)).thenReturn(event);

        // Act
        var seats = sut.availableSeats(eventId);

        // Assert
        assertThat(seats).isEqualTo(List.of(new Seat("ref seat")));
    }


    @Test
    public void should_to_have_any_seat_number_when_several_seats_are_available() {
        // Arrange
        var eventId = "event uuid";
        var event = new Event(List.of(
                new Seat("ref A1"),
                new Seat("ref A2"),
                new Seat("ref B6"))
        );
        var sut = new ShowAvailableSeats(eventRepository);
        when(eventRepository.findAvailableSeatsByEventId(eventId)).thenReturn(event);

        // Act
        var seats = sut.availableSeats(eventId);

        // Assert
        assertThat(seats).isEqualTo(
                List.of(new Seat("ref A1"), new Seat("ref A2"), new Seat("ref B6"))
        );
    }

}
