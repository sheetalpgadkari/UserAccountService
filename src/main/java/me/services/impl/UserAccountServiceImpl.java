package me.services.impl;

import me.repository.UserAccountDAO;
import me.services.UserAccountService;
import me.vo.UserAccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userAccountServcie")
public class UserAccountServiceImpl implements UserAccountService
{
    @Autowired
    private UserAccountDAO userAccountDAO;

    @Override
    public List<UserAccountDetail> list(Long userId)
    {
        return userAccountDAO.getUserAccount(userId);
    }
}
