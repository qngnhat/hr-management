package com.jesse.training.spring.service;

import com.jesse.training.spring.entity.Account;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AccountLogic {

  public List<Account> findAll() {
    return null;
  }

  public Account getAccount(String loginId) {
    return null;
  }

  public Account saveAccount(Account acc) {
    return null;
  }

  public int deleteAccountLoginById(String loginId) {
    return 0;
  }
}
