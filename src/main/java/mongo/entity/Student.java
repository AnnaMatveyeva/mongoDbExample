package mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "staff")
public class Student {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String groupNumber;

    public Student(String firstName, String lastName, String groupNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
    }
}
