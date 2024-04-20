package com.example.Basic_Form.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Basic_Form.commonresponse.CommonAPIDataResponse;
import com.example.Basic_Form.model.TXNMaster;
import com.example.Basic_Form.model.request.DeleteTXNMasterRequest;
import com.example.Basic_Form.model.request.GetAllTXNMasterRequest;
import com.example.Basic_Form.model.request.GetTXNMasterRequest;
import com.example.Basic_Form.model.request.SaveTXNMasterRequest;
import com.example.Basic_Form.model.request.UpdateTXNMasterRequest;
import com.example.Basic_Form.model.response.GetAllTXNMasterResponse;
import com.example.Basic_Form.model.response.GetTXNMasterResponse;
import com.example.Basic_Form.model.response.SaveTXNMasterResponse;
import com.example.Basic_Form.model.response.TXNMasterData;
import com.example.Basic_Form.user.dao.TXNMasterQueryDao;
import com.example.Basic_Form.user.service.TXNMasterRepository;

@Service
public class JPATXNMasterRepository implements TXNMasterRepository {

	@Autowired
	private TXNMasterQueryDao txnMasterQueryDao;
	
	@Override
	public SaveTXNMasterResponse saveTxnMaster(SaveTXNMasterRequest saveTXNMasterRequest) 
	{
		TXNMaster txnMaster = null;
	
			//MultipartFile file=saveTXNMasterRequest.getFeaturedimage();
			//MultipartFile file1=saveTXNMasterRequest.getPdfimage();
			//System.out.print("this is"+file);
			//System.out.print("this is"+file1);
			txnMaster = TXNMaster.builder()
					.title(saveTXNMasterRequest.getTitle())
					.authors(saveTXNMasterRequest.getAuthors()) 
					.publicUrl(saveTXNMasterRequest.getPublicUrl()) 
					.articleDate(saveTXNMasterRequest.getArticleDate())				
					.accessCategory(saveTXNMasterRequest.getAccessCategory())
					.freeViewExpiry(saveTXNMasterRequest.getFreeViewExpiry())
					.description(saveTXNMasterRequest.getDescription())
					//.featuredimage(ImageUtils.compressImage(file.getBytes()))
					//.pdfimage(ImageUtils.compressImage(file1.getBytes()))
					.status(true)
					.publshedonconnect(true)
					.build();
		
				
				
				

		txnMasterQueryDao.save(txnMaster);

		SaveTXNMasterResponse saveTXNMasterResponse = new SaveTXNMasterResponse();
		saveTXNMasterResponse.setId(txnMaster.getId());
		saveTXNMasterResponse.setMessage("SAVED_DATA_SAVED_SUCCESSFULLY");
		return saveTXNMasterResponse;
	}

	@Override
	public CommonAPIDataResponse deleteTxnMaster(DeleteTXNMasterRequest deleteTXNMasterRequest) 
	{
		CommonAPIDataResponse commonAPIDataResponse = new CommonAPIDataResponse();

		if (txnMasterQueryDao.findById(deleteTXNMasterRequest.getId()).isPresent()) {
			txnMasterQueryDao.deleteById(deleteTXNMasterRequest.getId());
			commonAPIDataResponse.setMessage("BASE_TXN_MASTER_DATA_DELETED_SUCCESSFULLY");
			commonAPIDataResponse.setCheckValidationFailed(false);
			return commonAPIDataResponse;
        }
		commonAPIDataResponse.setValidationMessage("BASE_TXN_MASTER_DATA_NOT_FOUND");
		commonAPIDataResponse.setCheckValidationFailed(true);
		return commonAPIDataResponse;
	}
	
//
  	@Override
  	public GetTXNMasterResponse getTXNMaster(GetTXNMasterRequest getTXNMasterRequest) 
  	 
