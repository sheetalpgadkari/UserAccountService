package me.restservices.adaptor;

import me.restservices.vo.ViewAccountTransactionDetail;
import me.vo.AccountTransactionDetail;
import me.vo.TransactionType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("accountTransactionAdaptor")
public class AccountTransactionAdaptor
{
    public ViewAccountTransactionDetail toViewAccountTransactionDetail(AccountTransactionDetail accountTransactionDetail) {

        final ViewAccountTransactionDetail viewAccountTransactionDetail = new ViewAccountTransactionDetail();
        viewAccountTransactionDetail.setAccountNumber(accountTransactionDetail.getAccountNumber());
        viewAccountTransactionDetail.setAccountName(accountTransactionDetail.getAccountName());
        viewAccountTransactionDetail.setDate(accountTransactionDetail.getDate());
        viewAccountTransactionDetail.setCurrency(accountTransactionDetail.getCurrency());
        viewAccountTransactionDetail.setTransactionType(accountTransactionDetail.getTransactionType());
        Optional.ofNullable(accountTransactionDetail.getTransactionType())
                .filter(TransactionType.CREDIT::equals)
                .ifPresent(transactionType -> viewAccountTransactionDetail.setCreditAmount(accountTransactionDetail.getTransactionAmount()));
        Optional.ofNullable(accountTransactionDetail.getTransactionType())
                .filter(TransactionType.DEBIT::equals)
                .ifPresent(transactionType -> viewAccountTransactionDetail.setDebitAmount(accountTransactionDetail.getTransactionAmount()));
        viewAccountTransactionDetail.setTransactionNarrative(accountTransactionDetail.getTransactionNarrative());
        return viewAccountTransactionDetail;
    }
}
