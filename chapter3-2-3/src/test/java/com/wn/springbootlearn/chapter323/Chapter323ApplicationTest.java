package com.wn.springbootlearn.chapter323;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Chapter323ApplicationTest {

    @Autowired
    @Qualifier("wnJdbcTemplate")
    protected JdbcTemplate wnJdbcTemplate;

    @Autowired
    @Qualifier("wwnJdbcTemplate")
    protected JdbcTemplate wwnJdbcTemplate;

    @Before
    public void setUp() {
        wnJdbcTemplate.update("delete from wn_test");
        wwnJdbcTemplate.update("delete from wn_test");
    }

    @Test
    public void test1() {
        // 在第一个数据源中插入两条数据
        wnJdbcTemplate.update("insert into wn_test(id, name, age, sex) values('1', 'zs', 20, 1)");
        wnJdbcTemplate.update("insert into wn_test(id, name, age, sex) values('2', 'lisi', 20, 1)");

        // 在第二个数据源中插入一条数据
        wwnJdbcTemplate.update("insert into wn_test(id, name, age, sex) values('3', 'zhangsan', 20, 1)");

        // 查询表格wn_test是否有3条数据
        Assert.assertEquals("3", wnJdbcTemplate.queryForObject("select count(1) from wn_test", String.class));

        // 查询表格wn_test是否有3条数据
        Assert.assertEquals("3", wwnJdbcTemplate.queryForObject("select count(1) from wn_test", String.class));
    }

}