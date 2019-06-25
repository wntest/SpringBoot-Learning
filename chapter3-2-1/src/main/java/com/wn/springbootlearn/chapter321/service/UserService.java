package com.wn.springbootlearn.chapter321.service;

public interface UserService {

    /**
     * 新增一个客户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     * @return
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
