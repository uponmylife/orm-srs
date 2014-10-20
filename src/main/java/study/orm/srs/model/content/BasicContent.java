package study.orm.srs.model.content;

import lombok.Data;
import study.orm.srs.model.Content;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BasicContent extends Content {
    private String platformCode;
    private String contentType;
    private String bbsId;
    private String articleId;
    private String writerId;
    private String text;
    private Date regDate;
}
