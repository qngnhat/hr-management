package com.jesse.training.spring.service;

import com.jesse.training.spring.entity.AccountGroup;
import com.jesse.training.spring.entity.AccountMembership;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountGroupLogic {

  public List<AccountGroup> findAll() {
    return null;
  }

  public AccountGroup getAccountGroupByPath(String path) {
    return null;
  }

  public AccountGroup saveAccountGroup(AccountGroup gr) {
    return null;
  }

  public int deleteAccountGroupByPath(String path) {
    return 0;
  }

  public AccountMembership createAccountMembership(AccountMembership relation) {
    return null;
  }

  public int deleteAccountMembershipByLoginId(String loginId) {
    return 0;
  }
}
