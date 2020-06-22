package com.sauzny.jkitchen_note.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TempTest001 {

    public static int t001(){
        User user = new User();
        for(int i=0; i<4; i++){
            final int index = i;
            new Thread(() -> {
                //System.out.println(index);
                user.setId(index);
            }).start();
        }
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
        return user.getId();
    }


    static class User {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            System.out.println(TempTest001.t001());
        }
    }
}