  	{
  		  GetTXNMasterResponse getDataResponse=new GetTXNMasterResponse();
  	
  	      Optional<TXNMaster> txnmaster= txnMasterQueryDao.findById(getTXNMasterRequest.getId());
  	      
          if (txnmaster.isPresent()) 
          {
        	   
	          	getDataResponse.setMessage("BASE_TXN_MASTER_DATA_FOUND_SUCCESSFULLY");
	          	getDataResponse.setCheckValidationFailed(false);
	            getDataResponse.setTxnMasterData(new TXNMasterData(txnmaster.get()));
	            return getDataResponse;
          }
          getDataResponse.setValidationMessage("TXN_MASTER_DATA_NOT_FOUND");
          getDataResponse.setCheckValidationFailed(true);
          return getDataResponse;
  	 }	
//  	
	@Override
  	public CommonAPIDataResponse updateTXNMaster(UpdateTXNMasterRequest updateTXNMasterRequest) 
  	{
		CommonAPIDataResponse commonAPIDataResponse = new CommonAPIDataResponse();

		String id = updateTXNMasterRequest.get_id();
		Optional<TXNMaster> store = txnMasterQueryDao.findById(id);
        
         
		if (store.isPresent()) 
		{
			TXNMaster txnMaster=store.get();
			txnMaster.setId(updateTXNMasterRequest.get_id());
	        txnMaster.setTitle(updateTXNMasterRequest.getTitle());
	        txnMaster.setAuthors(updateTXNMasterRequest.getAuthors());
	        txnMaster.setPublicUrl(updateTXNMasterRequest.getPublicUrl());
	        txnMaster.setArticleDate(updateTXNMasterRequest.getArticleDate());
	        txnMaster.setAccessCategory(updateTXNMasterRequest.getAccessCategory());
	        txnMaster.setFreeViewExpiry(updateTXNMasterRequest.getFreeViewExpiry());
	        txnMaster.setDescription(updateTXNMasterRequest.getDescription());
	        
	          
			txnMasterQueryDao.save(txnMaster);
			commonAPIDataResponse.setCheckValidationFailed(true);
			commonAPIDataResponse.setValidationMessage("BASE_TXN_MASTER_MASTER_DATA_UPDATED_SUCCESSFULLY");
			return commonAPIDataResponse;
		} else {
			commonAPIDataResponse.setCheckValidationFailed(false);
			commonAPIDataResponse.setMessage("BASE_TXN_MASTER_MASTER_MASTER_DATA_NOT_FOUND");
			return commonAPIDataResponse;
		}
      }
//  	
	@Override
  	public GetAllTXNMasterResponse AllTXNMasterMaster(GetAllTXNMasterRequest getAllTXNMasterRequest) 
  	{
  		GetAllTXNMasterResponse getAllDataResponse = new GetAllTXNMasterResponse();
  		boolean flag=false;
  		List<TXNMaster> criteriaArrayList = new ArrayList<>(100);

//		if (!Objects.isNull(getAllTXNMasterRequest.getTxnNumber())
//				|| !Objects.isNull(getAllTXNMasterRequest.getCreditAccountType())
//				|| !Objects.isNull(getAllTXNMasterRequest.getCreditAccountTypeId())
//				|| !Objects.isNull(getAllTXNMasterRequest.getCreditType())
//				|| !Objects.isNull(getAllTXNMasterRequest.getCreditTypeId())
//				|| !Objects.isNull(getAllTXNMasterRequest.getCreditCurrencyId())
//				|| !Objects.isNull(getAllTXNMasterRequest.getDebitAccountType())
//				|| !Objects.isNull(getAllTXNMasterRequest.getDebitAccountTypeId())
//				|| !Objects.isNull(getAllTXNMasterRequest.getDebitType())
//				|| !Objects.isNull(getAllTXNMasterRequest.getDebitTypeId())
//				|| !Objects.isNull(getAllTXNMasterRequest.getDebitCurrencyId())
//				|| !Objects.isNull(getAllTXNMasterRequest.getTxnCode())
//				|| !Objects.isNull(getAllTXNMasterRequest.getTxnType())
//				|| !Objects.isNull(getAllTXNMasterRequest.getTxnStatus())
//				|| !Objects.isNull(getAllTXNMasterRequest.getPaymentMode()))
//        {
//        	flag=true;
//        	criteriaArrayList.addAll(txnMasterQueryDao.findByAllProperties(getAllTXNMasterRequest.getTxnNumber(),
//        			getAllTXNMasterRequest.getCreditAccountType(),
//        			getAllTXNMasterRequest.getCreditAccountTypeId(),
//        			getAllTXNMasterRequest.getCreditType(),
//        			getAllTXNMasterRequest.getCreditTypeId(),
//        			getAllTXNMasterRequest.getCreditCurrencyId(),
//        			getAllTXNMasterRequest.getDebitAccountType(),
//        			getAllTXNMasterRequest.getDebitAccountTypeId(),
//        			getAllTXNMasterRequest.getDebitType(),
//        			getAllTXNMasterRequest.getDebitTypeId(),
//        			getAllTXNMasterRequest.getDebitCurrencyId(),
//        			getAllTXNMasterRequest.getTxnCode(),
//        			getAllTXNMasterRequest.getTxnType(),
//        			getAllTXNMasterRequest.getTxnStatus(),
//        			getAllTXNMasterRequest.getPaymentMode()));
//        }
//		if(!Objects.isNull(getAllTXNMasterRequest.getKeyword()))
//        {
//        flag=true;
//        criteriaArrayList.addAll(txnMasterQueryDao.searchProductsByKeyword(getAllTXNMasterRequest.getKeyword()));        
//        }

        if(flag==false)
        {
       	criteriaArrayList.addAll(txnMasterQueryDao.findAll());
        }
        
//        if (Objects.isNull(criteriaArrayList) || criteriaArrayList.isEmpty()) 
//  		{
//  		            getAllDataResponse.setValidationMessage("BASE_TXN_MASTER_DATA_NOT_FOUND");
//  		            getAllDataResponse.setCheckValidationFailed(true);
//  		            return getAllDataResponse;
//  		}
  		getAllDataResponse.setMessage("BASE_TXN_MASTER_DATA_FOUND");
  		List<TXNMasterData> TXNDataList = new ArrayList<>(criteriaArrayList.size());
  		for (TXNMaster i : criteriaArrayList) 
  		{
  			TXNDataList.add(new TXNMasterData(i));	
        }
        getAllDataResponse.setTXNMasterList(TXNDataList);
      
  		return getAllDataResponse;
  	}

}
