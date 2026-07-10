package com.flux.backend.empresa.controller;


import com.flux.backend.empresa.dto.CreateEmpresaRequest;
import com.flux.backend.empresa.dto.EmpresaResponse;
import com.flux.backend.empresa.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
