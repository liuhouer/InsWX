package com.inspinia.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.inspinia.entity.Health;

@Mapper
public interface HealthMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table np_health
     *
     * @mbggenerated Thu Jul 19 15:45:13 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table np_health
     *
     * @mbggenerated Thu Jul 19 15:45:13 CST 2018
     */
    int insert(Health record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table np_health
     *
     * @mbggenerated Thu Jul 19 15:45:13 CST 2018
     */
    Health selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table np_health
     *
     * @mbggenerated Thu Jul 19 15:45:13 CST 2018
     */
    List<Health> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table np_health
     *
     * @mbggenerated Thu Jul 19 15:45:13 CST 2018
     */
    int updateByPrimaryKey(Health record);
}