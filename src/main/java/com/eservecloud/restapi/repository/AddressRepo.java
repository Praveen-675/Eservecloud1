package com.eservecloud.restapi.repository;

import com.eservecloud.restapi.model.Address;
import com.eservecloud.restapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
