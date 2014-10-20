package study.orm.srs.test.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import study.orm.srs.SpringBootRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TeamRepositoryTest {
    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void test() throws Exception {
        teamRepository.save(new Team("SPD", "jeju"));
        teamRepository.save(new Team("SPD", "hannam"));
        teamRepository.save(new Team("USER", "jeju"));
        teamRepository.save(new Team("USER", "hannam"));

        List<Team> list = teamRepository.findByName("SPD");
        for (Team team : list) System.out.println(team);
        printHr();
        list = teamRepository.findByNameAndLocation("SPD", "jeju");
        for (Team team : list) System.out.println(team);
        printHr();
        System.out.println(teamRepository.findOne(40l));

    }

    private void printHr() {
        System.out.println("-------------------------------------------");
    }
}
