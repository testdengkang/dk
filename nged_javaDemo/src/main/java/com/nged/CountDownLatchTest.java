/*
 * Copyright (c) 2016, 2025, HHLY and/or its affiliates. All rights reserved.
 * HHLY PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.nged;

/**
* @ClassName: CountDownLatchTest
* @Description: CountDownLatch测试类
* @author Yue Chang 
* @date 2018年1月9日 下午12:09:26 
* @since 1.0
*/
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CountDownLatchTest implements Runnable {
	

	private  CountDownLatch latch;




	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		
		String threadName = Thread.currentThread().getName().trim();
		System.out.println(threadName);
		if ("t2".equals(threadName)) { // t2线程
			try {
				Thread.sleep(5000);
				System.out.println("线程0：" + threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown(); // 计数减1
		} else if ("t1".equals(threadName)) { // t1线程
			try {
				System.out.println("线程1：" + threadName + ",start");
				// 阻塞等待计数为0

				while (!latch.await(1000, TimeUnit.MILLISECONDS)){
					System.out.println(latch.toString());
					System.out.println("线程1：" + threadName + "继续阻塞");
				}
				System.out.println("线程1：" + threadName + ",end");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test() {
		System.out.println(Thread.currentThread().getName());

		CountDownLatchTest c = new CountDownLatchTest();
		Thread t2 = new Thread(c);
		t2.setName("t2");
		CountDownLatch latch = new CountDownLatch(1);
		c.setLatch(latch);
		Thread t1 = new Thread(c);
		t1.setName("t1");

		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		;

	}

	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		CountDownLatchTest c = new CountDownLatchTest();
		CountDownLatch latch = new CountDownLatch(1);
		c.setLatch(latch);
		Thread t1 = new Thread(c);
		t1.setName("t1");
		Thread t2 = new Thread(c);
		t2.setName("t2");
		t1.start();
		t2.start();
	}



	
	
}