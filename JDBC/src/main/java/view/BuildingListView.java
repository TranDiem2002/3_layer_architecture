package view;

import java.util.List;
import java.util.Scanner;

import Controller.BuildingController;
import Model.BuildingModel;

public class BuildingListView {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ten toa nha: ");
		String name = input.nextLine();
		BuildingController buildingController = new BuildingController();
		List<BuildingModel> buildingModels = buildingController.findAll(name);
		for (BuildingModel buildingModel : buildingModels) {
			System.out.println("Ten toa nha: "+buildingModel.getName());
		}
		input.close();
	}
}
