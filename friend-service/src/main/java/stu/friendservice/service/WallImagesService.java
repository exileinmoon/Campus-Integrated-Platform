package stu.friendservice.service;

import stu.friendservice.entity.WallImages;
import java.util.List;

public interface WallImagesService {

    WallImages getImageById(Integer id);

    List<WallImages> getAllImages();

    boolean createImage(WallImages wallImages);

    boolean updateImage(WallImages wallImages);

    boolean deleteImage(Integer id);
}
