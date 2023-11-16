package com.example.repository;

import com.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    Account findByUsername(String username);

    Object findByPassport(String passport);
}
