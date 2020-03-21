package km.hw54.subscribe.service;

import km.hw54.subscribe.dto.EventDTO;
import km.hw54.subscribe.repository.EventRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Slice<EventDTO> findAllEvents(Pageable pageable) {
        var slice = eventRepository.findAll(pageable);
        return slice.map(EventDTO::from);
    }
}
