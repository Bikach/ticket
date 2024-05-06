package unit;

import com.bikach.ticket.application.domain.EventRepository;
import com.bikach.ticket.application.domain.model.Event;
import com.bikach.ticket.application.domain.model.Place;
import com.bikach.ticket.application.usecase.EventPlaceRegister;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventPlaceRegisterTest {

    private final EventRepository eventRepository = mock(EventRepository.class);


    @Test
    public void should_notify_all_box_offices_with_sold_out_when_places_have_been_booked() {
        // Arrange
        var event = buildStandardEventPlaceRegister();
        var booker = new EventPlaceRegister(eventRepository);
        // Act
        booker.handler(event);

        // Assert
        verify(eventRepository).bookPlaces(event);
    }

    private Event buildStandardEventPlaceRegister() {
        var BookedPlaces = List.of(new Place("A3", 12));
        return new Event("UFC 301", BookedPlaces);
    }
}
