package com.info4.controller;

import com.info4.Dto.IdProofDto;
import com.info4.service.IdProofService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/idproof")
public class IdProofController {
    IdProofService idProofService;

    public IdProofController(IdProofService idProofService) {
        this.idProofService = idProofService;
    }
    //url=http://localhost:8080/api/idproof/1
@PutMapping("/{id}")
    public ResponseEntity<IdProofDto>getIdProofById(@RequestBody IdProofDto idProofDto, @PathVariable("id")long id){
        IdProofDto idProof=idProofService.updateById(id,idProofDto.getPanCardNumber());
        return new ResponseEntity<>(idProof, HttpStatus.CREATED);
    }
}
