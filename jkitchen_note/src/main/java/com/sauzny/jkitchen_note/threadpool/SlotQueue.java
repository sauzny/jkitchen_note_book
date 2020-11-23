package com.sauzny.jkitchen_note.threadpool;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.locks.LockSupport;

public class SlotQueue<E> {

    private Map<Long, E> map = Maps.newHashMap();

    private final String name;
    private final int maxSize;
    private final long parkNanos;
    private final long maxParkNanos;

    private long putedMaxIndex;

    public SlotQueue(String name, int maxSize, long parkNanos, long maxParkNanos) {
        this.name = name;
        this.maxSize = maxSize;
        this.parkNanos = parkNanos;
        this.maxParkNanos = maxParkNanos;
    }

    public void put(long index, E e){

        int mapSize = this.map.size();
        int maxSize = this.maxSize;
        long putedMaxIndex = this.putedMaxIndex;

        // 当前map的长度大于设置的最大值 && 放入map的index 大于等于 map中的最大index
        long times = 0;
        while(mapSize >= maxSize && index >= putedMaxIndex){
            // park
            LockSupport.parkNanos(this.parkNanos);
            times = times + this.parkNanos;

            // 超时
            if(times >= this.maxParkNanos){
                times = 0;
                // TODO
            }

            // 更新值
            mapSize = this.map.size();
            maxSize = this.maxSize;
            putedMaxIndex = this.putedMaxIndex;
        }

        this.map.put(index, e);
        this.putedMaxIndex = Math.max(index, this.putedMaxIndex);
    }

    public E take(long index){

        E e = this.map.get(index);

        long times = 0;
        while(e == null){// park
            LockSupport.parkNanos(this.parkNanos);
            times = times + this.parkNanos;

            // 超时
            if(times >= this.maxParkNanos){
                times = 0;
                // TODO
            }

            // 更新值
            e = this.map.get(index);
        }

        return e;
    }
}
