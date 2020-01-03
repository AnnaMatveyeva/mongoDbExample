package mongo.repository;

import java.util.List;
import mongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

}
