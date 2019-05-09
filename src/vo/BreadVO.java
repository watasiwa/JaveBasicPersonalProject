package vo;

public class BreadVO {

	
	//BreadVO의 객체
	
	
	
	
	
	
	private int bread_no;
	private String bread_name;
	private String bread_info;
	private Long bread_price;
	private String bread_maketime;
	private String member_id;
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	private String Kategorie; //빵종류  식빵류, 도넛류, 파이
	
	public int getBread_no() {
		return bread_no;
	}

	public void setBread_no(int bread_no) {
		this.bread_no = bread_no;
	}

	public String getBread_name() {
		return bread_name;
	}

	public void setBread_name(String bread_name) {
		this.bread_name = bread_name;
	}

	public String getBread_info() {
		return bread_info;
	}

	public void setBread_info(String bread_info) {
		this.bread_info = bread_info;
	}

	public Long getBread_price() {
		return bread_price;
	}

	public void setBread_price(Long bread_price) {
		this.bread_price = bread_price;
	}

	public String getBread_maketime() {
		return bread_maketime;
	}

	public void setBread_maketime(String bread_maketime) {
		this.bread_maketime = bread_maketime;
	}

	public String getKategorie() {
		return Kategorie;
	}

	public void setKategorie(String kategorie) {
		Kategorie = kategorie;
	}

	
}
