package com.wn.carrentalplatform.service;

import com.wn.carrentalplatform.model.entity.News;
import com.wn.carrentalplatform.model.vo.NewsVo;
import com.wn.carrentalplatform.util.DataGridView;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 11:22
 * @version: 1.0
 */
public interface NewsService {

    /**
     * 根据条件查询所有新闻
     */
    DataGridView queryAllNews(NewsVo newsVo);

    /**
     * 根据id查询新闻
     */
    News findNewsById(Integer id);

    /**
     * 添加一条公告
     */
    int addSelective(NewsVo newsVo);

    /**
     * 根据id修改公告
     */
    int updateNewsById(NewsVo newsVo);

    /**
     * 根据id删除公告
     */
    int deleteNewsById(Integer id);

    /**
     * 批量删除公告
     */
    void deleteBatchNewsByIds(Integer[] ids);
}
