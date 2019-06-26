package me.resetservices.adaptor;

import me.restservices.adaptor.AccountTransactionAdaptor;
import me.restservices.vo.ViewAccountTransactionDetail;
import me.vo.AccountTransactionDetail;
import me.vo.Currency;
import me.vo.TransactionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AccountTransactionAdaptor.class})
public class TestAccountTransactionAdaptor
{

    @Autowired
    private AccountTransactionAdaptor accountTransactionAdaptor;

    @Test
    public void viewAccountTransactionDetailsWithDebitAccountTransaction()
    {
        AccountTransactionDetail accountTransactionDetail = new AccountTransactionDetail();
        accountTransactionDetail.setTransactionType(TransactionType.DEBIT);
        accountTransactionDetail.setTransactionAmount(BigDecimal.TEN);
        ViewAccountTransactionDetail viewAccountTransactionDetail =
                accountTransactionAdaptor.toViewAccountTransactionDetail(accountTransactionDetail);
        assertEquals( BigDecimal.TEN, viewAccountTransactionDetail.getDebitAmount());
        assertNull( viewAccountTransactionDetail.getCreditAmount());
    }

    @Test
    public void viewAccountTransactionDetailsWithCreditAccountTransaction()
    {
        AccountTransactionDetail accountTransactionDetail = new AccountTransactionDetail();
        accountTransactionDetail.setTransactionType(TransactionType.CREDIT);
        accountTransactionDetail.setTransactionAmount(BigDecimal.ONE);
        ViewAccountTransactionDetail viewAccountTransactionDetail =
                accountTransactionAdaptor.toViewAccountTransactionDetail(accountTransactionDetail);
        assertEquals( BigDecimal.ONE, viewAccountTransactionDetail.getCreditAmount());
        assertNull( viewAccountTransactionDetail.getDebitAmount());
    }

    @Test
    public void viewAccountTransactionDetails()
    {
        AccountTransactionDetail accountTransactionDetail = new AccountTransactionDetail();
        accountTransactionDetail.setTransactionType(TransactionType.CREDIT);
        accountTransactionDetail.setAccountName("Test");
        accountTransactionDetail.setCurrency(Currency.AUD);
        accountTransactionDetail.setAccountNumber("1234");
        ViewAccountTransactionDetail viewAccountTransactionDetail =
                accountTransactionAdaptor.toViewAccountTransactionDetail(accountTransactionDetail);
        assertEquals( accountTransactionDetail.getTransactionType(), viewAccountTransactionDetail.getTransactionType());
        assertEquals( accountTransactionDetail.getCurrency() , viewAccountTransactionDetail.getCurrency() );
        assertEquals( accountTransactionDetail.getAccountNumber(), viewAccountTransactionDetail.getAccountNumber());
    }

}
