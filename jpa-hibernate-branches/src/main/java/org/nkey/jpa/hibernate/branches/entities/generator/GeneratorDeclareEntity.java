package org.nkey.jpa.hibernate.branches.entities.generator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author m.nikolaev Date: 19.03.13 Time: 0:40
 */
@Entity
@Table(name = "junk")
public class GeneratorDeclareEntity {
    public static final String GENERATOR_CLASS =
            "org.nkey.jpa.hibernate.branches.entities.generator.BranchableIdIdentifierGenerator";
    public static final String ID_GENERATOR_SEQUENCE = "id_generator_sequence";
    public static final String SEQUENCE_GENERATOR = "sequence_generator";

    @SequenceGenerator(sequenceName = ID_GENERATOR_SEQUENCE, name = SEQUENCE_GENERATOR) @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
