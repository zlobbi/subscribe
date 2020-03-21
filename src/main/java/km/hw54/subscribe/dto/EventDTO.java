package km.hw54.subscribe.dto;

import km.hw54.subscribe.model.Event;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDTO {

    public static EventDTO from(Event e) {
        return builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .date(e.getDate())
                .build();
    }

    private String id;
    private String name;
    private String description;
    private LocalDate date;
}
