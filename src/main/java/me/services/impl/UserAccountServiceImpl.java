package me.services.impl;

import me.services.UserAccountService;
import me.vo.UserAccountDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userAccountServcie")
public class UserAccountServiceImpl implements UserAccountService
{
    @Override
    public List<UserAccountDetail> list(Long userId)
    {
        List<UserAccountDetail> userAccountDetailList = new ArrayList<>();
        UserAccountDetail userAccountDetail = new UserAccountDetail();
        userAccountDetail.setDisplayName("Test 1");
        userAccountDetail.setDisplayNumber("33333");
        userAccountDetailList.add(userAccountDetail);
        return userAccountDetailList;
    }
}
