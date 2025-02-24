package com.wn.carrentalplatform.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 这个类是：
 * @author: CHINHAE
 * @date: 2025/2/24 11:20
 * @version: 1.0
 */
@Mapper
public interface NewsMapper {

    /**
     * 根据条件查询所有新闻
     */
    List<News> queryAllNews(News news);

    /**
     * 根据id查询新闻
     */
    News queryNewsById(Integer id);
}
