package com.flux.backend.empresa.dto;

import com.flux.backend.empresa.entity.Empresa;
import com.flux.backend.empresa.enums.EmpresaStatus;

import java.time.Instant;

public class EmpresaResponse {

    private Long id;
    private String name;
    private String email;
    private EmpresaStatus status;
    private Instant createdAt;

    public EmpresaResponse(Empresa empresa){
        this.id = empresa.getId();
        this.name = empresa.getName();
        this.email = empresa.getEmail();
        this.status = empresa.getStatus();
        this.createdAt = empresa.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public EmpresaStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
