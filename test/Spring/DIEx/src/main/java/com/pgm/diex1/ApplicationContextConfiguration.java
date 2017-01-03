package com.pgm.diex1;


import org.springframework.context.annotation.*;

//설정파일 대신 할겁니다
@Configuration
public class ApplicationContextConfiguration {
	
	@Bean(name="msgBean")
	public Ibean messageBean(){
		return new MessageBean();
	}
}
