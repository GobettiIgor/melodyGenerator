package br.edu.utfpr.melodyGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "melodyparameter")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "melody_parameters_id")
public class MelodyParameter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long melody_parameters_id;

    @Column(nullable = false)
    private String instrument_name;

    @Column(nullable = false)
    private int qty_octaves;

    @Column(nullable = false)
    private int bpm;

    @Column(length = 10, nullable = false)
    private String scale_type;

    @Column(length = 2, nullable = false)
    private String main_note_scale;

    @Column(nullable = false)
    private int qty_repetitions;

    @Column(nullable = false)
    private String username;
}