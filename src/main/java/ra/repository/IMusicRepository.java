package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.Music;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Long> {
}
