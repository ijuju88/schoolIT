package roti.lms.ad_reg;

import java.util.*;
import roti.lms.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roti.lms.ad_reg.RegisterDAO;

public class RegisterListAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		System.out.println("완료");
		RegisterDAO boarddao = new RegisterDAO();
		List<RegisterBean> boardlist = new ArrayList<RegisterBean>();
		int page = 1;
		int limit = 10;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int listcount=boarddao.getListCount(); //�� ����Ʈ ���� �޾� ��
		boardlist = boarddao.getRegisterList(page,limit); //����Ʈ�� �޾� ��
		
		//�� ������ ��
   		int maxpage=(int)((double)listcount/limit+0.95); //0.95�� ���ؼ� �ø� ó��
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��(10, 20, 30 ��...)
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
   		request.setAttribute("page", page);  //���� ������ ��
   		request.setAttribute("maxpage", maxpage);  //�ִ� ������ ��
   		request.setAttribute("startpage", startpage);  //���� �������� ǥ���� ù ������ ��
   		request.setAttribute("endpage", endpage);  //���� �������� ǥ���� �� ������ ��
		request.setAttribute("listcount",listcount);  //�� ��
		request.setAttribute("boardlist", boardlist);
		forward.setRedirect(false);
		System.out.println("ㅋㅋ");
		forward.setPath("reg_info.jsp");
		return forward;
	}
}
