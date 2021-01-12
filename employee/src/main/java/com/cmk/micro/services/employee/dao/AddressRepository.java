package com.cmk.micro.services.employee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cmk.micro.services.employee.dao.model.Address;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
