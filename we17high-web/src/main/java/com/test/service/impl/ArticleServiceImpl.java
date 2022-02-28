package com.test.service.impl;

import com.google.common.base.Preconditions;
import com.test.dao.ArticleDao;
import com.test.domain.Article;
import com.test.domain.common.Constants;
import com.test.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author a
 */
@Service
@Slf4j
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
    @Autowired
    private ArticleDao myMapper;

    @Override
    public List<Article> listByIds(List<Long> ids) {
        Preconditions.checkArgument(!CollectionUtils.isEmpty(ids) && ids.size() < Constants.MAX_PAGE_NO, "list too big");
        return myMapper.listByIds(ids);
    }
}
