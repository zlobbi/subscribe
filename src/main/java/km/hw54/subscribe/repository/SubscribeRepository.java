package km.hw54.subscribe.repository;

import km.hw54.subscribe.model.Subscribe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscribeRepository extends PagingAndSortingRepository<Subscribe, String> {
    Subscribe findByEmailAndEventId(String email, String eventId);

    Slice<Subscribe> findAllByEmail(String userEmail, Pageable pageable);

    boolean existsByIdAndEmail(String id, String email);

    void deleteByIdAndEmail(String id, String email);
}
