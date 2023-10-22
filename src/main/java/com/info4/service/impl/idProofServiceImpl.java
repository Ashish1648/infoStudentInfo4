package com.info4.service.impl;

import com.info4.Dto.IdProofDto;
import com.info4.entity.IdProof;
import com.info4.exception.ResourseNotFoundException;
import com.info4.repositry.IdProofRepositry;
import com.info4.service.IdProofService;
import org.springframework.stereotype.Service;

@Service
public class idProofServiceImpl implements IdProofService {
    IdProofRepositry idProofRepositry;

    public idProofServiceImpl(IdProofRepositry idProofRepositry) {
        this.idProofRepositry = idProofRepositry;
    }

    @Override
    public IdProofDto updateById(long id, String panCardNumber) {

        IdProof idProof = idProofRepositry.findById(id).orElseThrow(
                () -> new ResourseNotFoundException("Not present")
        );
        idProof.setPanCardNumber(panCardNumber);
        IdProof save = idProofRepositry.save(idProof);
        IdProofDto dto=new IdProofDto();
        dto.setId(save.getId());
        dto.setPanCardNumber(save.getPanCardNumber());
        return dto;

    }


}
