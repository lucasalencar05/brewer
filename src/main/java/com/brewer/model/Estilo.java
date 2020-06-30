package com.brewer.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "estilo")
public class Estilo implements Serializable {

    private static final long serialVersion = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estilo estilo = (Estilo) o;
        return Objects.equals(codigo, estilo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nome;

    @OneToMany(mappedBy = "estilo")
    private List<Cerveja>  cervejas;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
