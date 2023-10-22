package com.info4.service;

import com.info4.Dto.IdProofDto;
import com.info4.Dto.StudentDto;

public interface StudentService {
    public StudentDto createStudent(StudentDto studentDto);
    public StudentDto findDataById(long id);
}
