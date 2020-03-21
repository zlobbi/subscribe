package km.hw54.subscribe.dto;

import km.hw54.subscribe.model.Event;
import km.hw54.subscribe.model.Subscribe;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscribeDTO {

    public static SubscribeDTO from(Subscribe s) {
        return builder()
                .id(s.getId())
                .event(s.getEvent())
                .email(s.getEmail())
                .date(s.getDate())
                .build();
    }

    private String id;
    private Event event;
    private String email;
    private LocalDate date;
}
