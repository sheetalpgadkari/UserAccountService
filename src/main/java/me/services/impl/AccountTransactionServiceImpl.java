package me.services.impl;

import me.repository.AccountTransactionDAO;
import me.services.AccountTransactionService;
import me.vo.AccountTransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountTransactionServiceImpl implements AccountTransactionService
{

    @Autowired
    private AccountTransactionDAO accountTransactionDAO;

    @Override
    public List<AccountTransactionDetail> getAccountTransactions(Long userId)
    {
        return accountTransactionDAO.getAccountTransactions(userId);
    }
}
