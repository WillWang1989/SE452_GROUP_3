package edu.depaul.se452.windycityflyers.course;

/*cool
 */

import edu.depaul.se452.windycityflyers.student.Student;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;

    private String dept;

    private int num;

    // To display list of course for students, need to start session or fetch eager
    @OneToMany   //(fetch = FetchType.EAGER)
    @JoinTable
            (
                    name="COURSE_STUDENTS",
                    joinColumns={ @JoinColumn(name="course_id", referencedColumnName="id")  }
            )
    @ToString.Exclude
    private List<Student> students;
}