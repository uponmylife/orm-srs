package study.orm.srs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import study.orm.srs.model.Content;

@NoRepositoryBean
public interface ContentDao<T extends Content> extends CrudRepository<T, Long> {
}
