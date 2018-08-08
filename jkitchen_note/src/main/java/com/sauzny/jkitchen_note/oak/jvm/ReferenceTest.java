package com.sauzny.jkitchen_note.oak.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;


public class ReferenceTest {

	private void assertSame(Object object1, Object object2){
		
	}
	
	private void assertNotNull(Object object){
		
	}
	
	private void assertNull(Object object){
		
	}
	
	private void assertTrue(Object object){
		
	}

	private void assertFalse(Object object){
		
	}
	
	/**
	  * <p>strongReference</p>
	  * @Description:
	  *  StrongReference 是 Java 的默认引用实现,  它会尽可能长时间的存活于 JVM 内， 当没有任何对象指向它时 GC 执行后将会被回收
	 */
	public void strongReference() {
		Object referent = new Object();
		
		/**
		 * 通过赋值创建 StrongReference 
		 */
		Object strongReference = referent;
		
		assertSame(referent, strongReference);
		
		referent = null;
		System.gc();
		
		/**
		 * StrongReference 在 GC 后不会被回收
		 */
		assertNotNull(strongReference);
	}
	
	//---------------------------------------------------------------------------------------------//
	
	/**
	  * <p>weakReference</p>
	  * @Description:
	  * WeakReference， 顾名思义,  是一个弱引用,  当所引用的对象在 JVM 内不再有强引用时, GC 后 weak reference 将会被自动回收
	 */
	public void weakReference() {
		Object referent = new Object();
		WeakReference<Object> weakRerference = new WeakReference<Object>(referent);
	
		assertSame(referent, weakRerference.get());
		
		referent = null;
		System.gc();
		
		/**
		 * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
		 */
		assertNull(weakRerference.get());
	}
	
	/**
	  * <p>weakHashMap</p>
	  * @Description:
	  * WeakHashMap 使用 WeakReference 作为 key， 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
	  * @throws InterruptedException
	 */
	public void weakHashMap() throws InterruptedException {
		Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
		Object key = new Object();
		Object value = new Object();
		weakHashMap.put(key, value);
	
		assertTrue(weakHashMap.containsValue(value));
		
		key = null;
		System.gc();
		
		/**
		 * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
		 */
		Thread.sleep(1000);
		
		/**
		 * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
		 */
		assertFalse(weakHashMap.containsValue(value));
	}
	
	//---------------------------------------------------------------------------------------------//
	
	/**
	  * <p>softReference</p>
	  * @Description:
	  * SoftReference 于 WeakReference 的特性基本一致， 最大的区别在于 SoftReference 会尽可能长的保留引用直到 JVM 内存不足时才会被回收(虚拟机保证), 这一特性使得 SoftReference 非常适合缓存应用
	 */
	public void softReference() {
		Object referent = new Object();
		SoftReference<Object> softRerference = new SoftReference<Object>(referent);
	
		assertNotNull(softRerference.get());
		
		referent = null;
		System.gc();
		
		/**
		 *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
		 */
		assertNotNull(softRerference.get());
	}

	//------------------------------------------------------------------------------------------------//
	
	/**
	  * <p>phantomReferenceAlwaysNull</p>
	  * @Description:
	  * Phantom Reference(幽灵引用) 与 WeakReference 和 SoftReference 有很大的不同,  因为它的 get() 方法永远返回 null, 这也正是它名字的由来
	  * 
	  * 一个永远返回 null 的 reference 要来何用,  请注意构造 PhantomReference 时的第二个参数 ReferenceQueue(事实上 WeakReference & SoftReference 也可以有这个参数)，
		PhantomReference 唯一的用处就是跟踪 referent  何时被 enqueue 到 ReferenceQueue 中.
	 */
	public void phantomReferenceAlwaysNull() {
		Object referent = new Object();
		PhantomReference<Object> phantomReference = new PhantomReference<Object>(referent, new ReferenceQueue<Object>());
		
		/**
		 * phantom reference 的 get 方法永远返回 null 
		 */
		assertNull(phantomReference.get());
	}

	//-----------------------------------------------------------------------------------------//
	
	/**
	  * <p>referenceQueue</p>
	  * @Description:
	  * 当一个 WeakReference 开始返回 null 时， 它所指向的对象已经准备被回收， 这时可以做一些合适的清理工作.   将一个 ReferenceQueue 传给一个 Reference 的构造函数， 当对象被回收时， 虚拟机会自动将这个对象插入到 ReferenceQueue 中， WeakHashMap 就是利用 ReferenceQueue 来清除 key 已经没有强引用的 entries.
	  * @throws InterruptedException
	 */
	public void referenceQueue() throws InterruptedException {
		Object referent = new Object();		
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
		WeakReference<Object> weakReference = new WeakReference<Object>(referent, referenceQueue);
		
		assertFalse(weakReference.isEnqueued());
		Reference<? extends Object> polled = referenceQueue.poll();
		assertNull(polled);
		
		referent = null;
		System.gc();

		assertTrue(weakReference.isEnqueued());
		Reference<? extends Object> removed = referenceQueue.remove();
		assertNotNull(removed);
	}

	/**
	 * PhantomReference  vs WeakReference
	 * PhantomReference  有两个好处， 
	 * 
	 * 其一， 它可以让我们准确地知道对象何时被从内存中删除， 这个特性可以被用于一些特殊的需求中(例如 Distributed GC，  XWork 和 google-guice 中也使用 PhantomReference 做了一些清理性工作). 

		其二， 它可以避免 finalization 带来的一些根本性问题, 上文提到 PhantomReference 的唯一作用就是跟踪 referent 何时被 enqueue 到 ReferenceQueue 中,  但是 WeakReference 也有对应的功能, 两者的区别到底在哪呢 ?
		这就要说到 Object 的 finalize 方法, 此方法将在 gc 执行前被调用, 如果某个对象重载了 finalize 方法并故意在方法内创建本身的强引用,  这将导致这一轮的 GC 无法回收这个对象并有可能
		引起任意次 GC， 最后的结果就是明明 JVM 内有很多 Garbage 却 OutOfMemory， 使用 PhantomReference 就可以避免这个问题， 因为 PhantomReference 是在 finalize 方法执行后回收的，也就意味着此时已经不可能拿到原来的引用,  也就不会出现上述问题,  当然这是一个很极端的例子, 一般不会出现. 
	 */
	
	/**
	 * 一般的应用程序不会涉及到 Reference 编程， 但是了解这些知识会对理解 GC 的工作原理以及性能调优有一定帮助,   在实现一些基础性设施比如缓存时也可能会用到， 希望本文能有所帮助.
	 */
}
