package com.test.domain;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author a
 */
@Table(name = "high_article_tag")
@Data
public class ArticleTagRelation implements Serializable {
    private long id;
    private long highArticleId;
    private String highTagId;
}
