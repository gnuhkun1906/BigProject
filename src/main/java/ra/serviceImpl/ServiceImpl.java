package ra.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Music;
import ra.repository.IMusicRepository;
import ra.service.IMusicService;

import java.util.Optional;

@Service
public class ServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Iterable<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Optional<Music> findById(Long id) {
        return musicRepository.findById(id);
    }

    @Override
    public Optional<Music> save(Music music) {
        return Optional.of(musicRepository.save(music));
    }

    @Override
    public void deleteById(Long id) {
        musicRepository.deleteById(id);
    }
}
