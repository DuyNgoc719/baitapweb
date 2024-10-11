package practices.baitap0710.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practices.baitap0710.com.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
