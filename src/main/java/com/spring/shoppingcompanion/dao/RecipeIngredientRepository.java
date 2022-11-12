package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
import com.spring.shoppingcompanion.json.requests.IngredientQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientDto, BigInteger>,
        JpaSpecificationExecutor<RecipeIngredientDto> {

    @Query("select r from RecipeIngredientDto r where r.recipeId in :recipeIds")
    public List<RecipeIngredientDto> findAllIdsByRecipeId(@Param("recipeIds") List<BigInteger> recipeIds);

}
