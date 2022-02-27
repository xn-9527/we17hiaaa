package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.test.domain.Article;
import com.test.domain.common.AjaxResult;
import com.test.domain.common.PageRequest;
import com.test.service.ArticleService;
import com.test.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author a
 */
@RestController
@Slf4j
@RequestMapping(value = {"/articles"})
public class ArticleController {

    @Autowired
    private ArticleService articleService;

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
            Article domain = null;
            if (StringUtils.isNotBlank(pageRequest.getQueryObj())) {
                domain = JSON.parseObject(pageRequest.getQueryObj(), Article.class);
                domain.setArticleOrinUrl(null);
                domain.setMainContext(null);
            }
            if (pageRequest.getPage() > 10000) {
                pageRequest.setPage(10000);
            }
            if (pageRequest.getPageSize() > 20) {
                pageRequest.setPageSize(20);
            }
            List<Article> listP = articleService.listPage(pageRequest.getPage(), pageRequest.getPageSize(), domain);

            PageInfo<Article> pageList = new PageInfo<Article>(listP);
            return AjaxResult.success(pageList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AjaxResult.failed("error, please wait for a moment");
        }
    }
}