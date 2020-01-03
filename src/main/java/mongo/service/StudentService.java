package mongo.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mongo.entity.Student;
import mongo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;

    public Student save(String firstName, String lastName, String groupNumber) {
        Student student = new Student(firstName, lastName, groupNumber);
        return studentRepo.save(student);
    }

    public List<Student> findByNames(String firstName, String lastName) {
        return studentRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}
