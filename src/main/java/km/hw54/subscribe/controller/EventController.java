package km.hw54.subscribe.controller;

import km.hw54.subscribe.annotations.ApiPageable;
import km.hw54.subscribe.dto.EventDTO;
import km.hw54.subscribe.service.EventService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiPageable
    @GetMapping
    public Slice<EventDTO> getAllEvents(@ApiIgnore Pageable pageable) {
       return eventService.findAllEvents(pageable);
    }

    @PutMapping("/{eventId}/{userEmail}")
    public String subscribeToEvent(@PathVariable("eventId") String eventId,
                                   @PathVariable("userEmail") String userEmail) {
        return eventService.subscribeToEvent(eventId, userEmail);
    }
}
