package com.test.domain.request;

import com.test.domain.Article;
import com.test.domain.Tag;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 聚合查询请求
 * @author a
 */
@Data
public class ArticleRequest implements Serializable {
    private static final long serialVersionUID = 2317498377577417268L;

    private Article article;
    private Tag tag;
}
