package me.repository;

import me.vo.AccountTransactionDetail;

import java.util.List;

public interface AccountTransactionRetrievalDAO
{
    List<AccountTransactionDetail> getAccountTransactions(String accountNumber);

}
