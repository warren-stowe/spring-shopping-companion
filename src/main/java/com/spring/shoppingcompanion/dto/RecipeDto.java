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
    private int sourcePage;

    @Column(name = "webpage")
    @Nullable
    private String webPage;

    public RecipeDto() {}

    public RecipeDto(String recipeName, String source, int sourcePage, String webpage) {
        this.recipeName = recipeName;
        this.source = source;
        this.sourcePage = sourcePage;
        this.webPage = webpage;
    }

    @Override
    public String toString() {
        return "RecipeDto{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", source='" + source + '\'' +
                ", sourcePage=" + sourcePage +
                ", webPage='" + webPage + '\'' +
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

    public int getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(int sourcePage) {
        this.sourcePage = sourcePage;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
}
