package com.test.domain.common;

import lombok.Data;

/**
 * @author a
 */
@Data
public class PageRequest {
	private int page = 1;
	private int pageSize = 10;
    private String queryObj;
}
