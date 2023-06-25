package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;
// LOMBOK
@Data

// Entity
@Entity
@Table(name = "category")
// Category(1) Blog(N)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",unique = true,nullable = false)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // Relation
    @OneToMany(mappedBy ="categoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<BlogEntity> blogEntityList;

    //Parametresiz Constructor
    public CategoryEntity() {}
}
