package dao;

import java.util.ArrayList;

import vo.BreadVO;
import vo.MemberVO;
import vo.OrderVO;

public interface OrderDao {

	ArrayList<OrderVO> ViewAllMenu();
	
	void cart(BreadVO b);
	
	void InsertMenu(BreadVO index);
	void DeleteMenu(int index);
	
	void buylist(MemberVO m);
	void refundlist(MemberVO m);
	
	void ShowBuyList();
	void ShowRefundList();
}
