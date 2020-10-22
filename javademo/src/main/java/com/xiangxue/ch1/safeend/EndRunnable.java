package com.xiangxue.ch1.safeend;

/**
 *
 *
 *类说明：中断Runnable类型的线程
 */
public class EndRunnable {
	
	private static class UseRunnable implements Runnable{
		
		@Override
		public void run() {

			try {
				String threadName = Thread.currentThread().getName();
				boolean isInterrupt = Thread.currentThread().isInterrupted();

				while(!Thread.currentThread().isInterrupted()) {
					System.out.println(threadName+" is run!");

				}
				System.out.println(threadName+" interrput flag is "
						+Thread.currentThread().isInterrupted());
			}catch (Exception e){
				System.out.println(Thread.currentThread().getName()+" interrput flag is "
						+Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}

		}			
	}

	public static void main(String[] args) throws InterruptedException {
		UseRunnable useRunnable = new UseRunnable();
		Thread endThread = new Thread(useRunnable,"endThread");
		endThread.start();
		Thread.sleep(2000);
		endThread.interrupt();
	}

}
