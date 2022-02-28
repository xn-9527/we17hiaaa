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
    private static final long serialVersionUID = 5022216933728690952L;

    private Long id;
    private Long highArticleId;
    private Long highTagId;
}
