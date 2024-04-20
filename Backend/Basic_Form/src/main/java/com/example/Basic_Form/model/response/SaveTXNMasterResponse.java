package com.example.Basic_Form.model.response;

import com.example.Basic_Form.commonresponse.CommonAPIDataResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveTXNMasterResponse extends CommonAPIDataResponse {

	@JsonProperty("_id")
    private String id;
}
