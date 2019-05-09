package center;

import java.util.Scanner;

import javax.xml.datatype.DatatypeFactory;

import dao.BreadDao;
import dao.BreadDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import service.JoinMember;
import service.JoinMemberImpl;
import service.Manager;
import service.ManagerImpl;
import service.OrderBuy;
import service.OrderBuyImpl;
import vo.BreadVO;
import vo.Database;
import vo.MemberVO;

public class CenterController {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean isContinue = true;
		
		//관리자는 미리접속
		MemberDao member = new MemberDaoImpl();
		MemberVO login_id = new MemberVO();
		
		login_id.setMember_id("admin");
		login_id.setMember_pw("admin");
		login_id.setMember_name("관리자");
		login_id.setMember_auth(true);
		member.InsertMember(login_id);
		
		BreadDao bread = new BreadDaoImpl();
		BreadVO upmenu = new BreadVO();
		
		
		upmenu.setBread_name("소보루빵");
		upmenu.setBread_info("맛잇는 소보루~");
		upmenu.setBread_price(1500L);
		upmenu.setBread_maketime("아침");
		bread.updateMeun(upmenu);
		
		BreadVO upmenu1 = new BreadVO();
		
		upmenu1.setBread_name("에그타르트");
		upmenu1.setBread_info("맛있는 에그타르트~");
		upmenu1.setBread_price(2000L);
		upmenu1.setBread_maketime("방금");
		bread.updateMeun(upmenu1);
		
	 while(isContinue){
		JoinMember joinmember = new JoinMemberImpl();
		Manager	manager = new ManagerImpl();
		OrderBuy orderbuy = new OrderBuyImpl();
		
		
		if(Database.tb_Login == null){
			System.out.println("<<SSG빵에 오신걸 환영합니다.>>");
			System.out.println();
			System.out.println("[메뉴를 선택해주세요.]");
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.아이디/비밀번호찾기");
			System.out.println("0.프로그램 종료");
			int menu = s.nextInt();
			
			
			switch(menu){
			case 1:
				joinmember.Join();
				break;
			case 2:
				joinmember.Login();
				
				break;
			case 3:
				System.out.println();
				System.out.println("[아이디/비밀번호찾기]");
				System.out.println("1.아이디찾기");
				System.out.println("2.비밀번호찾기");
				System.out.println("0.뒤로가기");
				
				menu = s.nextInt();
				
				switch(menu){
				case 1:
					joinmember.FindId();
					break;
				case 2:
					joinmember.FindPw();
					break;
				case 3:
					break;
					
					default:
						isContinue = false;
						break;
				}
				break;
				
				default:
					System.out.println("프로그램이 종료되었습니다.");
					isContinue = false;
					break;
				
			}
			
		} else if(Database.tb_Login.isMember_auth()==true){//관리자로그인 화면{
				System.out.println("[관리자화면]");
				System.out.println("1.마이페이지");
				System.out.println("2.회원관리");
				System.out.println("3.메뉴관리");
				System.out.println("4.주문관리");
				System.out.println("5.로그아웃");
				System.out.println();
				
				int menu = s.nextInt();
				s.nextLine();
				
				switch(menu){
				case 1: //관리자의 마이페이지
					manager.ShowMypage();
					break;
				case 2: //회원관리
					manager.ShowMemberpage();
					break;
				case 3: //메뉴관리
					manager.MenuManage();
					break;
				case 4: //주문관리
					manager.OrderManage();
					break;
				case 5: //로그아웃
					member.logout();
					System.out.println("정상적으로 로그아웃되었습니다.");
					break;
				}
				
		 }
			else if(!Database.tb_Login.isMember_auth()==true){//일반사용자 로그화면
		  
	 			System.out.println("[일반사용자화면]");
	 			System.out.println("1.마이페이지");
	 			System.out.println("2.로그아웃");
	 			System.out.println("3.주문하기");
	 			System.out.println();
	 			
	 			int num = s.nextInt();
	 			s.nextLine();
	 			
	 			switch(num){
	 			case 1: //마이페이지
	 				manager.ShowMypage();
	 				
	 				break;
	 			case 2: // 로그아웃
	 				member.logout();
	 				System.out.println("정상적으로 로그아웃되었습니다.");
	 				break;
	 			case 3: // 주문하기
	 				boolean isContinue1 = true;
	 				while(isContinue1){
	 					
	 				
	 				System.out.println("1.메뉴보기");
	 				System.out.println("2.장바구니담기");
	 				System.out.println("3.장바구니삭제");
	 				System.out.println("4.결제하기");
	 				System.out.println("5.환불하기");
	 				System.out.println("0.뒤로가기");
	 				int num1 = s.nextInt();
	 				s.nextLine();
	 				
	 				switch(num1){
	 				case 1: //메뉴보기
	 					orderbuy.ViewMenu();
	 					break;
	 				case 2: //장바구니담기
	 					orderbuy.InsertMenu();
	 					break;
	 				case 3: //장바구나삭제
	 					orderbuy.DeleteMenu();
	 					break;
	 				case 4: //결제하기
	 					orderbuy.GoldenBell();
	 					break;
	 				case 5: //환불하기
	 					orderbuy.Refund();
	 					break;
	 				case 0: //뒤로가기
	 					isContinue1=false;
	 					break;
						}
					}
					break;
				}
			}
		}
	}
}
