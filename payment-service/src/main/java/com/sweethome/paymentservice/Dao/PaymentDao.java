package com.sweethome.paymentservice.Dao;

import com.sweethome.paymentservice.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository <TransactionDetailsEntity, Integer>{
}
