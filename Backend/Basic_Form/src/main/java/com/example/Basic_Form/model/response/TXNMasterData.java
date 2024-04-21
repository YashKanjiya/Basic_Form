package com.example.Basic_Form.model.response;

import java.sql.Date;

import com.example.Basic_Form.model.TXNMaster;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TXNMasterData{


    @JsonProperty("_id")
    private String id;

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Authors")
    private String authors;
    @JsonProperty("PublicUrl")
    private String publicUrl;
    @JsonProperty("ArticleDate")
    private Date articleDate;
    @JsonProperty("AccessCategory")
    private String accessCategory;  
    @JsonProperty("FreeViewExpiry")
    private Date freeViewExpiry;
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("featureimage")
    private byte[] featuredimage;
    
    @JsonProperty("pdfimg")
    private byte[] pdfimage;
    
    @JsonProperty("status")
    private boolean status;
    
    @JsonProperty("publishedonconnect")
    private boolean publshedonconnect;
    

	public TXNMasterData(TXNMaster txnMaster) 
	{
		this.id=txnMaster.getId();
		this.title=txnMaster.getTitle();
		this.authors=txnMaster.getAuthors();
		this.publicUrl=txnMaster.getPublicUrl();
		this.articleDate=txnMaster.getArticleDate();
		this.accessCategory=txnMaster.getAccessCategory();
		this.freeViewExpiry=txnMaster.getFreeViewExpiry();
		this.description=txnMaster.getDescription();
		this.status=true;
		this.publshedonconnect=true;
		//this.featuredimage=txnMaster.getFeaturedimage();
		//this.pdfimage=txnMaster.getPdfimage();
	}
	

}
