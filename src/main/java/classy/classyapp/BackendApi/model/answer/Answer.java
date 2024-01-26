package classy.classyapp.BackendApi.model.exam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String detail;

    @Enumerated(EnumType.STRING)
    private IsRightAnswer isRightAnswer;

}
