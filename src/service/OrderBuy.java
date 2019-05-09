package service;

public interface OrderBuy {
	
	void ViewMenu(); //일반인의 메뉴보기
	
	void InsertMenu(); //일반인의 메뉴담기
	
	void DeleteMenu(); // 일반인의 메뉴제거하기
	
	void GoldenBell(); // 결제하기
	
	void Refund(); //환불하기
	
	void ShowAllBread();
	
	void ShowCartList();
	
	void ShowRefundList();
}

