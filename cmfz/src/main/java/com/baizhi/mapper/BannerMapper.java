package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    //查所有
    List<Banner> findAll();

    //通过页号查询
    List<Banner> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查总条数
    Integer count();

    //修改
    void updateUrl(Banner banner);

    void updateStatus(Banner banner);

    //添加
    void add(Banner banner);

    //删除
    void del(String[] id);

    //导出
    List<Banner> outAll();
}
