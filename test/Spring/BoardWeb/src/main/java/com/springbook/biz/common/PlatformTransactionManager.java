package com.springbook.biz.common;

import org.apache.ibatis.transaction.TransactionException;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;

public interface PlatformTransactionManager {
	TransactionStatus geTransactionStatus(TransactionDefinition definition)
	throws TransactionException;
	void commit(TransactionStatus status) throws TransactionException;
	void rollback(TransactionStatus status) throws TransactionException;
}
