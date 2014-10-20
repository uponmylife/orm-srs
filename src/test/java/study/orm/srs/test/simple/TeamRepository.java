package study.orm.srs.test.simple;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findByName(String name);
    List<Team> findByNameAndLocation(String name, String location);
}
