package com.example.Basic_Form.model.request;

import com.example.Basic_Form.commonrequest.CommonAllAPIDataRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetAllTXNMasterRequest extends CommonAllAPIDataRequest {

	// Filter

	 
	    

//		search

		private String keyword;

		public boolean checkBadRequest() {
//	        if (StringUtils.isEmpty(this.getCompany_id())) {
//	            return true;
//	        }
			return false;
		}
}
