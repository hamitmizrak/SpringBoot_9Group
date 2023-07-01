package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
// LOMBOK
@Data

// Entity
@Entity
@Table(name = "category")
// Category(1) Blog(N)
public class CategoryEntity implements Serializable {
    public static final Long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",unique = true,nullable = false)
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // Relation
    @OneToMany(mappedBy ="relationCategoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<BlogsEntity> relationBlogEntityList;

    //Parametresiz Constructor
    public CategoryEntity() {}

    // Not: One olan obje için parametreli constructora eklemeyelim.
    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }
}
