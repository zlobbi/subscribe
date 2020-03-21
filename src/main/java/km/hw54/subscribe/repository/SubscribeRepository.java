package km.hw54.subscribe.repository;

import km.hw54.subscribe.model.Subscribe;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscribeRepository extends PagingAndSortingRepository<Subscribe, String> {
    Subscribe findByEmailAndEventId(String email, String eventId);
}
