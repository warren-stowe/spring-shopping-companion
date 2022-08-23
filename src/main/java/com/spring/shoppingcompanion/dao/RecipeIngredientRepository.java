package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientDto, BigInteger>,
        JpaSpecificationExecutor<RecipeIngredientDto> {
}
