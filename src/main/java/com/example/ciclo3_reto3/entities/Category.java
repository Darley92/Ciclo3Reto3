package com.example.ciclo3_reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table (name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String name;
    private String description;

    @OneToMany
    @JsonIgnoreProperties("category")
    private List<Machine> machines;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer id) {
        this.idCategory = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> Machines) {
        this.machines = machines;
    }


}
