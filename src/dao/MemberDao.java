package dao;

import java.util.ArrayList;

import vo.BreadVO;
import vo.MemberVO;

public interface MemberDao {

	public void InsertMember(MemberVO m);
	public MemberVO ShowMypage();
	public MemberVO UpdateInfo(String id);
	public MemberVO SelectMember(int index);
	void RemoveMember(int index);
	ArrayList<MemberVO> ShowAllMember();
	
	MemberVO idcheck(String id,String pw);
	
	 void login(MemberVO member);
	 void logout();
	 void remove(MemberVO member);
	 MemberVO findID(String birth, String tel);
	 MemberVO findPW(String id, String tel);
	 
	 MemberVO IdCheck(String key, String value);
	 
	 void RemoveCart(MemberVO cart, int index);
	 void InsertCart(MemberVO cart, BreadVO bread);
}
