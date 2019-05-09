package dao;

import java.util.ArrayList;

import vo.BreadVO;
import vo.Database;

public class BreadDaoImpl implements BreadDao {

	@Override
	public ArrayList<BreadVO> ShowBreadMeun() {
	
		return Database.tb_bread;
	}

	@Override
	public void updateMeun(BreadVO name) {
		Database.tb_bread.add(name);
	}

	@Override
	public void deleteMenu(BreadVO name) {
		Database.tb_bread.remove(name);
	}

	@Override
	public void findBread(String s) {
		boolean cham = false;
		for(int i =0; i < Database.tb_bread.size(); i++){
			if(s.equals(Database.tb_bread.get(i).getBread_name())){
				Database.tb_bread.remove(i);
				
			}
		}
		System.out.println(cham == true?"삭제되었습니다.":"이름이 존재하지 않습니다.");
	}

	@Override
	public BreadVO SelectBread(int index) {
	
		return Database.tb_bread.get(index-1);
	}

	@Override
	public BreadVO RemoveBread(int index) {
		
		return Database.tb_cart.remove(index-1);
	}	

}
