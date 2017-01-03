package com.igo.mvc_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.igo.mvc_board.dao.BDao;
import com.igo.mvc_board.dto.BDto;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		BDto dto=new BDto();
		String bId=request.getParameter("bId");
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		BDao dao=new BDao();
		dao.reply(bId, bName, bTitle, bContent);
		
	}

}
