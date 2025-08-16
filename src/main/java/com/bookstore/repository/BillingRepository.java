package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Customer;

@Repository
public interface BillingRepository extends CrudRepository<Customer, Long> {

}
