package me.services;

import me.repository.impl.UserAccountRetrievalDAOImpl;
import me.services.impl.UserAccountRetrievalServiceImpl;
import me.vo.UserAccountDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={UserAccountRetrievalServiceImpl.class, UserAccountRetrievalDAOImpl.class})
public class TestUserAccountRetrivalService
{

    public static final Long TEST_USERID_1 = Long.valueOf(2002);

    public static final Long TEST_USERID_2 = Long.valueOf(2001);

    @Autowired
   private UserAccountRetrievalService userAccountService;

    @Test
    public void listAccounts()
    {
        List<UserAccountDetail> accountDetailList = userAccountService.list(TEST_USERID_1);
        assertEquals(2, accountDetailList.size());
    }

    @Test
    public void listAccountsWithNoAccounts()
    {
        List<UserAccountDetail> accountDetailList = userAccountService.list(TEST_USERID_2);
        assertEquals(0, accountDetailList.size());
    }
}

