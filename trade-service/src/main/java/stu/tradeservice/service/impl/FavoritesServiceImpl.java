package stu.tradeservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import stu.tradeservice.DTO.FavoriteDTO;
import stu.tradeservice.entity.Favorites;
import stu.tradeservice.entity.Products;
import stu.tradeservice.mapper.FavoritesMapper;
import stu.tradeservice.service.FavoritesService;
import stu.tradeservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Override
    public List<FavoriteDTO> getAllFavorites(long id) {
        List<FavoriteDTO> favoriteDTOList = new ArrayList<>();

        // 假设 favorites 是从某个地方获取的收藏列表
        for (Favorites favorite : favoritesMapper.selectFavoritesByUserId(id)) {
            FavoriteDTO favoriteDTO = new FavoriteDTO();
            Products product = productsService.getProductById(Long.valueOf(favorite.getProduct_id()));

            // 设置收藏的基本信息
            favoriteDTO.setId(Long.valueOf(product.getId()));
            favoriteDTO.setProductName(product.getName());
            favoriteDTO.setPrice(product.getPrice());
            favoriteDTO.setImage((product.getImages().split(","))[0]);
            favoriteDTO.setProductId(String.valueOf(product.getId()));

            // 将转换后的 DTO 添加到列表中
            favoriteDTOList.add(favoriteDTO);
        }

        return favoriteDTOList;
    }


    @Override
    public int insertFavorite(Favorites favorite) {
        return favoritesMapper.insertFavorite(favorite);
    }

    @Override
    public List<Favorites> selectAllFavorites() {
        return favoritesMapper.selectAllFavorites();
    }

    @Override
    public Favorites selectFavoriteById(Long id) {
        return favoritesMapper.selectFavoriteById(id);
    }

    @Override
    public int updateFavorite(Favorites favorite) {
        return favoritesMapper.updateFavorite(favorite);
    }



    @Override
    public IPage<Products> getProducts(int page, int size) {
        return null;
    }

    @Override
    public Favorites addFavorite(Long productId, Long userId) {
        Favorites favorite = new Favorites();
        favorite.setProduct_id(Math.toIntExact(productId));
        favorite.setUser_id(Math.toIntExact(userId));
        favorite.setCreated_at(new Date());
        favoritesMapper.insertFavorite(favorite);
        return favorite;
    }

    @Override
    public void deleteFavorite(Long productId, Long userId) {
        favoritesMapper.deleteFavorite(productId, userId);
    }
}