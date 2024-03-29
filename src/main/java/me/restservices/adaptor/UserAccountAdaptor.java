package me.restservices.adaptor;

import me.restservices.vo.ViewUserAccountDetail;
import me.vo.UserAccountDetail;
import org.springframework.stereotype.Component;

@Component("userAccountAdaptor")
public class UserAccountAdaptor
{
    public ViewUserAccountDetail toViewUserAccountDetail(UserAccountDetail userAccountDetail)
    {
        ViewUserAccountDetail viewUserAccountDetail = new ViewUserAccountDetail();
        viewUserAccountDetail.setNumber(userAccountDetail.getDisplayNumber());
        viewUserAccountDetail.setName( userAccountDetail.getName());
        viewUserAccountDetail.setAccountType(userAccountDetail.getAccountType());
        viewUserAccountDetail.setCurrency(userAccountDetail.getCurrency());
        viewUserAccountDetail.setBalanceAmount(userAccountDetail.getBalanceAmount());
        viewUserAccountDetail.setBalanceDate(userAccountDetail.getBalanceDate());
        return viewUserAccountDetail;
    }
}
