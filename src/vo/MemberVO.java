package vo;

import java.util.ArrayList;

public class MemberVO {

	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_birth;
	private String member_juso;
	private String member_tel;
	private String member_mail;
	private boolean member_auth;
	private ArrayList<BreadVO> cart = new ArrayList<BreadVO>();

	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_juso() {
		return member_juso;
	}
	public void setMember_juso(String member_juso) {
		this.member_juso = member_juso;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_mail() {
		return member_mail;
	}
	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}
	public boolean isMember_auth() {
		return member_auth;
	}
	public void setMember_auth(boolean member_auth) {
		this.member_auth = member_auth;
	}
	public ArrayList<BreadVO> getCart() {
		return cart;
	}
	public void setCart(ArrayList<BreadVO> cart) {
		this.cart = cart;
	}
	

 }
