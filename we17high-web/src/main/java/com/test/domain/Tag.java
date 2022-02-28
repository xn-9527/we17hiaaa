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
    private static final long serialVersionUID = -4480782581036014249L;

    private Long id;
    private Integer tagType;
    private String tagName;
}
