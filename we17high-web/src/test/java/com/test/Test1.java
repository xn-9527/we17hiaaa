package com.test;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author Chay
 * @date 2022/4/8 0:21
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> ll = JSON.parseObject("[1232144,\"222323s\"]", List.class);
        System.out.println(ll);
    }
}
