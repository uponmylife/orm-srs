package study.orm.srs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import study.orm.srs.dao.ContentDao;
import study.orm.srs.dao.content.ArticleDao;
import study.orm.srs.dao.content.CommentDao;
import study.orm.srs.dao.content.ImageDao;
import study.orm.srs.model.Content;
import study.orm.srs.model.content.Article;
import study.orm.srs.model.content.Comment;
import study.orm.srs.model.content.Image;

@Repository
public class ContentRepository {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ImageDao imageDao;

    public void save(Content content) {
        selectDao(content.getCollection()).save(content);
    }

    public Content findOne(Content.Collection collection, Long contentId) {
        return (Content) selectDao(collection).findOne(contentId);
    }

    public Content findByContentKey(Content content) {
        switch (content.getCollection()) {
            case Article:
                Article a = (Article) content;
                return articleDao.findByPlatformCodeAndContentTypeAndBbsIdAndArticleId(
                        a.getPlatformCode(), a.getContentType(), a.getBbsId(), a.getArticleId());
            case Comment:
                Comment c = (Comment) content;
                return commentDao.findByPlatformCodeAndContentTypeAndBbsIdAndArticleIdAndCommentId(
                        c.getPlatformCode(), c.getContentType(), c.getBbsId(), c.getArticleId(), c.getCommentId());
            case Image:
                Image i = (Image) content;
                return imageDao.findByImageId(i.getImageId());
            default:
                return null;
        }
    }

    private ContentDao selectDao(Content.Collection collection) {
        switch (collection) {
            case Article:
                return articleDao;
            case Comment:
                return commentDao;
            case Image:
                return imageDao;
            default:
                throw new RuntimeException("matched contentRepository not found. " + collection);
        }
    }
}
