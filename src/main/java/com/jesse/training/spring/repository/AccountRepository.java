package com.jesse.training.spring.repository;

import com.jesse.training.spring.entity.Account;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Serializable> {

}
