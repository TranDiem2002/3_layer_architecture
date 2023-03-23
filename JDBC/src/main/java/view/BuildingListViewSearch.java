package view;

import java.util.List;
import java.util.Scanner;

import Controller.BuildingController;
import Model.BuildingModel;

public class BuildingListViewSearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tên tòa nhà: ");
		String name = input.nextLine();
		System.out.println("Diện tích sàn: ");
		int dientichsan = input.nextInt();
		System.out.println("Quận: ");
		Long quan = input.nextLong();
		System.out.println("Phường: ");
		String phuong = scanner.nextLine();
		System.out.println("Đường: ");
		String duong =scanner.nextLine();
		System.out.println("số tầng hầm: ");
		int sotang =scanner.nextInt();
		System.out.println("Nhập hướng: ");
		String huong =scanner.nextLine();
		BuildingController buildingController = new BuildingController();

		
		List<BuildingModel> buildingModels = buildingController.findSearch(name,dientichsan,quan,duong,sotang,huong,null,phuong);
		
		for (BuildingModel buildingModel : buildingModels) {
			System.out.println("Tên tòa nhà: "+buildingModel.getName());
			System.out.println("Số lượng tầng hầm: "+ buildingModel.getNumberofbasement());
			System.out.println("Diện tích sàn: "+buildingModel.getfloorarea());
//			//System.out.println("Loại tòa nhà: "+buildingModel.getTypes());
			System.out.println("Địa chỉ:đường "+buildingModel.getStreet()+","+ buildingModel.getward()+",quận "+buildingModel.getDistrict());
			System.out.println("Hướng: "+buildingModel.getDirection());
			System.out.println("----------------------------------------------------------");
		}
	}
}
