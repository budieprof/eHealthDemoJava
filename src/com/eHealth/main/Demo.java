package com.eHealth.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		int val =  get_lcm(8, 16, 9,5);
		System.out.println(val);
		
		Integer[] dt = remove_duplicate(new int[]{1,2,3,3,3,4,4,5});
		System.out.println(join(dt," ,"));
		
		Integer[] rotate = array_rotator(2, new Integer[]{1,2,3,4,5,6}, Integer.class);
		System.out.println(join(rotate," ,"));
		
		String common = find_common_characters("love", "have");
		System.out.println(common);
	}
	
	
	//find_char()
	public static String find_common_characters(String str1, String str2){
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		ArrayList<Character> union = new ArrayList<Character>();
		for (char data: str1CharArray) {
			if(!union.contains(data))
			union.add(data);
		}
		for (char data : str2CharArray) {
			if(!union.contains(data))
				union.add(data);
		}
		StringBuilder sub_set = new StringBuilder();
		for (Character data : union) {
			if(contains_char(str1CharArray,data) && contains_char(str2CharArray, data)){
				sub_set.append(data);
			}
		}
		return sub_set.toString();
	}
	private static boolean contains_char(char[] value, char index){
		for (int i = 0; i < value.length; ++i) {
			if (value[i] == index) {
				return true;
			}
		}
		return false;
	}
	
	public static Integer[] remove_duplicate(int[] value){
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (Integer intVal : value) {
			if(!data.contains(intVal))
				data.add(intVal);
		}
		Integer[] val =  Arrays.copyOf(data.toArray(), data.size(), Integer[].class);
		return val;
	}
	
	public static <T> T[] array_rotator(int degree, T[] value, Class<T> type){
		int size = value.length;
		T[] temp = (T[]) Array.newInstance(type, size);
		degree = degree % size;
		for (int i = 0; i < size; i++) {
			int val = i + size-degree;
			if(val >= size){
				val = val - size;
			}
			temp[i] = value[val];
		}
		return temp;
	}
	private static int get_max(int[] params){
		int max = 0;
		for (int i : params) {
			if(i> max){
				max = i;
			}
		}
		return max;
	}
	private static String join(Object[] value, String c){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < value.length; i++) {
			if(i == 0){
				builder.append(value[i]);
			}else{
				builder.append(c);
				builder.append(value[i].toString());
			}
		}
		return builder.toString();
	}
	private static int get_min(int[] params){
		int min = get_max(params);
		for (int i : params) {
			if(i < min){
				min = i;
			}
		}
		return min;
	}
	private static int get_multiple(int[] params){
		int val = 1;
		for (int i : params) {
			val = val * i;
		}
		return val;
	}
	public static int get_lcm(int... params){
		int multiple = get_multiple(params);
		int min = get_min(params);
		for (int i = min; i <= multiple; i++) {
			boolean isLcm = false;
			for (int j : params) {
				if(i% j == 0){
					isLcm = true;
				}else{
					isLcm = false;
					break;
				}
			}
			if(isLcm){
				return i;
			}
		}
		return multiple;
	}
}
