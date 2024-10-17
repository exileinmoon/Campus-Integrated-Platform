package stu.friendservice.mapper;

import org.apache.ibatis.annotations.*;
import stu.friendservice.entity.LoveCards;
import java.util.List;

@Mapper
public interface LoveCardsMapper {

    @Select("SELECT * FROM love_cards WHERE id = #{id}")
    LoveCards selectById(@Param("id") Integer id);

    @Select("SELECT * FROM love_cards")
    List<LoveCards> selectAll();

    @Insert("INSERT INTO love_cards (user_id, photo_url, declaration, created_at) " +
            "VALUES (#{user_id}, #{photo_url}, #{declaration}, #{created_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(LoveCards loveCards);

    @Update("UPDATE love_cards SET photo_url = #{photo_url}, declaration = #{declaration} WHERE id = #{id}")
    int updateById(LoveCards loveCards);

    @Delete("DELETE FROM love_cards WHERE id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM love_cards ORDER BY created_at DESC LIMIT #{offset}, #{size}")
    List<LoveCards> selectLoveCards(@Param("offset") int offset, @Param("size") int size);
}
