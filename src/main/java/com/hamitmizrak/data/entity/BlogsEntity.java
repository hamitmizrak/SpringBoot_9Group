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
public class BlogsEntity implements Serializable {
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
    CategoryEntity relationCategoryEntity;

    //parametresiz constructor
    public BlogsEntity() {}
    //parametreli constructor (Composition)
    public BlogsEntity(String header, String content, CategoryEntity relationCategoryEntity) {
        this.header = header;
        this.content = content;
        this.relationCategoryEntity = relationCategoryEntity;
    }
}
