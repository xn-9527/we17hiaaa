package com.test.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author a
 * 不能放在tkmybatis的包扫描路径，否则会报cast类型错误
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
