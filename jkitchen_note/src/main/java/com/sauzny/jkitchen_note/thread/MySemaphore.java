package com.sauzny.jkitchen_note.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/***************************************************************************
 * <pre></pre>
 * @文件名称:  MySemaphore.java
 * @包   路   径：  cn.org.ljx.th
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述: 
 * @版本: V1.0
 * @创建人： liujinxin
 * @创建时间：2013-12-12 下午2:17:20
 *
 *
 *
 * @修改记录：
   -----------------------------------------------------------------------------------------------
             时间                      |       修改人            |         修改的方法                       |         修改描述                                                                
   -----------------------------------------------------------------------------------------------
                 |                 |                           |                                       
   ----------------------------------------------------------------------------------------------- 	
 
 一个计数信号量。从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。
 每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。
 但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。
 ***************************************************************************/
public class MySemaphore extends Thread {
	Semaphore position;
	private int id;

	public MySemaphore(int i, Semaphore s) {
		this.id = i;
		this.position = s;
	}

	public void run() {
		try {
			if (position.availablePermits() > 0) {
				System.out.println("顾客[" + this.id + "]进入厕所，有空位");
			} else {
				System.out.println("顾客[" + this.id + "]进入厕所，没空位，排队");
			}
			position.acquire();
			System.out.println("顾客[" + this.id + "]获得坑位");
			Thread.sleep((int) (Math.random() * 10000));
			System.out.println("顾客[" + this.id + "]使用完毕");
			position.release();
			System.out.println("------当前有["+position.availablePermits()+"]个空位-------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void last(Semaphore position){
		position.acquireUninterruptibly(2);
		if(position.getQueueLength() == 0){
			System.out.println("使用完毕，需要清扫了");
			position.release(2);
		} else {
			System.out.println("偶发性的出现了2个坑位");
			position.release(2);
			last(position);
		}
	}
	
	
	public static void main(String args[]) {
		ExecutorService list = Executors.newCachedThreadPool();
		Semaphore position = new Semaphore(2);
		for (int i = 0; i < 10; i++) {
			list.submit(new MySemaphore(i + 1, position));
		}
		list.shutdown();
		System.out.println("提交完毕");
		MySemaphore.last(position);
	}
}
