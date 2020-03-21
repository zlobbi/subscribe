package km.hw54.subscribe.model;

import km.hw54.subscribe.util.Generator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Data
@Document
public class Event {
    private static Random r = new Random();
        @Id
        private String id = UUID.randomUUID().toString();
        private LocalDate date;
        @Indexed
        private String name;
        private String description;

        public static Event make() {
            int t = r.nextInt(2);
            LocalDate n = LocalDate.now();
            n = (t == 1) ? n.plusDays(r.nextInt(5)) : n.minusDays(r.nextInt(5));
            Event e = new Event();
            e.setDate(n);
            e.setName(Generator.makeName());
            e.setDescription(Generator.makeDescription());
            return e;
        }
}
