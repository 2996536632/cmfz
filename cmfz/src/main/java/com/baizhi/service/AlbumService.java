package com.baizhi.service;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AlbumService {
    Map<String, Object> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);

    String add(Album album);

    void updateUrl(Album album);

    void updateStatus(Album album);
}
