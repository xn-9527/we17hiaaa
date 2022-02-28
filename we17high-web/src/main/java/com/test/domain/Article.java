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
    private static final long serialVersionUID = -4305715424058743729L;

    private Long id;
    private String authorName;
    private String articleName;
    private String articleOrinUrl;
    private Long createTime;
    private String mainContext;
    private Integer isDelete;
}
