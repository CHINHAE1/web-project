package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.entity.News;
import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.service.NewsService;
import com.wn.carrentalplatform.util.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wn.carrentalplatform.model.vo.NewsVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 11:23
 * @version: 1.0
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("queryAllNews")
    @ResponseBody
    public DataGridView queryAllNews(NewsVo newsVo) {
        return newsService.queryAllNews(newsVo);
    }

    /**
     * 根据id查询新闻
     */
    @RequestMapping("findNewsById")
    @ResponseBody
    public News queryNewsById(Integer id) {
        return newsService.findNewsById(id);
    }

    /**
     * 添加一条公告
     */
    @RequestMapping("addNews")
    @ResponseBody
    public ResultObj addNews(NewsVo newsVo) {
        try {
            newsVo.setCreatetime(new Date());
            User user = (User) WebUtils.getHttpSession().getAttribute("user");
            newsVo.setOperername(user.getRealname());
            newsService.addSelective(newsVo);
            return ResultObj.ADD_SUCCESS;
        } catch (RuntimeException e) {
            return ResultObj.ADD_ERROR;
        }
    }
}
