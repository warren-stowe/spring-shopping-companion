package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.QuantityDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface QuantityRepository extends JpaRepository<QuantityDto, BigInteger>,
        JpaSpecificationExecutor<QuantityDto> {
}
