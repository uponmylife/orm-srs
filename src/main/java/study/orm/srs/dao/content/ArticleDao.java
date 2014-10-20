package study.orm.srs.dao.content;

import study.orm.srs.model.content.Article;
import study.orm.srs.dao.ContentDao;

public interface ArticleDao extends ContentDao<Article> {
    Article findByPlatformCodeAndContentTypeAndBbsIdAndArticleId(
            String platformCode, String ContentType, String bbsId, String articleId);
}
