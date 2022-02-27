package com.test.domain;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author a
 */
@Data
@Table(name = "high_article")
public class Article implements Serializable {
    private long id;
    private String authorName;
    private String articleName;
    private String articleOrinUrl;
    private long createTime;
    private String mainContext;
}
