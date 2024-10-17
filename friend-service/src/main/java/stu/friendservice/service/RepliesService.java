package stu.friendservice.service;

import stu.friendservice.entity.Replies;
import java.util.List;

public interface RepliesService {

    Replies getReplyById(Integer id);

    List<Replies> getRepliesByCommentId(Integer comment_id);

    boolean createReply(Replies replies);

    boolean updateReply(Replies replies);

    boolean deleteReply(Integer id);
}
