package com.example.Basic_Form.user.service;

import com.example.Basic_Form.commonresponse.CommonAPIDataResponse;
import com.example.Basic_Form.model.request.DeleteTXNMasterRequest;
import com.example.Basic_Form.model.request.GetAllTXNMasterRequest;
import com.example.Basic_Form.model.request.GetTXNMasterRequest;
import com.example.Basic_Form.model.request.SaveTXNMasterRequest;
import com.example.Basic_Form.model.request.UpdateTXNMasterRequest;
import com.example.Basic_Form.model.response.GetAllTXNMasterResponse;
import com.example.Basic_Form.model.response.GetTXNMasterResponse;
import com.example.Basic_Form.model.response.SaveTXNMasterResponse;


public interface TXNMasterRepository {

    SaveTXNMasterResponse saveTxnMaster(SaveTXNMasterRequest saveTXNMasterRequest);

    CommonAPIDataResponse updateTXNMaster(UpdateTXNMasterRequest updateTXNMasterRequest);
//
    CommonAPIDataResponse deleteTxnMaster(DeleteTXNMasterRequest deleteTXNMasterRequest);
//
    GetTXNMasterResponse getTXNMaster(GetTXNMasterRequest getTXNMasterRequest);
//
    GetAllTXNMasterResponse AllTXNMasterMaster(GetAllTXNMasterRequest getAllTXNMasterRequest);

}
