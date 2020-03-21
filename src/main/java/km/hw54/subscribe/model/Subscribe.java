package km.hw54.subscribe.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document(collection = "subscribes")
public class Subscribe {
    @Id
    private String id = UUID.randomUUID().toString();
    private Event event;
    @Indexed
    private String email;
    private LocalDate date;

    public static Subscribe make(Event event, String email, LocalDate date) {
        Subscribe s = new Subscribe();
        s.setEvent(event);
        s.setEmail(email);
        s.setDate(date);
        return s;
    }
}
