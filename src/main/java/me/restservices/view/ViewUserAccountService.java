package me.restservices.view;

import me.restservices.adaptor.UserAccountAdaptor;
import me.restservices.auth.AuthService;
import me.restservices.vo.ViewUserAccountDetail;
import me.services.UserAccountRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="ViewUserAccount")
public class ViewUserAccountService
{


    @Autowired
    private AuthService demoAuthService;

    @Autowired
    private UserAccountRetrievalService userAccountService;

    @Autowired
    private UserAccountAdaptor userAccountAdaptor;


    @RequestMapping(value="list")
    public List<ViewUserAccountDetail> list()
    {
        return
            userAccountService.list(demoAuthService.getAuthUserId()).stream()
            .map( userAccountDetail -> userAccountAdaptor.toViewUserAccountDetail(userAccountDetail))
            .collect(Collectors.toList());

    }



}
