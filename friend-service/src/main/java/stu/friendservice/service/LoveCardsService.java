package stu.friendservice.service;

import stu.friendservice.DTO.CardDetailDTO;
import stu.friendservice.DTO.LoveCardDTO;
import stu.friendservice.entity.LoveCards;
import java.util.List;

public interface LoveCardsService {

    CardDetailDTO getLoveCardById(Integer id);

    List<LoveCards> getAllLoveCards();

    boolean createLoveCard(LoveCards loveCards);

    boolean updateLoveCard(LoveCards loveCards);

    boolean deleteLoveCard(Integer id);

    List<LoveCardDTO> getLoveCards(int page, int size);

}
