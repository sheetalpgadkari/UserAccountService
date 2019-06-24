package me.services;

import me.vo.UserAccountDetail;

import java.util.List;

public interface UserAccountService
{
    List<UserAccountDetail> list(Long userId);
}
