package com.igo.mvc_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.igo.mvc_board.dao.BDao;
import com.igo.mvc_board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		BDao dao=new BDao();
		ArrayList<BDto> dtos=dao.list();
		model.addAttribute("dtos", dtos);
	}

} 
