package com.spring.shoppingcompanion.dto;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "recipes")
public class RecipeDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "recipeName")
    private String recipeName;

    @Column(name = "source")
    @Nullable
    private String source;

    @Column(name = "sourcePage")
    private String sourcePage;

    public RecipeDto() {}

    public RecipeDto(String recipeName, String source, String sourcePage) {
        this.recipeName = recipeName;
        this.source = source;
        this.sourcePage = sourcePage;
    }

    public RecipeDto(BigInteger id, String recipeName, String source, String sourcePage) {
        this.id = id;
        this.recipeName = recipeName;
        this.source = source;
        this.sourcePage = sourcePage;
    }

    @Override
    public String toString() {
        return "RecipeDto{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", source='" + source + '\'' +
                ", sourcePage=" + sourcePage +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(String sourcePage) {
        this.sourcePage = sourcePage;
    }
}
