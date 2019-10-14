package com.baizhi.mapper;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    List<Album> queryAll(@Param("begin") Integer begin, @Param("rows") Integer rows);

    Integer count();

    void add(Album album);

    void updateUrl(Album album);

    void updateStatus(Album album);

    void updateCount(Album album);
}
