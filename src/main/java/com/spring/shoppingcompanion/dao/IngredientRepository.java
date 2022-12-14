package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.IngredientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientDto, BigInteger>,
        JpaSpecificationExecutor<IngredientDto> {

    public List<IngredientDto> findByIngredientNameContainingIgnoreCase(String name);
    public IngredientDto getById(BigInteger id);
}
