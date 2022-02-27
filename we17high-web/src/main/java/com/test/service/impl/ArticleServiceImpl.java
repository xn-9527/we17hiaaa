package com.test.service.impl;

import com.test.dao.ArticleDao;
import com.test.domain.Article;
import com.test.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author a
 */
@Service
@Slf4j
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
    @Autowired
    private ArticleDao myMapper;
}
