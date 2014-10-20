package study.orm.srs.dao.content;

import study.orm.srs.model.content.Image;
import study.orm.srs.dao.ContentDao;

public interface ImageDao extends ContentDao<Image> {
    Image findByImageId(String imageId);
}
