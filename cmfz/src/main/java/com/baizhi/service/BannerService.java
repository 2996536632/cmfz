package com.baizhi.service;

import com.baizhi.entity.Banner;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BannerService {
    //查询所有
    List<Banner> findAll();

    //添加
    String add(Banner banner);

    //修改
    void updateUrl(Banner banner);

    void updateStatus(Banner banner);

    //通过页号查询
    Map<String, Object> findByPage(Integer page, Integer rows);

    //删除
    void del(String[] id);

    //导出
    List<Banner> outAll(HttpServletResponse response) throws IOException;
}
