package br.edu.utfpr.melodyGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "userfeedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "feedback_id")
public class UserFeedback implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedback_id;

    @Column(nullable = false)
    private Integer grade;

    @Column
    private String improvement_suggestion;

    @Column(nullable = false)
    private Timestamp date_hour;

    @OneToOne
    @JoinColumn(name = "melody_id", referencedColumnName = "melody_id")
    private GeneratedMelody melody_id;
}
