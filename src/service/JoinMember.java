package service;

public interface JoinMember {
/*
 * 		1.아이디 - 유효성
		2.비밀번호 -유효성
		3.생년월일 -유효성
		4.주소
		5.핸드폰번호 -유효성
		6.이메일
		0.뒤로가기
 */

	public void Join();
	
	public void Login();
	
	void Logout();
	
	void FindId();
	
	void FindPw();
	
	boolean check(String input, int index, boolean flag);

}
