package service;

import java.util.ArrayList;

import vo.BreadVO;
import vo.MemberVO;

public interface Manager {

	
	public void ShowMypage();   //회원과 관리자의 마이페이지
	public void UpdateMypage();   //정보변경
	public void remove();			// 탈퇴  관리자제외
	void PrintMember(); //현재로그인 회원정보
	public void ShowMemberpage();  //관리자에서 회원목록보기
	
	public void PrintAllMember();
	public void MenuManage();
	public void OrderManage();
}
