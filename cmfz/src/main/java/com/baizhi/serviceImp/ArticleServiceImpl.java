package com.baizhi.serviceImp;

import com.baizhi.entity.Article;
import com.baizhi.mapper.ArticleMapper;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        //获取数据库中的起始条
        Integer start = (page - 1) * rows;
        //查询出轮播图列表
        List<Article> list = articleMapper.findAll(start, rows);
        //查询出总条数
        Integer records = articleMapper.count();
        //总页数
        Integer total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("total", total);
        map.put("records", records);
        map.put("page", page);
        map.put("rows", list);
        //总页数  total
        //当前页  page
        //录播图列表 rows
        //总条数   records

        return map;
    }

    @Override
    public void add(Article article) {
        String s = UUID.randomUUID().toString();
        article.setId(s);
        article.setCreateDate(new Date());
        articleMapper.add(article);
    }

    @Override
    public void update(Article article) {
        articleMapper.update(article);
    }
}
