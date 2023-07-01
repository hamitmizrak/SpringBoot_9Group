package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

// LOMBOK
@Data

// Entity
@Entity
@Table(name = "roles")
// Roles(M) Users(N)
public class RolesEntity implements Serializable {
    public static final Long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id",unique = true,nullable = false)
    private Long rolesId;

    @Column(name = "roles_name")
    private String rolesName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    //parametresiz constructor
    public RolesEntity() {}

    //parametreli constructor
    public RolesEntity(String rolesName) {
        this.rolesName = rolesName;
    }

    // RELATION
    @ManyToMany(mappedBy = "relationRolesEntities",fetch = FetchType.LAZY)
    private Collection<UsersEntity> relationUsersEntities;
} //end class
