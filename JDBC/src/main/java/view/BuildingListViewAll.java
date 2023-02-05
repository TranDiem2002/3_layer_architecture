package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.BuildingController;
import Model.BuildingModel;

public class BuildingListViewAll {

	public static void main(String[] args) {
		BuildingController buildingController = new BuildingController();
		List<BuildingModel> buildingModels = buildingController.findAll();
		for (BuildingModel buildingModel : buildingModels) {
			System.out.println("Tên tòa nhà: "+buildingModel.getName());
			System.out.println("Số lượng tầng hầm: "+ buildingModel.getNumberofbasement());
			System.out.println("Diện tích sàn: "+buildingModel.getFloorerea());
			System.out.println("Loại tòa nhà: "+buildingModel.getTypes());
			System.out.println("----------------------------------------------------------");
		}
		
	}
}
