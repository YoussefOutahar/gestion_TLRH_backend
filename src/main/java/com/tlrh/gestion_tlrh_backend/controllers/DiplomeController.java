package com.tlrh.gestion_tlrh_backend.controllers;

import com.tlrh.gestion_tlrh_backend.entity.Collaborateur;
import com.tlrh.gestion_tlrh_backend.entity.Diplome;
import com.tlrh.gestion_tlrh_backend.service.CollaborateurService;
import com.tlrh.gestion_tlrh_backend.service.DiplomeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/diplome")
@AllArgsConstructor
public class DiplomeController {

    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private DiplomeService diplomeService;

    @PostMapping("craeteDiplome")
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        try {
            Diplome createdDiplome = diplomeService.createDiplome(diplome);
            return new ResponseEntity<>(createdDiplome, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/{diplomeId}/collaborateurs/{collaborateurId}")
    public ResponseEntity<Diplome> affectDiplomeToACollaborateur(
            @PathVariable int diplomeId,
            @PathVariable int collaborateurId
    ) {
        try {

            Diplome affectedDiplome = diplomeService.AffectDiplomeToACollaborateur(diplomeId, collaborateurId);
            return new ResponseEntity<>(affectedDiplome, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}