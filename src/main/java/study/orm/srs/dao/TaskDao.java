package study.orm.srs.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import study.orm.srs.model.Content;
import study.orm.srs.model.Task;

import java.util.List;

public interface TaskDao extends PagingAndSortingRepository<Task, Long> {
    Task findOneByContentIdAndStatus(Long contentId, Task.Status status);

    List<Task> findByCollectionAndServiceCodeAndStatus(Content.Collection collection, Integer serviceCode,
                                                       Task.Status status, Pageable pageable);
}
