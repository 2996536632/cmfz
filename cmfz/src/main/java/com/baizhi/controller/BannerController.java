package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("findAll")
    public Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> map = bannerService.findByPage(page, rows);
        return map;
    }

    /* @RequestMapping("/edit")
     public void edit(Banner banner,String oper){
         if(oper.equals("add")){
             banner.setId(UUID.randomUUID().toString());
             bannerService.save(banner);
         }else if(oper.equals("del")){

         }else{
             bannerService.uadate(banner);
         }
     }*/
    @RequestMapping("edit")
    public String edit(Banner banner, String oper, String[] id) {
        if (oper.equals("add")) {
            String s = bannerService.add(banner);
            return s;
        }
        if ("edit".equals(oper)) {
            bannerService.updateStatus(banner);
        }
        if ("del".equals(oper)) {
            bannerService.del(id);
        }
        return null;
    }

    //上传
    @RequestMapping("upload")
    public void upload(MultipartFile imgPath, String bannerId, HttpSession session) {
        //获取图片存储的位置
        String realPath = session.getServletContext().getRealPath("/img");

        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = imgPath.getOriginalFilename();
        String newFileName = new Date().getTime() + "_" + originalFilename;

        try {
            imgPath.transferTo(new File(realPath, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //修改图片的路径
        Banner banner = new Banner();
        banner.setImgPath(newFileName);
        banner.setId(bannerId);
        bannerService.updateUrl(banner);
    }

    @RequestMapping("out")
    public void out(HttpServletResponse response) throws IOException {
        List<Banner> banners = bannerService.outAll(response);


    }

}
