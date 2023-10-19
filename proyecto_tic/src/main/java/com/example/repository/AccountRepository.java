package com.example.repository;

import com.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
}
@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
}
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
@Repository
public interface AirportEmployeeRepository extends JpaRepository<AirportEmployee, Long> {
}
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
