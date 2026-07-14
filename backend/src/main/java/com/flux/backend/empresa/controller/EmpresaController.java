package com.flux.backend.empresa.controller;


import com.flux.backend.empresa.dto.CreateEmpresaRequest;
import com.flux.backend.empresa.dto.EmpresaResponse;
import com.flux.backend.empresa.dto.UpdateEmpresaRequest;
import com.flux.backend.empresa.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {


    private final EmpresaService service;

    public EmpresaController(EmpresaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponse>create(@Valid @RequestBody CreateEmpresaRequest request){
        EmpresaResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse>findById(@PathVariable("id") Long id){
        EmpresaResponse response = service.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>>findAll(){
        List<EmpresaResponse> response=service.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponse>update(@PathVariable("id") Long id,
                                                 @Valid@RequestBody UpdateEmpresaRequest request)
    {
        EmpresaResponse response = service.update(id,request);
        return ResponseEntity.ok(response);

    }
}
