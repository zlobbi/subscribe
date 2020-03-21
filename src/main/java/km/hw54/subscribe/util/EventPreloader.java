package km.hw54.subscribe.util;

import km.hw54.subscribe.model.Event;
import km.hw54.subscribe.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class EventPreloader {

    @Bean
    CommandLineRunner generateGiberrish(EventRepository eventRepository) {
        return args -> {
            eventRepository.deleteAll();
            var events = Stream.generate(Event::make).limit(20).collect(toList());
            eventRepository.saveAll(events);
            eventRepository.findAll().forEach(e -> System.out.println(e));
        };
    }
}
