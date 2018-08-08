package com.sauzny.jkitchen_note.algorithm;

/**
 * *************************************************************************
 * @文件名称: BubbleTest.java
 *
 * @包路径  : cn.org.ljx.erfenfa 
 *				 
 * @版权所有: xxx888（北京）科技有限公司 (C) 2014
 *
 * @类描述:  
 * 
 * @创建人:   liujinxin  
 *
 * @创建时间: 2014年12月9日 - 下午1:38:24 
 *
 * @修改记录:
   -----------------------------------------------------------------------------------------------
             时间						|		修改人		|		修改的方法		|		修改描述                                                                
   -----------------------------------------------------------------------------------------------
							|					|					|                                       
   ----------------------------------------------------------------------------------------------- 	
 
 **************************************************************************
 */
public class BubbleTest {
	
	/**
	 *  Function:折半查找
	 *  功能说明：
	 *	 使用说明：
	 *  @author  liujinxin  DateTime 2014年12月9日 下午1:39:14
	 *	 返回类型: int    
	 *  @param array
	 *  @param value
	 *  @return
	 */
	public static int binary(int[] array, int value) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (value == array[middle]) {
				return middle;
			}
			if (value > array[middle]) {
				low = middle + 1;
			}
			if (value < array[middle]) {
				high = middle - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int value = binary(a, 6);
		System.out.println(value);
	}
}
