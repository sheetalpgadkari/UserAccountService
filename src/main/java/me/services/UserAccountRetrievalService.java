package me.services;

import me.vo.UserAccountDetail;

import java.util.List;

public interface UserAccountRetrievalService
{
    List<UserAccountDetail> list(Long userId);
}
