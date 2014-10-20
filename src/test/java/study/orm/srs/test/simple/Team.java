package study.orm.srs.test.simple;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    private Date created;

    public Team() {
    }

    public Team(String name, String location) {
        this.name = name;
        this.location = location;
        created = new Date();
    }
}
