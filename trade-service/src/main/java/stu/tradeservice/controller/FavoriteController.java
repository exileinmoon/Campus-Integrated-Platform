package stu.tradeservice.controller;

import stu.tradeservice.DTO.FavoriteDTO;
import stu.tradeservice.entity.Favorites;
import stu.tradeservice.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trade/products/favorites")
public class FavoriteController {

    @Autowired
    private FavoritesService favoriteService;

    // 获取所有收藏商品
    @GetMapping("/{id}")
    public ResponseEntity<List<FavoriteDTO>> getFavorites(@PathVariable Long id) {
        List<FavoriteDTO> favorites = favoriteService.getAllFavorites(id);
        return ResponseEntity.ok(favorites);
    }

    // 添加收藏商品
    @GetMapping("favorite/{productId}/{userId}")
    public ResponseEntity<Favorites> addFavorite(@PathVariable Long productId, @PathVariable Long userId) {
        Favorites favorite = favoriteService.addFavorite(productId, userId);
        return ResponseEntity.ok(favorite);
    }

    // 更新收藏商品


    // 删除收藏商品
    @DeleteMapping("unfavorite/{productId}/{userId}")
    public void deleteFavorite(@PathVariable Long productId, @PathVariable Long userId) {
         favoriteService.deleteFavorite(productId, userId);
    }

}