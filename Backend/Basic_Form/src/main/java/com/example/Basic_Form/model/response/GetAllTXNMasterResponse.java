package com.example.Basic_Form.model.response;

import java.util.List;

import com.example.Basic_Form.commonresponse.CommonAPIDataResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetAllTXNMasterResponse extends CommonAPIDataResponse {

	@JsonProperty("Article")
    private List<TXNMasterData> TXNMasterList;
}
