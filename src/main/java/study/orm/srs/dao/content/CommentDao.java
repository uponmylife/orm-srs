package study.orm.srs.dao.content;

import study.orm.srs.model.content.Comment;
import study.orm.srs.dao.ContentDao;

public interface CommentDao extends ContentDao<Comment> {
    Comment findByPlatformCodeAndContentTypeAndBbsIdAndArticleIdAndCommentId(
            String platformCode, String ContentType, String bbsId, String articleId, String commentId);
}
