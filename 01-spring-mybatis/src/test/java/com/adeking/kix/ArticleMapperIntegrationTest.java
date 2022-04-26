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
    public void sampleTest() {
        Article article = articleMapper.getArticle(1L);

        Assertions.assertNotNull(article);
        Assertions.assertEquals(1L, article.getId().longValue());
        Assertions.assertEquals("Baeldung", article.getAuthor());
        Assertions.assertEquals("Working with MyBatis in Spring", article.getTitle());
    }
}

