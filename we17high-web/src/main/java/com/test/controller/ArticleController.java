package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.test.domain.Article;
import com.test.domain.ArticleTagRelation;
import com.test.domain.Tag;
import com.test.domain.common.AjaxResult;
import com.test.domain.common.Constants;
import com.test.domain.common.PageRequest;
import com.test.domain.request.ArticleRequest;
import com.test.service.ArticleService;
import com.test.service.ArticleTagRelationService;
import com.test.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author a
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value = {"/api/v1/articles"})
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private ArticleTagRelationService articleTagRelationService;

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
            Tag tag = null;
            if (StringUtils.isNotBlank(pageRequest.getQueryObj())) {
                ArticleRequest articleRequest = JSON.parseObject(pageRequest.getQueryObj(), ArticleRequest.class);
                domain = articleRequest.getArticle();
                if (domain != null) {
                    domain.setArticleOrinUrl(null);
                    domain.setMainContext(null);
                }
                tag = articleRequest.getTag();
            }
            //兜底翻页信息
            if (pageRequest.getPage() > Constants.MAX_PAGE_NO) {
                pageRequest.setPage(Constants.MAX_PAGE_NO);
            }
            if (pageRequest.getPageSize() > Constants.MAX_PAGE_SIZE) {
                pageRequest.setPageSize(Constants.MAX_PAGE_SIZE);
            }
            List<Article> listP = null;
            if (tag == null) {
                //未传tag，以domain优先查询
                listP = articleService.listPage(pageRequest.getPage(), pageRequest.getPageSize(), domain);
            } else {
                //传了tag，以tag优先查
                ArticleTagRelation articleTagRelation = new ArticleTagRelation();
                articleTagRelation.setHighTagId(tag.getId());
                List<ArticleTagRelation> articleTagRelations = articleTagRelationService.listPage(pageRequest.getPage(), pageRequest.getPageSize(), articleTagRelation);
                if (!CollectionUtils.isEmpty(articleTagRelations)) {
                    List<Long> articleIds = articleTagRelations.stream().map(ArticleTagRelation::getHighArticleId).collect(Collectors.toList());
                    listP = articleService.listByIds(articleIds);
                }
            }

            PageInfo<Article> pageList = new PageInfo<Article>(listP);
            return AjaxResult.success(pageList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return AjaxResult.failed("error, please wait for a moment");
        }
    }
}