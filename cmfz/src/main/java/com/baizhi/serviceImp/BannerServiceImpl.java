package com.baizhi.serviceImp;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Banner> findAll() {
        List<Banner> all = bannerMapper.findAll();
        return all;
    }

    @Override
    public String add(Banner banner) {
        String s = UUID.randomUUID().toString();
        banner.setId(s);
        banner.setCreateDate(new Date());
        bannerMapper.add(banner);
        return s;
    }

    @Override
    public void updateUrl(Banner banner) {
        bannerMapper.updateUrl(banner);
    }

    @Override
    public void updateStatus(Banner banner) {
        bannerMapper.updateStatus(banner);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        //获取数据库中的起始条
        Integer start = (page - 1) * rows;
        //查询出轮播图列表
        List<Banner> list = bannerMapper.findByPage(start, rows);
        //查询出总条数
        Integer records = bannerMapper.count();
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
    public void del(String[] id) {
        bannerMapper.del(id);
    }


    @Override
    public List<Banner> outAll(HttpServletResponse response) throws IOException {
        List<Banner> banners = bannerMapper.outAll();

        for (Banner banner : banners) {
            String imgPath = banner.getImgPath();
            imgPath = "G:/框架/cmfz/src/main/webapp/img/" + imgPath;
            banner.setImgPath(imgPath);
            System.out.println(imgPath);
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("轮播图信息", "图片"),
                Banner.class, banners);

        String encode = URLEncoder.encode("轮播图信息.xls", "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + encode);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);

        return null;
    }


}
