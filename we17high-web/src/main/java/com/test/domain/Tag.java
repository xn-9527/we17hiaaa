package com.test.domain;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author a
 */
@Table(name = "high_tag")
@Data
public class Tag implements Serializable {
    private long id;
    private int tagType;
    private String tagName;
}
