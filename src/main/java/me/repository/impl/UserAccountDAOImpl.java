package me.repository.impl;

import com.google.gson.Gson;
import me.repository.UserAccountDAO;
import me.vo.UserAccountDetail;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component("userAccountDAO")
public class UserAccountDAOImpl implements UserAccountDAO
{
    public static final String CLASSPATH_DATA_USER_ACCOUNT_DETAIL_JSON = "classpath:data/UserAccountDetail.json";

    List<UserAccountDetail> userAccountDetailList = new ArrayList<>();
    private UserAccountDAOImpl()
    {
        init();
    }

    private void init()
    {
        userAccountDetailList.addAll(
                Arrays.asList(new Gson().fromJson(getUserAccountData(), UserAccountDetail[].class)))
        ;
    }

    private String getUserAccountData()
    {
        try {
            File file = ResourceUtils.getFile(CLASSPATH_DATA_USER_ACCOUNT_DETAIL_JSON);
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserAccountDetail> getUserAccount(Long userId) {
        return userAccountDetailList.stream()
                .filter(userAccountDetail -> userId.equals(userAccountDetail.getUserId()))
                .collect(Collectors.toList());
    }
}
