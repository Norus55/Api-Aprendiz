package com.adso.norus.models;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Aprendices")
public class Aprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "aprendiz")
    private String aprendiz;
    @Column(name = "nota")
    private String nota;
    @Column(name = "estado")
    private String estado;
    @Column(name = "create_at")
    @CreatedDate
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEst() {
        return aprendiz;
    }

    public void setEst(String aprendiz) {
        this.aprendiz = aprendiz;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getEstado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
