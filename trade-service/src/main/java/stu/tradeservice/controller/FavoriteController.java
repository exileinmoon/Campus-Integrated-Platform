package stu.tradeservice.controller;

import stu.tradeservice.DTO.FavoriteDTO;
import stu.tradeservice.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trade/favorites")
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
//    @PostMapping
//    public ResponseEntity<Favorites> addFavorite(@RequestBody Favorite favorite) {
//        Favorite createdFavorite = favoriteService.addFavorite(favorite);
//        return ResponseEntity.ok(createdFavorite);
//    }

    // 更新收藏商品


    // 删除收藏商品
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        favoriteService.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }
}