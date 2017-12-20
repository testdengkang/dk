package com.nged.cachedemo.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.nged.cachedemo.guava.model.Match;

import java.util.concurrent.TimeUnit;

public class GuavaTestDemo {
    private final static int SIZE= 100;
    public static void main(String[] args){

        Cache<Integer,Match> matchCache = CacheBuilder.newBuilder().maximumSize(SIZE * 10).expireAfterWrite(30,TimeUnit.MINUTES).build();
        Match m1 = new Match();
        Match m2  = new Match("20171220",11,12);

        matchCache.put(1,m1);
        matchCache.put(2,m2);
        //checkNotNull会检测key value是否为null
        //matchCache.put(3,null);
        System.out.println(matchCache.size());


        Match m3 = matchCache.getIfPresent(2);
        System.out.println(m3.toString());



    }


}
