package km.hw54.subscribe.service;

import km.hw54.subscribe.dto.EventDTO;
import km.hw54.subscribe.model.Event;
import km.hw54.subscribe.repository.EventRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final SubscribeService subscribeService;

    public EventService(EventRepository eventRepository, SubscribeService subscribeService) {
        this.eventRepository = eventRepository;
        this.subscribeService = subscribeService;
    }

    public Slice<EventDTO> findAllEvents(Pageable pageable) {
        var slice = eventRepository.findAll(pageable);
        return slice.map(EventDTO::from);
    }

    public boolean isSubscribeable(String eventId) {
        var event = eventRepository.findById(eventId).get();
        boolean e = event.getDate().isAfter(LocalDate.now());
        return e;
    }

    public String subscribeToEvent(String eventId, String userEmail) {
        String msg = "";
        if(isSubscribeable(eventId)) {
            Event event = eventRepository.findById(eventId).get();
            msg = subscribeService.addSubscribe(event, userEmail, LocalDate.now());
        } else {
            msg = "you are late event passed";
        }
        return msg;
    }
}
