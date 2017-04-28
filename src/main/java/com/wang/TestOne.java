package com.wang;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 测试类One
 * @Class Name TestOne
 * @author wangyingjie
 * @Create 2016年12月12日
 */
public class TestOne {

	public static void main(String[] args) {
		BigDecimal decimal_1 = new BigDecimal("100");
		BigDecimal decimal_2 = new BigDecimal("4");
		BigDecimal result = decimal_1.divide(decimal_2, 3, BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
		System.out.println("asdf");
	}
	
	@Test
	public void test1(){
		BigDecimal num1 = new BigDecimal("0.0235").setScale(3, BigDecimal.ROUND_HALF_UP);
		System.out.println(num1);
	}
	
	@Test
	public void test2(){
		String doubleStr = Double.toString(0.36);
		BigDecimal num1 = new BigDecimal(doubleStr).setScale(3, BigDecimal.ROUND_HALF_UP);
		System.out.println(num1.toString());
	}

}
