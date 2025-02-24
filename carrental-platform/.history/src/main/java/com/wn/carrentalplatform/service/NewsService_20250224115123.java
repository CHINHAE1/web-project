package com.wn.carrentalplatform.service;

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
}
