package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.friendservice.entity.WallImages;
import stu.friendservice.mapper.WallImagesMapper;
import stu.friendservice.service.WallImagesService;
import java.util.List;

@Service
public class WallImagesServiceImpl implements WallImagesService {

    @Autowired
    private WallImagesMapper wallImagesMapper;

    @Override
    public WallImages getImageById(Integer id) {
        return wallImagesMapper.selectById(id);
    }

    @Override
    public List<WallImages> getAllImages() {
        return wallImagesMapper.selectAll();
    }

    @Override
    public boolean createImage(WallImages wallImages) {
        return wallImagesMapper.insert(wallImages) > 0;
    }

    @Override
    public boolean updateImage(WallImages wallImages) {
        return wallImagesMapper.updateById(wallImages) > 0;
    }

    @Override
    public boolean deleteImage(Integer id) {
        return wallImagesMapper.deleteById(id) > 0;
    }
}
