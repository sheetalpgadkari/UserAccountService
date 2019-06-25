package me.repository;

import me.vo.UserAccountDetail;

import java.util.List;

public interface UserAccountDAO
{
    List<UserAccountDetail> getUserAccount(Long userId);
}
