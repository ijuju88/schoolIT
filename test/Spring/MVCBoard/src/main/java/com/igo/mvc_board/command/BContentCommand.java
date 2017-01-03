package com.igo.mvc_board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.igo.mvc_board.dao.BDao;
import com.igo.mvc_board.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object>map=model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String bId=request.getParameter("bId");
		BDao dao=new BDao();
		BDto dto=dao.content_view(bId);
		model.addAttribute("dto", dto);
	}

}
