package com.test.service.base;

import java.util.List;

/**
 * @author a
 */
public interface BaseService<T> {

    /**
     *
     * @param entity
     * @return
     */
    int save(T entity);

    int delete(T entity);

    void delete(List<T> entityList);

    int deleteById(Long id);

    int update(T entity);

    int updateSelective(T entity);

    T findById(Long id);

    T findByDomain(T t);

    List<T> listByDomain(T t);

    List<T> listAll();

    List<T> listPage(int page, int pageSize, T t);

}
