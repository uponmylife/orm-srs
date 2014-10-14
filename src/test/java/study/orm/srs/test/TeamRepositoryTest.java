package study.orm.srs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import study.orm.srs.SpringBootRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TeamRepositoryTest {
    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void test() throws Exception {
        Team team = new Team("SPD");
        teamRepository.save(team);
    }
}
