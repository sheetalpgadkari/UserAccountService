package me.services.impl;

import me.repository.AccountTransactionRetrievalDAO;
import me.services.AccountTransactionRetrievalService;
import me.vo.AccountTransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountTransactionRetrievalService")
public class AccountTransactionRetrievalServiceImpl implements AccountTransactionRetrievalService
{

    @Autowired
    private AccountTransactionRetrievalDAO accountTransactionRetrievalDAO;

    @Override
    public List<AccountTransactionDetail> getAccountTransactions(String accountNumber)
    {
        return accountTransactionRetrievalDAO.getAccountTransactions(accountNumber);
    }
}
