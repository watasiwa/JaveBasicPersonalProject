package dao;

import java.util.ArrayList;

import vo.BreadVO;
import vo.Database;
import vo.MemberVO;

public class MemberDaoImpl implements MemberDao{

	@Override
	public ArrayList<MemberVO> ShowAllMember() {
		
		return Database.tb_member;
	}

	@Override
	public MemberVO idcheck(String id, String pw) {
		
		for(int i = 0; i < Database.tb_member.size(); i++){
			MemberVO checkmem = Database.tb_member.get(i);
			
			if(checkmem.getMember_id().equals(id)&&checkmem.getMember_pw().equals(pw)){

						return Database.tb_member.get(i);
					}
				}
	
		return null;
	}

	

	@Override //로그아웃
	public void logout() {
		Database.tb_Login = null;
	}

	@Override //아이디찾기
	public MemberVO findID(String birth, String tel) {
		for(int i =0; i < Database.tb_member.size(); i++){
			MemberVO findid = Database.tb_member.get(i);
			
			if(birth.equals(birth)&&tel.equals(tel)){
				if(findid.getMember_birth().equals(birth)&&findid.getMember_tel().equals(tel)){
					return findid;
				}
			}
		}
		return null;

		
	}

	@Override // 비밀번호찾기
	public MemberVO findPW(String id, String tel) {
		for(int i =0; i < Database.tb_member.size(); i++){
			MemberVO findpw = Database.tb_member.get(i);
				
				if(id.equals(id)&&tel.equals(tel)){
					if(findpw.getMember_id().equals(id)&&findpw.getMember_tel().equals(tel)){
						return findpw;
					}
			}
		}
		return null;
	}

	@Override
	public void InsertMember(MemberVO m) {
		 Database.tb_member.add(m);
	}



	
	@Override
	public MemberVO ShowMypage() {
		
		return Database.tb_Login;
	}

	@Override
	public MemberVO UpdateInfo(String id) { // 정보수정
		MemberVO modifyInfo = new MemberVO();
	      for(int i=0; i<Database.tb_member.size(); i++){
	         modifyInfo = Database.tb_member.get(i);
	            if(modifyInfo.getMember_id().equals(id)){
	               return modifyInfo;
	            }  
	      }
	       return null;
	     }

	@Override
	public void remove(MemberVO member) {
		Database.tb_member.remove(member);
		logout();
	}

	@Override
	public MemberVO SelectMember(int index) {
	
		return Database.tb_member.get(index-1);
	}

	@Override
	public void RemoveMember(int index) {
		Database.tb_member.remove(index-1);
	}

	@Override
	public void login(MemberVO member) {
		Database.tb_Login = member;
	}

	@Override
	public void RemoveCart(MemberVO cart, int index) {
		cart.getCart().remove(index);
	}

	@Override
	public void InsertCart(MemberVO cart, BreadVO bread) {
		cart.getCart().add(bread);
		
	}

	@Override
	public MemberVO IdCheck(String key, String value) {

		for(int i =0; i < Database.tb_member.size(); i++){
			MemberVO idchek = Database.tb_member.get(i);
			
			if(key.equals("ID")){
				if(idchek.getMember_id().equals(value)){
					return idchek;
				}
			}
		}
		return null;
	}

	


	
	
	
	
	
}
