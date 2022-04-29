package com.adeking.kix.mapper;

import com.adeking.kix.pojo.Article;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ArticleMapper {
    @Select("SELECT * FROM ARTICLES WHERE id = #{id}")
    Article getArticle(@Param("id") Long id);

    @Insert("insert into ARTICLES (id, title, author) values (#{article.id}, #{article.title}, #{article.author})")
    int insertArticle(@Param("article") Article article);
}
