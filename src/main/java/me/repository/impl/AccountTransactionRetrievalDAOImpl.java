package me.repository.impl;

import com.google.gson.Gson;
import me.repository.AccountTransactionRetrievalDAO;
import me.vo.AccountTransactionDetail;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component("accountTransactionRetrievalDAO")
public class AccountTransactionRetrievalDAOImpl implements AccountTransactionRetrievalDAO
{

    private List<AccountTransactionDetail> accountTransactionDetails = new ArrayList<>();
    public static final String CLASSPATH_DATA_ACCOUNT_TRANSACTION_DETAILS_JSON = "classpath:data/AccountTransactions.json";

    private AccountTransactionRetrievalDAOImpl()
    {
        init();
    }

    private void init()
    {
        accountTransactionDetails.addAll(
                Arrays.asList(new Gson().fromJson(getAccountTransactionData(), AccountTransactionDetail[].class)))
        ;
    }

    private String getAccountTransactionData()
    {
        try {
            File file = ResourceUtils.getFile(CLASSPATH_DATA_ACCOUNT_TRANSACTION_DETAILS_JSON);
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AccountTransactionDetail> getAccountTransactions(String accountNumber) {
        return accountTransactionDetails.stream()
                .filter( accountTransactionDetail -> accountNumber.equals(accountTransactionDetail.getAccountNumber()))
                .collect(Collectors.toList());
    }
}
