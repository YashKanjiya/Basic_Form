package com.example.Basic_Form.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Basic_Form.constant.APIRequestURL;
import com.example.Basic_Form.model.request.DeleteTXNMasterRequest;
import com.example.Basic_Form.model.request.GetAllTXNMasterRequest;
import com.example.Basic_Form.model.request.GetTXNMasterRequest;
import com.example.Basic_Form.model.request.SaveTXNMasterRequest;
import com.example.Basic_Form.model.request.UpdateTXNMasterRequest;
import com.example.Basic_Form.user.handler.TXNMasterResourceHandler;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping(APIRequestURL.BASE_URL)
public class TXNMasterController {

    @Autowired
    private  TXNMasterResourceHandler txnMasterResourceHandler;
    
    
    @PostMapping(APIRequestURL.TXN_MASTER_POST_API_URL)
    public ResponseEntity<JsonNode> SaveTXNMaster(@RequestHeader HttpHeaders headers, @RequestBody SaveTXNMasterRequest saveTXNMasterRequest) 
    {
        return txnMasterResourceHandler.SaveTXNMazster(headers,saveTXNMasterRequest);
    }

    @PutMapping(APIRequestURL.TXN_MASTER_PUT_API_URL)
    public ResponseEntity<JsonNode> UpdateTxnMaster(@RequestHeader HttpHeaders headers, @RequestBody UpdateTXNMasterRequest updateTXNMasterRequest) 
    {   	
        return txnMasterResourceHandler.UpdateTxnMaster(headers,updateTXNMasterRequest); 
    }


    @DeleteMapping(APIRequestURL.TXN_MASTER_DELETE_API_URL)
    public ResponseEntity<JsonNode> DeleteTXNMaster(@RequestHeader HttpHeaders headers, @PathVariable String id, @ModelAttribute DeleteTXNMasterRequest deleteTXNMasterRequest) 
    {
    	deleteTXNMasterRequest.setId(id);
        return txnMasterResourceHandler.DeleteTXNMasterMaster(headers, deleteTXNMasterRequest);
    }

    @GetMapping(APIRequestURL.TXN_MASTER_GET_API_URL)
    public ResponseEntity<JsonNode> GetTXNMaster(@RequestHeader HttpHeaders headers, @PathVariable String id, @ModelAttribute GetTXNMasterRequest getTXNMasterRequest) 
    {
    	getTXNMasterRequest.setId(id);
        return txnMasterResourceHandler.GetTXNMaster(headers, getTXNMasterRequest);
    }
     
    @GetMapping(APIRequestURL.TXN_MASTER_GET_ALL_API_URL)
    public ResponseEntity<JsonNode> GetAllTXNMaster(@RequestHeader HttpHeaders headers, @ModelAttribute GetAllTXNMasterRequest getAllTXNMasterRequest) 
    {
    	return txnMasterResourceHandler.GetAllTXNMaster(headers,getAllTXNMasterRequest);
    }
}
