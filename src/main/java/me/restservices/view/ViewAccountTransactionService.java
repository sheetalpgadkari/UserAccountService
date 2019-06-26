package me.restservices.view;

import me.restservices.adaptor.AccountTransactionAdaptor;
import me.restservices.auth.AuthService;
import me.restservices.vo.ViewAccountTransactionDetail;
import me.services.AccountTransactionRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "AccountTransaction")
public class ViewAccountTransactionService {

    @Autowired
    private AccountTransactionAdaptor accountTransactionAdaptor;

    @Autowired
    private AccountTransactionRetrievalService accountTransactionRetrievalService;

    @RequestMapping(value = "/{accountNumber}")
    public List<ViewAccountTransactionDetail> getAccountTransactions(
            @PathVariable("accountNumber") String accountNumber
    ) {
        return
                accountTransactionRetrievalService.getAccountTransactions(accountNumber).stream()
                        .map(userAccountDetail -> accountTransactionAdaptor.toViewAccountTransactionDetail(userAccountDetail))
                        .collect(Collectors.toList());

    }

}
