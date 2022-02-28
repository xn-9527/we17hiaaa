package com.test.service.impl;

import com.test.dao.TagDao;
import com.test.domain.Tag;
import com.test.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author a
 */
@Service
@Slf4j
public class TagServiceImpl extends BaseServiceImpl<Tag> implements TagService {
    @Autowired
    private TagDao myMapper;
}
