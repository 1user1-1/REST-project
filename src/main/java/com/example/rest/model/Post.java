package com.example.rest.model;

import java.util.Date;

public class Post {

    private Integer id;

    private String name;

    private String content;

    private Date creationDate;

    private Date modificationDate;

    public Post(int id, String name, String content, Date creationDate, Date modificationDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }
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
