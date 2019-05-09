package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BreadDao;
import dao.BreadDaoImpl;
import dao.MemberDao;
import dao.MemberDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import vo.BreadVO;
import vo.Database;
import vo.MemberVO;

public class ManagerImpl implements Manager{
	// 관리자에서 회원관리 + 유저 마이페이지 + 메뉴관리
	MemberDao member = new MemberDaoImpl();
	BreadDao bread = new BreadDaoImpl();
	OrderDao order1 = new OrderDaoImpl();
	OrderBuy order2 = new OrderBuyImpl();
	Scanner s = new Scanner(System.in);
	
	@Override
	public void ShowMypage() { //회원과 관리자 마이페이지보기
		boolean going = true;
		
		while(going){
			
			
			System.out.println();
			
			System.out.println("[메뉴를 선택해주세요]");
			System.out.println("1.수정하기");
			System.out.println("2.탈퇴하기");
			System.out.println("0.뒤로가기");
			int menu = s.nextInt();
			s.nextLine();
			switch(menu){
			
			case 1:
				
				MemberVO a1 = member.UpdateInfo(Database.tb_Login.getMember_id());
				MemberVO a2 = new MemberVO();
				
				boolean going1 = true;
				while(going1){
					
					// 회원 정보출력해주는 메서드 하나만들어서 삽입
					PrintMember();
					
					System.out.println();
					System.out.println("[변경하고 싶은 정보의 번호를 선택하세요]");
					System.out.println("1.비밀번호");
					System.out.println("2.이름");
					System.out.println("3.생년월일");
					System.out.println("4.주소");
					System.out.println("5.이메일");
					System.out.println("6.전화번호");
					System.out.println("0.뒤로가기");
					int i = s.nextInt();
					s.nextLine();
					
					switch(i){
					case 1:
						System.out.println("[회원정보수정]");
						System.out.println("변경하고 싶은 비밀번호를 입력해주세요");
						a2.setMember_pw(s.nextLine());
						if(!a2.getMember_pw().equals("\n")){
							a1.setMember_pw(a2.getMember_pw());
							System.out.println("비밀번호가" + a2.getMember_pw() + "로 변경되었습니다.");
						}break;	
						
					case 2:
						System.out.println("[회원정보수정]");
						System.out.println("변경하고 싶은 이름을 입력해주세요");
						a2.setMember_name(s.nextLine());
						if(!a2.getMember_name().equals("\n")){
							a1.setMember_name(a2.getMember_name());
							System.out.println("이름이" + a2.getMember_name() + "으로 변경되었습니다");
						}
						break;
					case 3:
						System.out.println("[회원정보수정]");
						System.out.println("변경하고 싶은 생년월일을 입력해주세요");
						a2.setMember_birth(s.nextLine());
						if(!a2.getMember_birth().equals("\n")){
							a1.setMember_birth(a2.getMember_birth());
							System.out.println("생년월일이" + a2.getMember_birth() + "으로 변경되었습니다.");
						}
						break;
					case 4:
						System.out.println("[회원정보수정]");
						System.out.println("변경하고 싶은 주소를 입력해주세요");
						a2.setMember_juso(s.nextLine());
						if(!a2.getMember_juso().equals("\n")){
							a1.setMember_juso(a2.getMember_juso());
							System.out.println("주소가" + a2.getMember_juso() + "로 변경되었습니다.");
						}
						break;
					case 5:
						System.out.println("[회원정보수정]");
						System.out.println("변경하고 싶은 이메일을 입력해주세요");
						a2.setMember_mail(s.nextLine());
						if(!a2.getMember_mail().equals("\n")){
							a1.setMember_mail(a2.getMember_mail());
							System.out.println("이메일이 " + a2.getMember_mail() + "로 변경되었습니다.");
						}
						break;
					case 6 ://전화번호 수정
						System.out.println("[회원정보수정]");
						System.out.println("변경하고 싶은 전화번호를 입력해주세요");
						a2.setMember_tel(s.nextLine());
						if(!a2.getMember_tel().equals("\n")){
							a1.setMember_tel(a2.getMember_tel());
							System.out.println("전화번호가 " + a2.getMember_tel() + "로 변경되었습니다.");
						}
					case 0:
						going1 = false;
					}
				}
				break;
				
			case 2: //탈퇴하기
				boolean flag = false;
				
				System.out.println("비밀번호를 입력해주세요 >");
				String pw;
				pw = s.nextLine();
				
				if(pw.equals(Database.tb_Login.getMember_pw())){
					int index=0;
					for(int i = 0; i < Database.tb_member.size(); i++){
						if (Database.tb_member.get(i).getMember_pw().equals(pw)){
							index = i;
						}
					} System.out.println("탈퇴가 완료되었습니다.");
					member.RemoveMember(index+1);
					member.logout();
				}else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
				}
				break;
			case 0: //뒤로가기
				going = false;
			}
			break;
			
			
			
			
		}		
	}

	@Override
	public void ShowMemberpage() {
		// 관리자의 회원목록보기
		Scanner s = new Scanner(System.in);
		boolean going = true;
		
		PrintAllMember();
		while(going){
			System.out.println("[메뉴를 선택해주세요]");
			System.out.println("1.회원정보수정");
			System.out.println("2.회원탈퇴");
			System.out.println("0.뒤로가기");
			
			int menu1 = s.nextInt();
			
			switch(menu1){
			case 1: //회원정보수정
				PrintAllMember();
				System.out.println("수정할 회원번호를 입력하세요.");
				int index = s.nextInt();
				s.nextLine();
				MemberVO a1 = member.SelectMember(index);
				MemberVO a2 = new MemberVO();
				
				boolean going1 =true;
				while(going1){
					PrintMember();
					System.out.println("[변경하고 싶은 정보의 번호를 선택하세요]");
					/*int index1 = s.nextInt();
					s.nextLine();
					*/
					System.out.println("1.비밀번호");
					System.out.println("2.이름");
					System.out.println("3.생년월일");
					System.out.println("4.주소");
					System.out.println("5.전화번호");
					System.out.println("6.권한");
					System.out.println("0.뒤로가기");
					
					int i = s.nextInt();
					s.nextLine();
					
					switch(i){
					case 1: //비밀번호변경
						System.out.println("[관리자의 회원수정]");
						System.out.println("변경할 비밀번호를 입력해주세요");
						a2.setMember_pw(s.nextLine());
						if(!a2.getMember_pw().equals("\n")){
							a1.setMember_pw(a2.getMember_pw());
						} System.out.println("비밀번호가" + a2.getMember_pw() + "(으)로 변경되었습니다.");
						break;
					case 2: //이름변경
						System.out.println("[관리자의 회원수정]");
						System.out.println("변경할 이름을 입력해주세요");
						a2.setMember_name(s.nextLine());
						if(!a2.getMember_name().equals("\n")){
							a1.setMember_name(a2.getMember_name());
						} System.out.println("이름이" + a2.getMember_name() + "(으)로 변경되었습니다.");
						break;
					case 3: //생년월일
						System.out.println("[관리자의 회원수정]");
						System.out.println("변경할 생년월일을 입력해주세요");
						a2.setMember_birth(s.nextLine());
						if(!a2.getMember_birth().equals("\n")){
							a1.setMember_birth(a2.getMember_birth());
						} System.out.println("생년월일이" + a2.getMember_birth() + "(으)로 변경되었습니다.");
						break;
					case 4: //주소
						System.out.println("[관리자의 회원수정]");
						System.out.println("변경할 주소를 입력해주세요");
						a2.setMember_juso(s.nextLine());
						if(!a2.getMember_juso().equals("\n")){
							a1.setMember_juso(a2.getMember_juso());
						} System.out.println("주소가 " + a2.getMember_juso() + "(으)로 변경되었습니다.");
						break;
					case 5: //전화번호
						System.out.println("[관리자의 회원수정]");
						System.out.println("변경할 전화번호를 입력해주세요");
						a2.setMember_tel(s.nextLine());
						if(!a2.getMember_tel().equals("\n")){
							a1.setMember_tel(a2.getMember_tel());
						}	System.out.println("전화번호가" + a2.getMember_tel() + "(으)로 변경되었습니다.");
						break;
					case 6:
						System.out.println("[관리자의 회원수정]");
						System.out.println("관리자 : true" + " " + "일반인 : false");
						a1.setMember_auth(s.nextBoolean());
					case 0: //뒤로가기
						going1 = false;
					}
				}break;
				
			case 2: //회원탈퇴
				PrintAllMember();
				
				System.out.println("삭제하실 회원의 번호를 입력하세요");
				index = s.nextInt();
				s.nextLine();
				MemberVO member1= member.SelectMember(index);
				System.out.println("정말로" + member1.getMember_id() + "(을)를 삭제하시겠습니까? [Y/N]");
				
				String i = null;
				i = s.nextLine();
				if(i.equals("Y")|| i.equals("y")){
				  member.RemoveMember(index);
				}else if(i.equals("N")||i.equals("n")){
					
					break;
				}
					
				String id = member1.getMember_id();
				System.out.println(id + "가 삭제되었습니다.");
				
				break;
			case 0: //뒤로가기	
				going = false;
				break;
			}
			
		}
		}
	


	@Override
	public void UpdateMypage() {  // 회원과 관리자의 정보변경
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() { //회원의 자진탈퇴
		// TODO Auto-generated method stub
		
	}

	
	


	

	@Override
	public void PrintMember() {
		MemberVO list1 = member.ShowMypage();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("아이디" +"\t" + "비밀번호" +"\t" + "이름" +"\t" + "생년월일" +"\t" + "주소" +"\t"+"메일"+"\t"+ "전화번호" );
		
			System.out.println(list1.getMember_id()+"\t"
								+ list1.getMember_pw() +"\t"
								+ list1.getMember_name() +"\t"
								+ list1.getMember_birth()+"\t"
								+ list1.getMember_juso() +"\t"
								+ list1.getMember_mail()+"\t"
								+ list1.getMember_tel());
			System.out.println("----------------------------------------------------------------------------------------");
					}
	@Override
	public void PrintAllMember() {
		ArrayList<MemberVO>	list = member.ShowAllMember();
		
		int num = 1;
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("번호" +"\t" + "아이디" +"\t" + "비밀번호" +"\t" + "이름" +"\t" + "생년월일" +"\t" + "주소" +"\t"+"메일"+"\t"+ "전화번호" );
		
		for(MemberVO member : list){
			System.out.println(num + "." + member.getMember_id()+"\t"
										 + member.getMember_pw()+"\t"
										 + member.getMember_name()+"\t"
										 + member.getMember_birth()+"\t"
										 + member.getMember_juso()+"\t"
										 + member.getMember_mail()+"\t"
										 + member.getMember_tel() );
			num++;
		}
	}

	@Override
	public void MenuManage() {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		BreadVO bread1 = new BreadVO();
		while(flag){
			System.out.println("[관리자의 메뉴관리]");
			System.out.println("1.메뉴등록");
			System.out.println("2.메뉴삭제");
			System.out.println("0.뒤로가기");
			int num = s.nextInt();
			s.nextLine();
			
			switch(num){
			case 1 : //메뉴등록 순서
				order2.ShowAllBread();
				System.out.println("[메뉴를 등록합니다]");
				System.out.println("빵 이름>");
				String big = s.nextLine();
				bread1.setBread_name(big);
				
				System.out.println("설명 >");
				big = s.nextLine();
				bread1.setBread_info(big);
				
				System.out.println("제조시간 >");
				big = s.nextLine();
				bread1.setBread_maketime(big);
				
				System.out.println("가격 >");
				
				long p = s.nextLong();
				s.nextLine();
				bread1.setBread_price(p);
				
				bread.updateMeun(bread1);
				break;
			case 2: //메뉴삭제
				System.out.println("삭제할 빵이름을 써주세요");
				String b = s.nextLine();
				bread.findBread(b);
				
				break;
			case 0: //뒤로가기	
				flag =false;
				break;
			}
		}
	}

	@Override
	public void OrderManage() { //주문관리
		OrderBuy order = new OrderBuyImpl();
		boolean flag = true;
		
		
		System.out.println("1.결재목록");
		System.out.println("2.환불목록");
		System.out.println("0.뒤로가기");
		int num = s.nextInt();
		s.nextLine();
		
		switch(num){
		case 1: //결재목록
			order1.ShowBuyList();	
		
			break;
		case 2: //환불목록
			order1.ShowRefundList();
			break;
		case 0: //뒤로가기
			flag = false;
			break;
		}
		
		
	}


	
	}
	

	


