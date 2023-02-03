package view;

import java.util.List;
import java.util.Scanner;

import Controller.BuildingController;
import Model.BuildingModel;

public class BuildingListViewSearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ten toa nha: ");
		String name = input.nextLine();
		BuildingController buildingController = new BuildingController();
		List<BuildingModel> buildingModels = buildingController.findSearch(name);
		for (BuildingModel buildingModel : buildingModels) {
			System.out.println("Tên tòa nhà: "+buildingModel.getName());
			System.out.println("Số lượng tầng hầm: "+ buildingModel.getNumberofbasement());
			System.out.println("Diện tích sàn: "+buildingModel.getFloorerea());
			System.out.println("Loại tòa nhà: "+buildingModel.getTypes());
			System.out.println("----------------------------------------------------------");
		}
	}
}
