package com.tlrh.gestion_tlrh_backend.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Archivage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="collaborateur_id")
    private Collaborateur collaborateur;

    private Date dateArchivage;

    private String posteActuel;

    private String posteApp;

    private int salaire;


}