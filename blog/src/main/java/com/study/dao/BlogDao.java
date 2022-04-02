package com.study.dao;

import com.study.pojo.Blog;
import com.study.pojo.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {

    Blog getBlog(Long id);  //后台展示

    Blog getDetailedBlog(@Param("id") Long id);  //详情

    List<Blog> getAllBlog();

    List<Blog> getByTypeId(Long typeId);  //根据类型id获取

    List<Blog> getByTagId(Long tagId);  //根据标签id获取

    List<Blog> getIndexBlog();  //主页展示

    List<Blog> getAllRecommendBlog();  //推荐展示

    List<Blog> getSearchBlog(String query);  //全局搜索

    List<Blog> searchAllBlog(Blog blog);  //后台根据标题、分类、推荐搜索

    List<String> findGroupYear();  //查询所有年份，返回一个集合

    List<Blog> findByYear(@Param("year") String year);  //按年份查询

    int saveBlog(Blog blog);

    int saveBlogAndTag(BlogAndTag blogAndTag);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

}
