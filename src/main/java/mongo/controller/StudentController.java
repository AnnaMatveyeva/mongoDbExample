package mongo.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mongo.entity.Student;
import mongo.service.StudentService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/student")
    public List<Student> getOne(@RequestParam String firstName, @RequestParam String lastName,
        HttpServletResponse response) throws IOException {
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            return studentService.findByNames(firstName, lastName);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Request params are empty");
            return null;
        }
    }

    @PostMapping("/student")
    public Student saveOne(@RequestParam String firstName, @RequestParam String lastName,
        String groupNumber) {
        Student student = studentService.save(firstName, lastName, groupNumber);
        System.out.println(student);
        return student;
    }
}
