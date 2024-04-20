package com.example.Basic_Form.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="articles")
public class TXNMaster {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="_id")
    private String id;

    @Column(name="Title")
    private String title;
    @Column(name="Authors")
    private String authors;
    @Column(name="PublicUrl")
    private String publicUrl;
    @Column(name="ArticleDate")
    private Date articleDate;
    @Column(name="AccessCategory")
    private String accessCategory;  
    @Column(name="FreeViewExpiry")
    private Date freeViewExpiry;
    @Column(name="Description")
    private String description;
    
//    @Lob
//    @Column(name="featureimage")
//    private byte[] featuredimage;
//    
//    @Lob
//    @Column(name="pdfimg")
//    private byte[] pdfimage;
    
    @Column(name="status")
    private boolean status;
    
    @Column(name="publishedonconnect")
    private boolean publshedonconnect;
    
}
