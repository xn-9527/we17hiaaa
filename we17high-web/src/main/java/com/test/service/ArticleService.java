package com.test.service;

import com.test.domain.Article;
import com.test.service.base.BaseService;

import java.util.List;

/**
 * @author a
 */
public interface ArticleService extends BaseService<Article> {
    /**
     * 列表查询
     *
     * @param ids
     * @return
     */
    List<Article> listByIds(List<Long> ids);
}