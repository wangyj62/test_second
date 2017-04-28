package com.wang;

import org.junit.Test;

/**
 * 
 * @Class Name Test2
 * @author wangyingjie
 * @Create 2017年2月13日 
 */
public class Test2 {
	
	public volatile int i = 1;
	
	public int j = 1;
	
	public void testMethod_1(){
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		ThreadPoolExecutor
	}
	
	@Test
	public void testMethod_2(){
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					System.out.println(" j == 1 is true!");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();;
	}

}
