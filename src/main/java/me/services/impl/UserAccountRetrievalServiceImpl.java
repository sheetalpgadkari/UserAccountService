package me.services.impl;

import me.repository.UserAccountRetrievalDAO;
import me.services.UserAccountRetrievalService;
import me.vo.UserAccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userAccountRetrievalService")
public class UserAccountRetrievalServiceImpl implements UserAccountRetrievalService
{
    @Autowired
    private UserAccountRetrievalDAO accountTransactionRetrievalDAO;

    @Override
    public List<UserAccountDetail> list(Long userId)
    {
        return accountTransactionRetrievalDAO.getUserAccount(userId);
    }
}
