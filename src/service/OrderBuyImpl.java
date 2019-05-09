package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.BreadVO;
import vo.Database;
import dao.BreadDao;
import dao.BreadDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;



public class OrderBuyImpl implements OrderBuy{
	BreadDao breaddao = new BreadDaoImpl();
	MemberDao MemberDao = new MemberDaoImpl();
	OrderDao orderdao = new OrderDaoImpl();
	BreadVO bread = new BreadVO();
	boolean buycheck = false;
	
	
	/*
	 *  주문
		메뉴보기
		장바구니담기
		장바구니삭제
		결제하기
		환불하기
		0.뒤로가기
	
				주문관리	
				결제목록	
				환불목록	
	
	 */
	Scanner s = new Scanner(System.in);
	
	@Override
	public void ViewMenu() { //제품보기
		
		ShowAllBread();
		
		System.out.println();

		
	}

	@Override
	public void InsertMenu() { //장바구니담기
		//BreadVO cartIn = new BreadVO();
		
		boolean flag = true;
		while(flag){
		
			ShowAllBread();
		

		System.out.println("담고싶은 제품의 번호를 선택해주세요.");
		System.out.println("번호 >");
	
		int index = s.nextInt();
		s.nextLine();
		BreadVO b1 = breaddao.SelectBread(index);
			
		b1.setMember_id(Database.tb_Login.getMember_id());
			Database.tb_cart.add(b1);
			Database.tb_Login.getCart().add(b1);
			b1.setMember_id(null);
			flag=false;
		}
	}

	@Override
	public void DeleteMenu() { //장바구니삭제
		ShowCartList();
		
		System.out.println("삭제하고싶은 제품의 번호를 선택해주세요.");
		System.out.println("번호 >");
		
		int index1 = s.nextInt();
		s.nextLine();
		
		System.out.println("진심으로 삭제하시겠습니까?? Y/N");
		String str=null;
		str = s.nextLine();
		
		if(str.equals("Y")|| str.equals("y")){
			BreadVO b2 = breaddao.RemoveBread(index1);
			Database.tb_Login.getCart().remove(index1-1);
			System.out.println("제품이 삭제되었습니다.");
		}
		
			
	}
	

	@Override
	public void GoldenBell() { // 산다
		ShowCartList();
		
		int sum = 0;
		for(int i =0; i <Database.tb_cart.size();i++){
		sum += Database.tb_cart.get(i).getBread_price();
		}
		System.out.println("총가격은 " + sum + "원 입니다.");
		
		
		System.out.println("지불하실 금액을 적어주세요");
		int input = s.nextInt();
		s.nextLine();
		
		if(input >= sum){
			System.out.println("결제가 완료되었습니다.감사합니다");
			Database.tb_cart.clear();
			orderdao.buylist(Database.tb_Login);
			buycheck = true;
		}else{
			System.out.println("잔액이 부족합니다.");
		}
		
	}

	@Override
	public void Refund() { //환불
		System.out.println("환불하시겠습니까?  Y/N");
		String str1;
		str1 = s.nextLine();

		if (str1.equals("Y") || str1.equals("y") && buycheck) {
			ShowRefundList();
			int sum = 0;
			for (int i = 0; i < Database.tb_Login.getCart().size(); i++) {
				sum += Database.tb_Login.getCart().get(i).getBread_price();
			}
			System.out.println("환불가격은 " + sum + "원 입니다.");
			buycheck = false;
			orderdao.refundlist(Database.tb_Login);
			Database.tb_Login.getCart().clear();
			
		}
	}

	@Override
	public void ShowAllBread() {
ArrayList<BreadVO>	list =breaddao.ShowBreadMeun();
		
		int num = 1;
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("번호" +"\t"+ "제품이름" +"\t"+ "정보" +"\t"+"가격" +"\t"+ "제조시간" );
		
		for(BreadVO bread : list){
			System.out.println(num + "." + bread.getBread_name()+"\t"
										 + bread.getBread_info()+"\t"
										 + bread.getBread_price()+"원"+"\t"
										 + bread.getBread_maketime());
			num++;
		}
		System.out.println("------------------------------------------------------------------------------");
	}

	@Override
	public void ShowCartList() {
		int num1 = 1;
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("번호" +"\t"+ "제품이름" +"\t"+ "정보" +"\t"+"가격"+"\t"+"만든시간");
		for(int i =0; i <Database.tb_cart.size(); i++){
			System.out.println(num1 + "." + Database.tb_cart.get(i).getBread_name() +"\t"
							   + Database.tb_cart.get(i).getBread_info()+"\t"
							   + Database.tb_cart.get(i).getBread_price()+"원"+"\t"
							   + Database.tb_Login.getCart().get(i).getBread_maketime());
			num1++;				
		}	System.out.println("------------------------------------------------------------------------------");
		}
	@Override
	public void ShowRefundList() {
		int num1 = 1;
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("번호" +"\t"+ "제품이름" +"\t"+ "정보" +"\t"+"가격"+"\t"+"만든시간");
		for(int i =0; i <Database.tb_Login.getCart().size(); i++){
			System.out.println(num1 + "." + Database.tb_Login.getCart().get(i).getBread_name() +"\t"
							   + Database.tb_Login.getCart().get(i).getBread_info()+"\t"
							   + Database.tb_Login.getCart().get(i).getBread_price()+"원"+"\t"
							   + Database.tb_Login.getCart().get(i).getBread_maketime());
			num1++;				
		}
	}
	
	
}
