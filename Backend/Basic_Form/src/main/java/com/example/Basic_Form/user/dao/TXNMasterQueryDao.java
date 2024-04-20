package com.example.Basic_Form.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Basic_Form.model.TXNMaster;

@Repository
public interface TXNMasterQueryDao extends JpaRepository<TXNMaster, String> {
		
//	@Query(value = "SELECT * FROM txn_master WHERE "
//	        + "(:txnNumber IS NULL OR txn_number = :txnNumber) AND "
//	        + "(:creditAccountType IS NULL OR credit_account_type = :creditAccountType) AND "
//	        + "(:creditAccountTypeId IS NULL OR credit_account_type_id = :creditAccountTypeId) AND "
//	        + "(:creditType IS NULL OR credit_type = :creditType) AND "
//	        + "(:creditTypeId IS NULL OR credit_type_id = :creditTypeId) AND "
//	        + "(:creditCurrencyId IS NULL OR credit_currency_id = :creditCurrencyId) AND "
//	        + "(:debitAccountType IS NULL OR debit_account_type = :debitAccountType) AND "
//	        + "(:debitAccountTypeId IS NULL OR debit_account_type_id = :debitAccountTypeId) AND "
//	        + "(:debitType IS NULL OR debit_type = :debitType) AND "
//	        + "(:debitTypeId IS NULL OR debit_type_id = :debitTypeId) AND "
//	        + "(:debitCurrencyId IS NULL OR debit_currency_id = :debitCurrencyId) AND "
//	        + "(:txnCode IS NULL OR txn_code = :txnCode) AND "
//	        + "(:txnStatus IS NULL OR txn_status = :txnStatus) AND "
//	        + "(:txnType IS NULL OR txn_type = :txnType) AND "
//	        + "(:paymentMode IS NULL OR payment_mode = :paymentMode)", nativeQuery = true)
//    List<TXNMaster> findByAllProperties(
//            @Param("txnNumber") String txnNumber,
//            @Param("creditAccountType") Integer creditAccountType,
//            @Param("creditAccountTypeId") String creditAccountTypeId,
//            @Param("creditType") Integer creditType,
//            @Param("creditTypeId") String creditTypeId,
//            @Param("creditCurrencyId") String creditCurrencyId,
//            @Param("debitAccountType") Integer debitAccountType,
//            @Param("debitAccountTypeId") String debitAccountTypeId,
//            @Param("debitType") Integer debitType,
//            @Param("debitTypeId") String debitTypeId,
//            @Param("debitCurrencyId") String debitCurrencyId,
//            @Param("txnCode") String txnCode,
//            @Param("txnStatus") Integer txnStatus,
//            @Param("txnType") Integer txnType,
//            @Param("paymentMode") Integer paymentMode);
//		
//	@Query(value = "SELECT * FROM txn_master WHERE (txn_number LIKE %:keyword% OR txn_code LIKE %:keyword%)", nativeQuery = true)
//    List<TXNMaster> searchProductsByKeyword(@Param("keyword") String keyword);
}
