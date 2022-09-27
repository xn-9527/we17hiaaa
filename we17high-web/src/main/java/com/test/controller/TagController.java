package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.test.domain.Tag;
import com.test.domain.common.AjaxResult;
import com.test.domain.common.Constants;
import com.test.domain.common.PageRequest;
import com.test.service.TagService;
import com.test.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author a
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value = {"/api/v1/tags"})
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 分页查询文章
     *
     * @param pageRequest
     * @return
     */
    @RequestMapping(value = {"/page"}, method = RequestMethod.GET)
    @ResponseBody
    private AjaxResult pageStation(PageRequest pageRequest) {
        try {
            Tag domain = null;
            if (StringUtils.isNotBlank(pageRequest.getQueryObj())) {
                domain = JSON.parseObject(pageRequest.getQueryObj(), Tag.class);
            }
            //兜底翻页信息
            if (pageRequest.getPage() > Constants.MAX_PAGE_NO) {
                pageRequest.setPage(Constants.MAX_PAGE_NO);
            }
            if (pageRequest.getPageSize() > Constants.MAX_PAGE_SIZE) {
                pageRequest.setPageSize(Constants.MAX_PAGE_SIZE);
            }
            List<Tag> listP = tagService.listPage(pageRequest.getPage(), pageRequest.getPageSize(), domain);

            PageInfo<Tag> pageList = new PageInfo<Tag>(listP);
            return AjaxResult.success(pageList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AjaxResult.failed("error, please wait for a moment");
        }
    }
}