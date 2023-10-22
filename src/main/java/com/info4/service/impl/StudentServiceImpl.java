package com.info4.service.impl;

import com.info4.Dto.IdProofDto;
import com.info4.Dto.StudentDto;
import com.info4.entity.IdProof;
import com.info4.entity.Student;
import com.info4.exception.ResourseNotFoundException;
import com.info4.repositry.IdProofRepositry;
import com.info4.repositry.StudentRepositry;
import com.info4.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService {
    StudentRepositry studentRepositry;
    IdProofRepositry idProofRepositry;

    public StudentServiceImpl(StudentRepositry studentRepositry, IdProofRepositry idProofRepositry) {
        this.studentRepositry = studentRepositry;
        this.idProofRepositry = idProofRepositry;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        IdProof idProof=new IdProof();
        idProof.setPanCardNumber(studentDto.getIdProof().getPanCardNumber());
        idProof=idProofRepositry.save(idProof);

        Student student=new Student();
       student.setName(studentDto.getName());
       student.setCourse(studentDto.getCourse());
       student.setFee(studentDto.getFee());
       student.setIdProof(idProof);
        student = studentRepositry.save(student);
        //now convert entity to dto
        StudentDto dto=new StudentDto();
        dto.setId(student.getId());
        dto.setCourse(student.getCourse());
        dto.setName(student.getName());
        dto.setFee(student.getFee());
        IdProofDto idDto=new IdProofDto();
        idDto.setId(idProof.getId());
        idDto.setPanCardNumber(idProof.getPanCardNumber());
        dto.setIdProof(idDto);
        return dto;
    }

    @Override
    public StudentDto findDataById(long id) {
        Student student = studentRepositry.findById(id).orElseThrow(
                () -> new ResourseNotFoundException("Not Present with given id")
        );
       StudentDto studentDto=new StudentDto();
       studentDto.setId(student.getId());
       studentDto.setName(student.getName());
       studentDto.setCourse(student.getCourse());
       studentDto.setFee(student.getFee());
       IdProofDto idProofDto=new IdProofDto();
       idProofDto.setId(student.getIdProof().getId());
       idProofDto.setPanCardNumber(student.getIdProof().getPanCardNumber());
       studentDto.setIdProof(idProofDto);
       return studentDto;

    }
}
