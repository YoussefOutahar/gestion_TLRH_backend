package com.tlrh.gestion_tlrh_backend.Entity.Archive;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ArchivagePostActuel extends Archivage{
    private String posteActuel;
}