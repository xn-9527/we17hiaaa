package com.test.dao;

import com.test.utils.MyMapper;
import com.test.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author a
 */
public interface ArticleDao extends MyMapper<Article> {
    /**
     * list
     *
     * @param ids
     * @return
     */
    List<Article> listByIds(@Param("ids")List<Long> ids);
}
