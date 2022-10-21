package com.spring.shoppingcompanion.dao;

import com.spring.shoppingcompanion.dto.RecipeIngredientDto;
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

//    @Query("select id from recipes_ingredients where recipeId = :recipeId")
//    public List<BigInteger> findAllIdsByRecipeId(@Param("recipeId") BigInteger recipeId);
}
