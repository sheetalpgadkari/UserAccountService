package me.repository;

import me.vo.AccountTransactionDetail;

import java.util.List;

public interface AccountTransactionDAO
{
    List<AccountTransactionDetail> getAccountTransactions(Long userId);

}
