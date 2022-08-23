package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDto, BigInteger>,
        JpaSpecificationExecutor<RecipeDto> {

}
