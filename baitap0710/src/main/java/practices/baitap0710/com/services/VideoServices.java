package practices.baitap0710.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practices.baitap0710.com.entity.Video;
import practices.baitap0710.com.repository.VideoRepository;

import java.util.List;

@Service
public class VideoServices {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video updateVideo(long id,Video videoDetail) {
        Video video = videoRepository.findById(id).orElseThrow(()->new RuntimeException("Not found video"));

        video.setTitle(videoDetail.getTitle());
        video.setDescription(videoDetail.getDescription());
        video.setCategory(videoDetail.getCategory());
        return videoRepository.save(video);
    }

    public void deleteVideo(long id) {
        videoRepository.deleteById(id);
    }

}
