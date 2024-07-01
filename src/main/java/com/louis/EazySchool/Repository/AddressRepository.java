package com.louis.EazySchool.Repository;

import com.louis.EazySchool.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
