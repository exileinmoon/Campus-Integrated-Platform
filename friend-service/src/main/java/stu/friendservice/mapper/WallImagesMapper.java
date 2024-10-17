package stu.friendservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.friendservice.entity.WallImages;
import java.util.List;

@Mapper
public interface WallImagesMapper {

    @Select("SELECT * FROM wall_images WHERE id = #{id}")
    WallImages selectById(@Param("id") Integer id);

    @Select("SELECT * FROM wall_images")
    List<WallImages> selectAll();

    @Insert("INSERT INTO wall_images (image_url, link_url, created_at) " +
            "VALUES (#{image_url}, #{link_url}, #{created_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(WallImages wallImages);

    @Update("UPDATE wall_images SET image_url = #{image_url}, link_url = #{link_url}, " +
            "created_at = #{created_at} WHERE id = #{id}")
    int updateById(WallImages wallImages);

    @Delete("DELETE FROM wall_images WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);
}
