package study.orm.srs.test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import study.orm.srs.SpringBootRunner;
import study.orm.srs.dao.TaskDao;
import study.orm.srs.dao.content.ArticleDao;
import study.orm.srs.dao.content.CommentDao;
import study.orm.srs.dao.content.ImageDao;
import study.orm.srs.model.content.Article;
import study.orm.srs.model.content.Comment;
import study.orm.srs.model.content.Image;
import study.orm.srs.repository.TaskRepository;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class InitialData {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ImageDao imageDao;

    @Test
    public void delete() throws Exception {
        taskDao.deleteAll();
        articleDao.deleteAll();
        commentDao.deleteAll();
        imageDao.deleteAll();
    }

    @Test
    public void create() throws Exception {
        createArticleTask(1, "CAFE", 1);
        createArticleTask(1, "CAFE", 2);
        createArticleTask(1, "CAFE", 3);
        createArticleTask(1, "CAFE", 4);
        createArticleTask(1, "CAFE", 5);
        createArticleTask(1, "CAFE", 6);
        createArticleTask(1, "CAFE", 7);
        createArticleTask(1, "CAFE", 8);
        createArticleTask(1, "CAFE", 9);
        createArticleTask(1, "CAFE", 1);
        createArticleTask(2, "BLOG", 1);
        createArticleTask(2, "BLOG", 2);
        createArticleTask(3, "PLANET", 1);
        createArticleTask(3, "PLANET", 2);
        createArticleTask(3, "PLANET", 3);
        createArticleTask(4, "TVPOT", 1);
        createCommentTask(1, "CAFE", 1);
        createCommentTask(1, "CAFE", 2);
        createCommentTask(1, "CAFE", 3);
        createCommentTask(1, "CAFE", 4);
        createCommentTask(1, "CAFE", 5);
        createCommentTask(4, "TVPOT", 1);
        createCommentTask(4, "TVPOT", 2);
        createCommentTask(4, "TVPOT", 3);
        createCommentTask(4, "TVPOT", 4);
        createCommentTask(4, "TVPOT", 5);
        createImageTask(1, 1);
        createImageTask(1, 2);
        createImageTask(1, 3);
        createImageTask(1, 4);
        createImageTask(1, 5);
    }

    private void createArticleTask(int serviceCode, String platformCode, int seq) {
        Article a = new Article();
        a.setServiceCode(serviceCode);
        a.setPlatformCode(platformCode);
        a.setContentType("ARTICLE");
        a.setBbsId("b" + seq);
        a.setArticleId("a" + seq);
        a.setWriterId("geo.c");
        a.setText("본문" + seq);
        a.setRegDate(new Date());
        a.setTitle("제목" + seq);
        taskRepository.create(a);
    }

    private void createCommentTask(int serviceCode, String platformCode, int seq) {
        Comment c = new Comment();
        c.setServiceCode(serviceCode);
        c.setPlatformCode(platformCode);
        c.setContentType("COMMENT");
        c.setBbsId("b" + seq);
        c.setArticleId("a" + seq);
        c.setCommentId("c" + seq);
        c.setWriterId("geo.c");
        c.setText("본문" + seq);
        c.setRegDate(new Date());
        taskRepository.create(c);
    }

    private void createImageTask(int serviceCode, int seq) {
        Image i = new Image();
        i.setServiceCode(serviceCode);
        i.setImageId("I" + seq);
        i.setImageUrl("http://cafe.daum.net/cmqi/" + seq);
    }
}
