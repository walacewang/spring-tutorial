package com.adeking.kix;

import com.adeking.kix.mapper.ArticleMapper;
import com.adeking.kix.pojo.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class ArticleMapperIntegrationTest {

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void sampleTest01() {
        Article newOne = new Article();
        newOne.setId(1L);
        newOne.setTitle("Greate little boy.");
        newOne.setAuthor("kalphix");

        int insertArticle = articleMapper.insertArticle(newOne);
        Assertions.assertEquals(1L, insertArticle);

    }

    @Test
    public void sampleTest02() {
        Article article = articleMapper.getArticle(1L);

        Assertions.assertNotNull(article);
        Assertions.assertEquals(1L, article.getId().longValue());
        Assertions.assertEquals("kalphix", article.getAuthor());
        Assertions.assertEquals("Greate little boy.", article.getTitle());

    }
}
