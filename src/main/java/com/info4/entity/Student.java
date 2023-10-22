package com.info4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String course;
    private double fee;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_proof_id",referencedColumnName="id")
    private IdProof idProof;
}