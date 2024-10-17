package stu.tradeservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import stu.tradeservice.DTO.FavoriteDTO;
import stu.tradeservice.entity.Favorites;
import stu.tradeservice.entity.Products;

import java.util.List;

public interface FavoritesService {
    List<FavoriteDTO> getAllFavorites(long id);

    int insertFavorite(Favorites favorite);
    List<Favorites> selectAllFavorites();
    Favorites selectFavoriteById(Long id);
    int updateFavorite(Favorites favorite);
    int deleteFavorite(Long id);
    IPage<Products> getProducts(int page, int size);
}