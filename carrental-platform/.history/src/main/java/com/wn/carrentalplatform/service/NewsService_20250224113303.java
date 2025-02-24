package com.wn.carrentalplatform.service;

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
}
