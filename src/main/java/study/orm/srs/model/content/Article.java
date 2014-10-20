package study.orm.srs.model.content;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Article extends BasicContent {
    private String title;

    @Override
    public Collection getCollection() {
        return Collection.Article;
    }
}
