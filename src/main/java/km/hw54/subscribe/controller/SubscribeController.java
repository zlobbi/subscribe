package km.hw54.subscribe.controller;

import km.hw54.subscribe.annotations.ApiPageable;
import km.hw54.subscribe.dto.EventDTO;
import km.hw54.subscribe.dto.SubscribeDTO;
import km.hw54.subscribe.service.SubscribeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/subscribes")
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @ApiPageable
    @GetMapping
    public Slice<SubscribeDTO> getAllSubscribes(@ApiIgnore Pageable pageable) {
        return subscribeService.findAllSubscribes(pageable);
    }

    @ApiPageable
    @GetMapping("/{userEmail}")
    public List<EventDTO> getUserSubscribes(@PathVariable("userEmail") String userEmail, @ApiIgnore Pageable pageable) {
        return subscribeService.findAllUserEvents(userEmail, pageable);
    }

    @DeleteMapping("/{subscribeId}/{userEmail}")
    public String deleteSubscribe(@PathVariable("subscribeId") String subscribeId, @PathVariable("userEmail") String userEmail) {
        return subscribeService.deleteSubscribe(subscribeId, userEmail);
    }
}
