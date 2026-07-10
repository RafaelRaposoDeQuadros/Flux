package com.flux.backend.empresa.entity;

import com.flux.backend.empresa.enums.EmpresaStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="tb_empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer status;
    private Instant createdAt;

    public Empresa(){

    }

    public Empresa(Long id, String name, String email, EmpresaStatus status, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
       setStatus(status);
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmpresaStatus getStatus() {
        if(status == null){
            return null;
        }
        return EmpresaStatus.valueOf(status);
    }

    public void setStatus(EmpresaStatus status) {
        if(status != null) {
            this.status = status.getCode();
        }
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
