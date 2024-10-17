package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.friendservice.DTO.CardDetailDTO;
import stu.friendservice.DTO.LoveCardDTO;
import stu.friendservice.client.UserClient;
import stu.friendservice.entity.LoveCards;
import stu.friendservice.entity.UserContacts;
import stu.friendservice.entity.UserDetails;
import stu.friendservice.entity.Users;
import stu.friendservice.mapper.LoveCardsMapper;
import stu.friendservice.mapper.UserContactsMapper;
import stu.friendservice.mapper.UserDetailsMapper;
import stu.friendservice.service.LoveCardsService;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoveCardsServiceImpl implements LoveCardsService {

    @Autowired
    private LoveCardsMapper loveCardsMapper;
    @Autowired
    private UserClient userClient;
    @Autowired
    UserContactsMapper userContactsMapper;
    @Autowired
    private UserDetailsMapper userDetailsMapper;


    @Override
    public CardDetailDTO getLoveCardById(Integer id) {
        UserContacts userContacts = userContactsMapper.selectByUserId(id);
        // 获取用户详细信息
        UserDetails userDetails = userDetailsMapper.selectByUserId(id);
        LoveCards loveCard = loveCardsMapper.selectById(id);
        Users user = userClient.getUserById(id); // 获取用户基本信息

        // 将信息封装到 CardDetailDTO 中
        CardDetailDTO cardDetailDTO = new CardDetailDTO();
        cardDetailDTO.setUserContacts(userContacts);
        cardDetailDTO.setUserDetails(userDetails);
        cardDetailDTO.getImages(userDetails.getImages().split(","));
        cardDetailDTO.setUsername(user.getUsername());
        cardDetailDTO.setAvatar(user.getAvatar());

        return cardDetailDTO;
    }

    @Override
    public List<LoveCards> getAllLoveCards() {
        return loveCardsMapper.selectAll();
    }

    @Override
    public boolean createLoveCard(LoveCards loveCards) {
        return loveCardsMapper.insert(loveCards) > 0;
    }

    @Override
    public boolean updateLoveCard(LoveCards loveCards) {
        return loveCardsMapper.updateById(loveCards) > 0;
    }

    @Override
    public boolean deleteLoveCard(Integer id) {
        return loveCardsMapper.deleteById(id) > 0;
    }

    @Override
    public List<LoveCardDTO> getLoveCards(int page, int size) {
        // 计算起始位置
        int offset = (page - 1) * size;

        // 获取当前页的 LoveCards 列表
        List<LoveCards> loveCardsList = loveCardsMapper.selectLoveCards(offset, size);

        // 创建 LoveCardDTO 列表
        List<LoveCardDTO> loveCardDTOs = new ArrayList<>();

        for (LoveCards loveCard : loveCardsList) {
            // 假设您可以通过 userClient 获取用户信息
            Users user = userClient.getUserById(loveCard.getUser_id());
            UserContacts usercontact = userContactsMapper.selectByUserId(loveCard.getUser_id());
            LoveCardDTO loveCardDTO = new LoveCardDTO(
                    loveCard.getUser_id(),
                    user.getAvatar(),
                    loveCard.getPhoto_url(),
                    loveCard.getDeclaration(),
                    user.getUsername(),
                    usercontact.getView(),
                    usercontact.getLike(),
                    usercontact.getFlower()
            );

            loveCardDTOs.add(loveCardDTO);
        }

        return loveCardDTOs;
    }

}
