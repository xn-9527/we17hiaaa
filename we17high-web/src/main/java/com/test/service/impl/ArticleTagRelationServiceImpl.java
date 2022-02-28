package com.test.service.impl;

import com.test.dao.ArticleTagRelationDao;
import com.test.domain.ArticleTagRelation;
import com.test.service.ArticleTagRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author a
 */
@Service
@Slf4j
public class ArticleTagRelationServiceImpl extends BaseServiceImpl<ArticleTagRelation> implements ArticleTagRelationService {
    @Autowired
    private ArticleTagRelationDao myMapper;
}
