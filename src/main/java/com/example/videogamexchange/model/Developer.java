package com.example.videogamexchange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(
        name = "developer"
)
public class Developer {
    @Id
    @SequenceGenerator(
            name = "developer_id_sequence",
            sequenceName = "developer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "developer_id_sequence"
    )
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String name;

    public Developer() {
    }

    public Developer(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
