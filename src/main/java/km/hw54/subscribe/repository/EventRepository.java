package km.hw54.subscribe.repository;

import km.hw54.subscribe.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, String> {
}
