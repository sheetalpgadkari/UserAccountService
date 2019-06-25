package me.services;

import me.vo.AccountTransactionDetail;

import java.util.List;

public interface AccountTransactionRetrievalService
{
    List<AccountTransactionDetail> getAccountTransactions(String accountNumber);

}
