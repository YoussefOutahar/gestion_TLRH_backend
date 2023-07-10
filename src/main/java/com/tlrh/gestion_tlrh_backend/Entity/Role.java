package com.tlrh.gestion_tlrh_backend.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "RoleCollaborateur",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_collaborateur")
    )
    private List<Collaborateur> collaborateurs;
}
