package com.wn.carrentalplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wn.carrentalplatform.mapper.NewsMapper;
import com.wn.carrentalplatform.model.entity.News;
import com.wn.carrentalplatform.model.vo.NewsVo;
import com.wn.carrentalplatform.service.NewsService;
import com.wn.carrentalplatform.util.DataGridView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 11:22
 * @version: 1.0
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {
        // 获取当前页和每页记录数
        Integer page = newsVo.getPage();
        Integer limit = newsVo.getLimit();
        PageHelper.startPage(page, limit);
        News news = new News();
        BeanUtils.copyProperties(newsVo, news);
        List<News> newsList = newsMapper.queryAllNews(news);
        PageInfo info = new PageInfo(newsList);
        return new DataGridView(info.getTotal(), info.getList());
    }

    @Override
    public News findNewsById(Integer id) {
        return newsMapper.findNewsById(id);
    }
}
