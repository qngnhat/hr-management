package com.jesse.training.spring.repository;

import com.jesse.training.spring.entity.AccountGroup;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountGroupRepository extends JpaRepository<AccountGroup, Serializable> {

}
