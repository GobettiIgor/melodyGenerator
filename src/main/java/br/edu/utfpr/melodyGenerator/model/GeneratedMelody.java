package br.edu.utfpr.melodyGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "generatedmelody")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "melody_id")
public class GeneratedMelody implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long melody_id;

    @Column(nullable = false)
    private String notes_array;

    @Column(nullable = false)
    private Timestamp date_hour;

    @OneToOne
    @JoinColumn(name = "melody_parameters_id", referencedColumnName = "melody_parameters_id")
    private MelodyParameter melody_parameters_id;
}
