package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDto, BigInteger>,
        JpaSpecificationExecutor<RecipeDto> {

    public Optional<List<RecipeDto>> findByRecipeNameContainingIgnoreCase(String recipeName);

}
