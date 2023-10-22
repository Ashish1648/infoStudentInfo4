package com.info4.Dto;

import lombok.Data;

@Data
public class StudentDto {
    private long id;
    private String name;
    private String course;
    private double fee;
    private IdProofDto idProof;
}
