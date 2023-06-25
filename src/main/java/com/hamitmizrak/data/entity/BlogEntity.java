package com.hamitmizrak.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private Long id;

    @Column(length =200)
    private String header;

    private String content;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // Relation
    @OneToMany(mappedBy ="blogEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<CategoryEntity> categoryEntityList;

    //parametresiz constructor
    public BlogEntity() {
    }

    //parametreli constructor
    public BlogEntity(String header, String content) {
        this.header = header;
        this.content = content;
    }
}
