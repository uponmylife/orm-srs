package study.orm.srs.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer serviceCode;
    @Enumerated(EnumType.STRING)
    private Status status = Status.Wait;
    @Enumerated(EnumType.STRING)
    private Content.Collection collection;
    private Long contentId;
    @Transient
    private Content content;

    public enum Status {Wait, Progress, Complete}

    public Task() {
    }

    public Task(Content.Collection collection, Content content) {
        this.collection = collection;
        this.contentId = content.getId();
        this.content = content;
        this.serviceCode = content.getServiceCode();
    }
}
