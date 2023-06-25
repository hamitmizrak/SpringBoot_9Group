package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

// LOMBOK
@Data
@Builder

// Entity
@Entity
@Table(name = "category")
// Category(N) Blog(1)
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blog_id", nullable = false)
    BlogEntity blogEntity;

    //Parametresiz Constructor
    public CategoryEntity() {
    }

    //Parametreli Constructor
    public CategoryEntity(String categoryName, Date createdDate) {
        this.categoryName = categoryName;
        this.createdDate = createdDate;
    }

    // Spring Data (1-N) Sorgulama (inner join)
    // 1 nolu blogDto bütün kategorilerini sorgulatalım ?
}
