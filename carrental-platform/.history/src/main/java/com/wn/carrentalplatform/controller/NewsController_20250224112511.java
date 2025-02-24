package com.wn.carrentalplatform.controller;

import org.springframework.stereotype.Controller;

import com.wn.carrentalplatform.model.vo.NewsVo;

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
}
