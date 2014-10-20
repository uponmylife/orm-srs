package study.orm.srs.model.content;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import study.orm.srs.model.Content;
import study.orm.srs.model.ContentKey;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Data
@Entity
public class Image extends Content {
    private String imageId;
    private String imageUrl;

    @Override
    public Collection getCollection() {
        return Collection.Image;
    }
}
