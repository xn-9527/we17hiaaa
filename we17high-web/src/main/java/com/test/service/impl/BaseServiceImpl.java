package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.utils.MyMapper;
import com.test.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected MyMapper<T> myMapper;

    @Override
    public int save(T entity) {
        return myMapper.insert(entity);
    }

    @Override
    public int delete(T entity) {
        return myMapper.delete(entity);
    }

    @Override
    public void delete(List<T> entityList){
        for(T entity : entityList){
            delete(entity);
        }
    }

    @Override
    public int deleteById(Long id){
        return myMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(T entity) {
        return myMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateSelective(T entity) {
        return myMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public T findById(Long id) {
        return myMapper.selectByPrimaryKey(id);
    }

    @Override
    public T findByDomain(T t) {
        return myMapper.selectOne(t);
    }

    @Override
    public List<T> listByDomain(T t) {
        return myMapper.select(t);
    }

    @Override
    public List<T> listAll() {
        return myMapper.selectAll();
    }

    @Override
    public List<T> listPage(int page, int pageSize, T t) {
        PageHelper.startPage(page, pageSize);
        return myMapper.select(t);
    }
}
