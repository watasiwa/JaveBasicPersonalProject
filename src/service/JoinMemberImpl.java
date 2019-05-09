package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vo.Database;
import vo.MemberVO;
import dao.MemberDao;
import dao.MemberDaoImpl;

public class JoinMemberImpl implements JoinMember {
	Scanner s = new Scanner(System.in);
	// + 로그인 로직까지
		/*
		 * 회원가입
			1.아이디 - 유효성
			2.비밀번호 -유효성
			3.생년월일 -유효성
			4.주소
			5.핸드폰번호 -유효성
			6.이메일
			0.뒤로가기


			로그인	
			아이디-유효성	
			비밀번호 -유효성	

		 */
	MemberDao MemberDao = new MemberDaoImpl();
	
	@Override
	public void Join() {  //회원가입
		boolean flagid = false;
		boolean flagpw = false;
		boolean flagmail = false;
		boolean flagtel = false;
		
		
		Scanner s = new Scanner(System.in);
		MemberVO member = new MemberVO();
		while(!flagid){
		System.out.println("※ 양식에 맞게 작성해주세요");
		System.out.print("아이디 >");
		String input = s.nextLine();
		member.setMember_id(input);
		
			MemberVO check = MemberDao.IdCheck("ID", member.getMember_id());
			
			if(check != null){   //아이디 중복체크
				System.out.println("이미 사용중인 아이디가 있습니다. 다시 시도해주세요.");
			}else{
				flagid = check(input, 0, flagid); 
			}
		}
		
		
		while(!flagpw){
		System.out.println();
		System.out.print("비밀번호(예 12345!) >");
		String pw;
		pw = s.nextLine();
		
		if(flagpw = check(pw,1,flagpw)){
			System.out.println();
			System.out.print("비밀번호 확인>");
				if (pw.equals(s.nextLine())) {
					member.setMember_pw(pw);
				}else{
					System.out.print("비밀번호가 일치하지 않습니다. 다시 입력해주세요 >");
					System.out.println();
					flagpw = false;
				}
			}
		}
		System.out.println("이름 >");
		String name;
		name = s.nextLine();
		member.setMember_name(name);
		
		System.out.println("생년월일(예 19941004) >");
		String birth;
		birth = s.nextLine();
		member.setMember_birth(birth);
		
		while(!flagmail){
		System.out.println();
		System.out.println("이메일(예 test1@nate.com) >");
		String email;
		email = s.nextLine();
		if(flagmail = check(email,2,flagmail))
		member.setMember_mail(email);
		}
		
		System.out.println("주소 >");
		String addr;
		addr = s.nextLine();
		member.setMember_juso(addr);
		
		while(!flagtel){
		System.out.println();
		System.out.println("전화번호(예 01x-xxxx-xxxx) >");
		String tel;
		tel = s.nextLine();
		if(flagtel = check(tel,3,flagtel))
		member.setMember_tel(tel);
		}
	
		MemberDao.InsertMember(member);
		System.out.println("회원가입이 완료되었습니다.");
		// 넣긴 넣음
		
	}

	@Override
	public void Login() { // 로그인
		Scanner s = new Scanner(System.in);
		boolean i = true;
		while (i) {
			System.out.println("로그인을 시작합니다.");
			System.out.println("아이디 >");
			String id = s.nextLine();
			MemberVO member = new MemberVO();

			System.out.println("비밀번호 >");
			String pw = s.nextLine();
			if ((member = MemberDao.idcheck(id, pw)) != null) {

				MemberDao.login(member);
				System.out.println(member.getMember_id() + "가 로그인했습니다");
				i = false;
			}
			else{
				System.out.println("아이디가 없거나 비밀번호가 틀립니다.");
				i = false;

			}
		}
	}

	@Override
	public void FindId() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("생년월일을 입력해주세요");
		String birth = s.nextLine();
		
		System.out.println("전화번호를 입력해주세요");
		String tel = s.nextLine();
		MemberVO member = new MemberVO();
		if((member = MemberDao.findID(birth, tel))!= null){
			System.out.println("아이디는 " + member.getMember_id() + "입니다");
		}
	}

	@Override
	public void FindPw() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		
		System.out.println("전화번호를 입력해주세요");
		String tel = s.nextLine();
		
		MemberVO member = new MemberVO();
		if((member = MemberDao.findPW(id, tel)) != null){
			System.out.println("비밀번호는 " + member.getMember_pw() + "입니다");
		}
	}

	@Override
	public void Logout() {
		System.out.println("로그아웃이 정상처리되었습니다.");
		MemberDao.logout();
	}

	@Override
	public boolean check(String input, int index, boolean flag) {
		String[] dialogue = {"[아이디는 5~12자 영문자, 숫자만 사용가능합니다.]",
							 "[비밀번호는 6~12자 영문자,숫자,특수문자를 사용하세요.]",
							 "[이메일은 6~12자 영문자, 숫자만 사용 가능합니다.]",
							 "[전화번호는 01x-xxxx-xxxx 형식으로 입력해주세요.]"};
		
		Pattern[] pattern = new Pattern[4];
		pattern[0] = Pattern.compile("[a-zA-Z0-9]{5,12}");
		pattern[1] = Pattern.compile("(?=.*[!?@#$%^&*])[a-z0-9!?@#$%z^&*]{6,12}");
		pattern[2] = Pattern.compile("[a-z0-9_-]{5,12}@[a-zA-Z_-]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))");
		pattern[3] = Pattern.compile("^01\\d{1,1}-\\d{3,4}-\\d{3,4}");
		
		Matcher matcher = pattern[index].matcher(input);
		
			if(!matcher.matches()){
				System.out.println(dialogue[index]);
				flag = false;
			}else{
				flag =true;
			} return flag;
		}
}

