package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data

// Entity
@Entity
@Table(name = "blog")
// Blog(1) Category(N)
public class BlogEntity implements Serializable {
    public static final Long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id",unique = true,nullable = false)
    private Long blogId;

    @Column(length =200)
    private String header;
    private String content;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // Relation
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    CategoryEntity categoryEntity;

    //parametresiz constructor
    public BlogEntity() {}
    //parametreli constructor (Composition)
    public BlogEntity(String header, String content, CategoryEntity categoryEntity) {
        this.header = header;
        this.content = content;
        this.categoryEntity = categoryEntity;
    }
}
