package classy.classyapp.BackendApi.model.exam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private double percentageValue;

    @OneToMany(mappedBy = "exam")
    private List<ExamHasQuestions> examHasQuestions;

}
