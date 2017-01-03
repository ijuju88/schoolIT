package com.Threadtest;

public class Wait_NotifyTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBox databox = new DataBox();
		
		ProducerThread producerthread=new ProducerThread(databox);
		ConsumerThread consumerthread=new ConsumerThread(databox);
		
		producerthread.start();
		consumerthread.start();
	}

}


class DataBox{
	private String data;
	
	public synchronized String getData(){
		//data 필드가 null이면 소비자 스레드를 일시정지함
		if(this.data==null){
			try {wait();} catch (Exception e) {}
		}
			String returnValue=data;
			System.out.println("ConsummerThread가 읽은 데이터 : "+returnValue);
			
			//data필드를 null로 만들고 생산자 스레드를 실행 대기함
			data=null;
			notify();
		return returnValue;
	}
	
	public synchronized void setData(String data){
		//data 필드가 null이 아니면 생산자 스레드를 일시정지
		if(this.data !=null)
		{
			try {wait();} catch (Exception e) {}
		}
		
		//data 필드 값을 저장, 소비자 스레드를 실행 대기함
		this.data=data;
		System.out.println("ProducerThread가 생성한 데이터 : "+data);
		notify();
	}
}

class ProducerThread extends Thread{
	private DataBox databox;
	
	public ProducerThread(DataBox databox) 
	{this.databox=databox;}
	
	@Override
	public void run(){
		for (int i = 0; i <= 3; i++) {
			String data="Data-"+i;
			databox.setData(data);
		}
	}
}

class ConsumerThread extends Thread{
	private DataBox databox;
	
	public ConsumerThread(DataBox databox) 
	{this.databox=databox;}
	
	@Override
	public void run(){
		for (int i = 0; i <= 3; i++) {
			String data=databox.getData();
		}
	}
}