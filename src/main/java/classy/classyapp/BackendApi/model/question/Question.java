package classy.classyapp.BackendApi.model.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String detail;

    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;

    @OneToMany(mappedBy = "question")
    private List<QuestionHasAnswers> questionHasAnswers;

}
