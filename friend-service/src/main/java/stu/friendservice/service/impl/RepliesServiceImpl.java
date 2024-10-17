package stu.friendservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.friendservice.entity.Replies;
import stu.friendservice.mapper.RepliesMapper;
import stu.friendservice.service.RepliesService;
import java.util.List;

@Service
public class RepliesServiceImpl implements RepliesService {

    @Autowired
    private RepliesMapper repliesMapper;

    @Override
    public Replies getReplyById(Integer id) {
        return repliesMapper.selectById(id);
    }

    @Override
    public List<Replies> getRepliesByCommentId(Integer comment_id) {
        return repliesMapper.selectByCommentId(comment_id);
    }

    @Override
    public boolean createReply(Replies replies) {
        return repliesMapper.insert(replies) > 0;
    }

    @Override
    public boolean updateReply(Replies replies) {
        return repliesMapper.updateById(replies) > 0;
    }

    @Override
    public boolean deleteReply(Integer id) {
        return repliesMapper.deleteById(id) > 0;
    }
}
