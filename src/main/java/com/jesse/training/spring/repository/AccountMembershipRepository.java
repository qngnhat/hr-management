package com.jesse.training.spring.repository;

import com.jesse.training.spring.entity.AccountMembership;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountMembershipRepository extends JpaRepository<AccountMembership, Serializable> {
}
