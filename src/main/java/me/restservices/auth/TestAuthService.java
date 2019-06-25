package me.restservices.auth;

import org.springframework.stereotype.Component;

@Component("deomAuthService")
public class TestAuthService implements AuthService
{

    public static final int DEMO_USER_ID = 2002;

    @Override
    public Long getAuthUserId() {
        return Long.valueOf(DEMO_USER_ID);
    }
}
