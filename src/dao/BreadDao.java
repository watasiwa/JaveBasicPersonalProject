package dao;

import java.util.ArrayList;

import vo.BreadVO;

public interface BreadDao {

	ArrayList<BreadVO> ShowBreadMeun();
	void  findBread(String s);
	void updateMeun(BreadVO name);
	
	void deleteMenu(BreadVO name);
	
	BreadVO SelectBread(int index);
	BreadVO RemoveBread(int index);
}
