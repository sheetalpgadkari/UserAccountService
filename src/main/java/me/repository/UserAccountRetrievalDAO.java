package me.repository;

import me.vo.UserAccountDetail;

import java.util.List;

public interface UserAccountRetrievalDAO
{
    List<UserAccountDetail> getUserAccount(Long userId);
}
