package com.example.rest.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Data
@Table(name = "posts")
public class Post {
    public Post(){

    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "modificationDate", nullable = false)
    private Date modificationDate;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        this.modificationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.modificationDate = new Date();
    }

   public String getContent() {
        return content;
   }

   public void setContent(String content) {
        this.content = content;
        this.modificationDate = new Date();
   }

   public Date getCreationDate() {
        return creationDate;
   }

   public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        this.modificationDate = new Date();
   }

   public Date getModificationDate() {
        return modificationDate;
   }

   public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
   }

}
