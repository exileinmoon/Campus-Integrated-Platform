package stu.tradeservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import stu.tradeservice.entity.Favorites;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavoritesMapper extends BaseMapper<Favorites> {

    // 增加收藏
    @Insert("INSERT INTO favorites(user_id, product_id, created_at) " +
            "VALUES(#{user_id}, #{product_id}, #{created_at})")
    int insertFavorite(Favorites favorite);

    // 查询所有收藏
    @Select("SELECT * FROM favorites WHERE user_id = #{userId}")
    List<Favorites> selectFavoritesByUserId( Long userId);
    @Select("SELECT * FROM favorites")
    List<Favorites> selectAllFavorites();

    // 根据 ID 查询收藏
    @Select("SELECT * FROM favorites WHERE id = #{id}")
    Favorites selectFavoriteById(Long id);

    // 更新收藏
    @Update("UPDATE favorites SET user_id = #{userId}, product_id = #{productId}, created_at = #{createdAt} WHERE id = #{id}")
    int updateFavorite(Favorites favorite);

    // 根据 ID 删除收藏
    @Delete("DELETE FROM favorites WHERE product_id = #{productId} AND user_id = #{userId}")
    void deleteFavorite(long productId, long userId);
}