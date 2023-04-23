package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import Controller.BuildingController;
import Model.BuildingReponse.BuildingReponse;

public class BuildingListViewSearch {
	
	public static void input(Map<String, Object> map, List<String> types) {
		map.put("name", "Building");
		map.put("floorarea", null);
		map.put("idDistrict", 1 );
		map.put("ward", "");
		map.put("street", "");
		map.put("numberofbasement", 2);
		map.put("level", "");
		map.put("direction", "");
		map.put("manager", "");
		map.put("staff",null);
		map.put("rentPriceFrom", 12);
		map.put("rentPriceTo", 20);
		map.put("areaRentFrom", 12);
		map.put("areaRentTo", null);
		types.add("tang-tret");
		
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		List<String> loaitoanha = new ArrayList<String>();	
		input(map, loaitoanha);
		BuildingController buildingController = new BuildingController();
		List<BuildingReponse> buildingReponses = buildingController.findSearch(map, loaitoanha);
		for (BuildingReponse building : buildingReponses) {
			System.out.println("ID: " + building.getId());
			System.out.println("Tên tòa nhà: " + building.getName());
			System.out.println("Địa chỉ: " + building.getAddress());
			System.out.println("Số lượng tầng hầm: " + building.getNumberofbasement());
			System.out.println("Giá thuê: " + building.getRentprice());
			System.out.println("Phí dịch vụ: " + building.getServicefree());
			System.out.println("Phí môi giới:  " + building.getBrokeragefree());
			System.out.println("----------------------------------------------------------");
		}
	}
}
