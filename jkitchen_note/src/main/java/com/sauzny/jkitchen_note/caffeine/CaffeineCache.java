package com.sauzny.jkitchen_note.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

/**
 * *************************************************************************
 * @文件名称: CaffeineCache.java
 *
 * @包路径  : com.sauzny.jkitchen_note.caffeine 
 *				 
 * @版权所有: Personal xinxin (C) 2017
 *
 * @类描述:   缓存框架 Caffeine 性能优于 CurrentHashMap 和 guava cache
 * 
 * @创建人:   ljx 
 *
 * @创建时间: 2017年10月13日 - 上午9:17:46 
 *	
 **************************************************************************
 */
public class CaffeineCache {

    public void foo01(){
        /*
                             然后Caffeine的API的操作功能和Guava是基本保持一致的，
                             并且Caffeine为了兼容之前是Guava的用户，
                             做了一个Guava的Adapter给大家使用也是十分的贴心。 
         */
        /*
        LoadingCache<Key, Graph> graphs = Caffeine<K, V>.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .build(key -> createExpensiveGraph(key));
        */
    }
}
