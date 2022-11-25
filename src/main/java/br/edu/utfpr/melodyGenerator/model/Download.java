package br.edu.utfpr.melodyGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "sharing_id")
public class Download implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long download_id;

    @Column(nullable = false)
    private String file_type;

    @OneToOne
    @JoinColumn(name = "melody_id", referencedColumnName = "melody_id")
    private GeneratedMelody generated_melody_id;
}
