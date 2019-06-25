package me.services;

import me.vo.AccountTransactionDetail;

import java.util.List;

public interface AccountTransactionService
{
    List<AccountTransactionDetail> getAccountTransactions(Long userId);

}
