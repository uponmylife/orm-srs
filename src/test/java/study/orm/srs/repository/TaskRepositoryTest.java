package study.orm.srs.repository;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import study.orm.srs.SpringBootRunner;
import study.orm.srs.model.Content;
import study.orm.srs.model.Task;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TaskRepositoryTest extends TestCase {
    @Autowired
    private TaskRepository taskRepository;

    public void testCreate() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        List<Task> tasks = taskRepository.find(Content.Collection.Article, 1, Task.Status.Wait, 0, 3);
        for (Task task : tasks) System.out.println(task);
    }
}