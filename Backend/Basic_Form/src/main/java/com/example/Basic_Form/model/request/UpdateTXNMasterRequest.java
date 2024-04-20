package com.example.Basic_Form.model.request;

import java.sql.Date;

import com.example.Basic_Form.commonrequest.CommonAllAPIDataRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTXNMasterRequest extends CommonAllAPIDataRequest {

	
	@JsonProperty("_id") 
    private String _id;
	  
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
    
//    @JsonProperty("Featureimage")
//    private MultipartFile featuredimage;
//    
//    @JsonProperty("Pdfimg")
//    private MultipartFile pdfimage;    
    public boolean checkBadRequest() 
    {
//        if (Objects.isNull(this.getUpdateTXNMASTER())
//                || this.getUpdateTXNMASTER().isEmpty()) {
//            return true;
//        }
//        if (!this.getUpdateTXNMASTER().containsKey("_id")
//                || Objects.isNull(this.getUpdateTXNMASTER().get("_id"))) {
//            return true;
//        }
        return false;
    }
    
}
