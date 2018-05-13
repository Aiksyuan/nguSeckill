package com.nnngu.dao;

import com.nnngu.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by @nnngu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class SeckillMapperTest {
    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void reduceNumber() throws Exception {
        long seckillId = 1000;
        Date date = new Date();
        int i = seckillMapper.reduceNumber(seckillId, date);
        System.out.println(i);
    }

    @Test
    public void queryById() throws Exception {
        long seckillId = 4;
        Seckill seckill = seckillMapper.queryById(seckillId);
        System.out.print(seckill.toString());
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillMapper.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.print(seckill.toString());
        }
    }

    @Test
    public void updateById() {
        Seckill record = seckillMapper.queryById(5L);
        record.setName("大白菜");
        Integer integer = seckillMapper.updateById(record);
        System.out.println(integer);
    }

    @Test
    public void saveSeckill() {
        Seckill record = new Seckill();
        record.setName("小白菜");
        record.setNumber(10);
        record.setStartTime(new Date());
        record.setEndTime(new Date());
        record.setCreateTime(new Date());
        Integer integer = seckillMapper.saveSeckill(record);
        System.out.println(integer);
    }
}