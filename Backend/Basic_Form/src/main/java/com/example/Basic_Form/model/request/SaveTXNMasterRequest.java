package com.example.Basic_Form.model.request;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.example.Basic_Form.commonrequest.CommonAllAPIDataRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveTXNMasterRequest extends CommonAllAPIDataRequest {
	

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
    
   

	public Boolean checkBadRequest() 
	{

//		if (StringUtils.isEmpty(this.getCompany_id())) 
//		{ 
//			return true; 
//		}
		
//		if (StringUtils.isEmpty(this.getVender_category_id())) {
//			return true;
//		}
//		if (StringUtils.isEmpty(this.getProduct_code())) {
//			return true;
//		}
//		if (StringUtils.isEmpty(this.getProduct_name())) {
//			return true;
//		}
//		if (StringUtils.isEmpty(this.getProduct_description())) {
//			return true;
//		}
//		if (Objects.isNull(this.getProduct_price_type())) {
//			return true;
//		}
//		if (Objects.isNull(this.getProduct_range_price())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getStatus_id())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getVendor_product_json())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getVendor_id())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getVendor_provider_id())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getAmount_currency())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getSku_code())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getCommission_rate())) {
//			return true;
//		}
//		
//		if (Objects.isNull(this.getCountry_code())) {
//			return true;
//		}
		return false;
	}
}
