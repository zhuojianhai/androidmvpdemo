package com.xiangxue.ch1.safeend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 *类说明：抛出InterruptedException异常的时候，要注意中断标志位
 * 标志位会被重置为false
 */
public class HasInterrputException1 {



	private static SimpleDateFormat formater
		= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SSS");
	
	private static class UseThread extends Thread{
		private  volatile boolean isRunning = true;

		public boolean isRunning() {
			return isRunning;
		}

		public void setRunning(boolean running) {
			isRunning = running;
		}
		public UseThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			while(isRunning ||!isInterrupted()) {
				try {
					System.out.println("UseThread:"+formater.format(new Date()));
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					System.out.println(threadName+" catch interrput flag is "
							+isInterrupted()+ " at "
							+(formater.format(new Date())));
					//方法跑出异常后，线程中断的标示会重置为false，如果想要中断线程
					//必须手动在调用interrupt()
					interrupt();
					e.printStackTrace();
				}
				System.out.println(threadName);				
			}
			System.out.println(threadName+" interrput flag is "
					+isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("HasInterrputEx");
		endThread.start();
		System.out.println("Main:"+formater.format(new Date()));
		Thread.sleep(800);
		System.out.println("Main begin interrupt thread:"+formater.format(new Date()));
		endThread.interrupt();
		

	}

}
