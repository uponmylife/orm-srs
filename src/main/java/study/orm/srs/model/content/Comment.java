package study.orm.srs.model.content;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Comment extends BasicContent {
    private String commentId;

    @Override
    public Collection getCollection() {
        return Collection.Comment;
    }
}
