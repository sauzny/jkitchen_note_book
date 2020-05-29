package com.sauzny.jkitchen_note.thread;

import com.google.common.collect.Lists;
import com.sauzny.jkitchen_note.threadex.MyUnchecckedExceptionhandler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/***************************************************************************
 * <pre></pre>
 * @文件名称:  MyExecutor.java
 * @包   路   径：  cn.org.ljx.th
 * @版权所有: Personal liujinxin (C) 2016
 *
 * @类描述: 
 * @版本: V1.0
 * @创建人： liujinxin
 * @创建时间：2013-12-12 上午11:42:37
 *
 *
 *
 * @修改记录：
   -----------------------------------------------------------------------------------------------
             时间                      |       修改人            |         修改的方法                       |         修改描述                                                                
   -----------------------------------------------------------------------------------------------
                 |                 |                           |                                       
   ----------------------------------------------------------------------------------------------- 	
 
 newFixedThreadPool（固定大小线程池）
创建一个可重用固定线程集合的线程池，以共享的无界队列方式来运行这些线程（只有要请求的过来，就会在一个队列里等待执行）。如果在关闭前的执行期间由于失败而导致任何线程终止，那么一个新线程将代替它执行后续的任务（如果需要）。

newCachedThreadPool（无界线程池，可以进行自动线程回收）
创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。调用 execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。因此，长时间保持空闲的线程池不会使用任何资源。注意，可以使用 ThreadPoolExecutor 构造方法创建具有类似属性但细节不同（例如超时参数）的线程池。

newSingleThreadExecutor（单个后台线程）
创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。（注意，如果因为在关闭前的执行期间出现失败而终止了此单个线程，那么如果需要，一个新线程将代替它执行后续的任务）。可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。与其他等效的 newFixedThreadPool(1) 不同，可保证无需重新配置此方法所返回的执行程序即可使用其他的线程。

这些方法返回的都是ExecutorService对象，这个对象可以理解为就是一个线程池。
这个线程池的功能还是比较完善的。可以提交任务submit()可以结束线程池shutdown()。
 ***************************************************************************/
public class MyExecutor extends Thread {
	private int index;

	public MyExecutor(int i) {
		this.index = i;
	}

	public void run() {
		try {

			System.out.println(Thread.currentThread().getName() + " [" + this.index + "] start....");
			//Thread.sleep((int) (Math.random() * 10000));
			/*
			Map map=Thread.getAllStackTraces(); //也可以map<Thread, StackTraceElement[]>
			System.out.println("当前线程数："+map.size());
			Iterator it=map.keySet().iterator();
			while (it.hasNext()) {
				Thread t = (Thread) it.next(); //
				System.out.println(t.getName());
			}
			*/

			//Thread.sleep(5000L);
			//LockSupport.parkNanos(5000L);
			while (true){
				LockSupport.parkNanos(1);
				System.out.println("1");
			}

			//System.out.println(Thread.currentThread().getName() + " [" + this.index + "] end.");

		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}

	}

	public static void main(String args[]) throws InterruptedException {
		// 设置默认的线程异常捕获处理器
		//Thread.setDefaultUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());

		//MyExecutor myExecutor100 = new MyExecutor(100);
		///myExecutor100.setName("自定义thread" + 100);
		//myExecutor100.start();

		ExecutorService service = Executors.newFixedThreadPool(4);

/*

		for (int i = 0; i < 3; i++) {
			MyExecutor myExecutor = new MyExecutor(i);
			myExecutor.setName("自定义thread" + i);
			service.execute(myExecutor);
			// service.submit(new MyExecutor(i));
			//System.out.println("------------");
		}
*/

		//MyExecutor myExecutor = new MyExecutor(1);
		//myExecutor.setName("自定义thread" + 1);
		//service.execute(myExecutor);
		//System.out.println("submit finish");
		//service.shutdown();
		//List<Runnable> list = service.shutdownNow();
		//list.forEach(r -> System.out.println(r.toString()));

		List<Future<Integer>> futureList = Lists.newArrayList();

		for(int i=0; i<10; i++){
			final int a = i;
			Future<Integer> future = service.submit(() -> {

				for(int j=0; j<1000; j++){
					if(j < 0){
						System.out.println("j");
					}
				}

				return a;
			});
			futureList.add(future);
		}

		System.out.println("submit shutdown");
		service.shutdownNow();

		while(!service.awaitTermination(3, TimeUnit.SECONDS)){
			System.out.println("service.isTerminated() = " + service.isTerminated());
		}

		System.out.println("service.isTerminated() = " + service.isTerminated());

		futureList.forEach(future -> {
			/*
			while(!future.isDone()){
				System.out.println("future.isCancelled() = " + future.isCancelled());
			}
			*/
			System.out.println("future.isDone() = " + future.isDone());
			System.out.println("future.isCancelled() = " + future.isCancelled());

			try {

				int a = future.get();
				System.out.println("future.get() = " + a);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
}
