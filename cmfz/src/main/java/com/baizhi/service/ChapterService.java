package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.Map;

public interface ChapterService {
    public Map<String, Object> queryAll(Integer page, Integer rows, String id);

    public String add(Chapter chapter);

    public void updateUrl(Chapter chapter);

    public void del(String[] id);
}
