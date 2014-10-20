package study.orm.srs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import study.orm.srs.dao.TaskDao;
import study.orm.srs.model.Content;
import study.orm.srs.model.Task;

import java.util.List;

@Repository
public class TaskRepository {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private ContentRepository contentRepository;

    public void create(Content content) {
        Content oldContent = contentRepository.findByContentKey(content);
        Task task = null;
        if (oldContent != null) {
            content.setId(oldContent.getId());
            task = taskDao.findOneByContentIdAndStatus(content.getId(), Task.Status.Wait);
        }
        contentRepository.save(content);
        if (task == null) task = new Task(content.getCollection(), content);
        taskDao.save(task);
    }

    public List<Task> find(Content.Collection collection, Integer serviceCode, Task.Status status, int page, int pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        List<Task> tasks = taskDao.findByCollectionAndServiceCodeAndStatus(collection, serviceCode, status, pageRequest);
        for (Task task : tasks) {
            Content content = contentRepository.findOne(collection, task.getContentId());
            task.setContent(content);
        }
        return tasks;
    }
}
