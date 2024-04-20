package com.example.Basic_Form.model.request;

import com.example.Basic_Form.commonrequest.CommonAllAPIDataRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetTXNMasterRequest extends CommonAllAPIDataRequest {

	@JsonProperty("_id")
	private String id;

    public boolean checkBadRequest() {
        if (StringUtils.isEmpty(this.getId())) {
            return true;
        }
        return false;
    }
}
