package com.interfaceex;

public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리.");
		} else {
			System.out.println("무음해제.");
		}
	}
	
	static void changeBattery() {
		System.out.println("건전지가 없어요.");
	}
}
