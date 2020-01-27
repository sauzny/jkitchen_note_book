package com.sauzny.jkitchen_note.algorithm;

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
