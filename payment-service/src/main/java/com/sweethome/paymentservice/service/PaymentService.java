package com.sweethome.paymentservice.service;

import com.sweethome.paymentservice.entity.TransactionDetailsEntity;


public interface PaymentService {

    public TransactionDetailsEntity makeTransaction(TransactionDetailsEntity payment);

    public TransactionDetailsEntity getTransactionBasedOnId(int id);
}
