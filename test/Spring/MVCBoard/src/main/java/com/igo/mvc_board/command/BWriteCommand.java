package com.igo.mvc_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.igo.mvc_board.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		//  <키값,실제값>모델에 들어있는 값을 꺼내오기위해서 맵 형태로 치환한것
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		BDao dao=new BDao();
		dao.write(bName,bTitle,bContent);
	}

}
