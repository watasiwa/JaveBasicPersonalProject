package dao;

import java.util.ArrayList;

import vo.BreadVO;
import vo.Database;
import vo.MemberVO;
import vo.OrderVO;

public class OrderDaoImpl implements OrderDao{

	@Override
	public ArrayList<OrderVO> ViewAllMenu() {
		
		return Database.tb_order;
	}

	@Override
	public void cart(BreadVO b) {
		
		Database.tb_cart.add(b);
	}

	@Override
	public void InsertMenu(BreadVO index) {
		Database.tb_cart.add(index);
	}

	@Override
	public void DeleteMenu(int index) {
		Database.tb_cart.remove(index);
	}

	@Override
	public void buylist(MemberVO m) {
		Database.tb_buylist.add(m);
	}

	@Override
	public void refundlist(MemberVO m) {
		Database.tb_refundlist.add(m);
	}

	@Override
	public void ShowBuyList() {
		for(int i = 0; i < Database.tb_buylist.size(); i++){
			System.out.println(Database.tb_buylist.get(i).getMember_id());
			for(int j=0; j < Database.tb_buylist.get(i).getCart().size(); j++){
				System.out.println("빵이름 - " + Database.tb_buylist.get(i).getCart().get(j).getBread_name());
				System.out.println("빵정보 - " + Database.tb_buylist.get(i).getCart().get(j).getBread_info());
				System.out.println("빵가격 - " + Database.tb_buylist.get(i).getCart().get(j).getBread_price());
			}
		}
	}

	@Override
	public void ShowRefundList() {
		for(int i =0; i < Database.tb_refundlist.size(); i++){
			System.out.println(Database.tb_refundlist.get(i).getMember_id());
			for(int j=0; j < Database.tb_refundlist.get(i).getCart().size(); j++){
				System.out.println("빵이름 - " + Database.tb_refundlist.get(i).getCart().get(j).getBread_name());
				System.out.println("빵정보 - " + Database.tb_refundlist.get(i).getCart().get(j).getBread_info());
				System.out.println("빵가격 - " + Database.tb_refundlist.get(i).getCart().get(j).getBread_price());
				
			}
		}
	}

	
}
