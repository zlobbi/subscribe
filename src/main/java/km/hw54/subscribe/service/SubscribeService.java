package km.hw54.subscribe.service;

import km.hw54.subscribe.model.Event;
import km.hw54.subscribe.model.Subscribe;
import km.hw54.subscribe.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public String addSubscribe(Event event, String userEmail, LocalDate date) {
        String msg = "";
        Subscribe s = subscribeRepository.findByEmailAndEventId(userEmail, event.getId());
        if(s != null) {
            msg = "You have already subscribed to: " + s.getEvent().getName() + " Subscribe ID: " + s.getId();
        } else {
            s = Subscribe.make(event, userEmail, date);
            msg = "You are subscribed to: " + s.getEvent().getName() + " Subscribe ID: " + s.getId();
        }
        subscribeRepository.save(s);
        return msg;
    }
}
