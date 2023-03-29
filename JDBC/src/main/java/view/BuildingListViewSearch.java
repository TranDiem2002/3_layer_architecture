package view;

import java.util.List;
import java.util.Scanner;

import Controller.BuildingController;
import Model.BuildingReponse.BuildingReponse;

public class BuildingListViewSearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
//		System.out.println("Tên tòa nhà: ");
//		String name = input.nextLine();
//		System.out.println("Diện tích sàn: ");
//		int dientichsan = input.nextInt();
		System.out.println("Quận: ");
		Long quan = input.nextLong();
//		System.out.println("Phường: ");
//		String phuong = scanner.nextLine();
//		System.out.println("Đường: ");
//		String duong =scanner.nextLine();
//		System.out.println("số tầng hầm: ");
//		int sotang =scanner.nextInt();
//		System.out.println("Nhập hướng: ");
//		String huong =sc1.nextLine();
//		System.out.println("Nhập hạng: ");
//		String hang =sc1.nextLine();
//		System.out.println("Loai toa nhà: ");
//		String loaitoanha = sc.nextLine();
//		System.out.println(" nhap dien tich thue: ");
//		String dientich = sc.nextLine();
//		System.out.println("Nhập tên quản lý");
//		String quanly = sc1.nextLine();
//		System.out.println("Nhập mã nhân viên: ");
//		Integer maNV = sc1.nextInt();
		
	//String name,Integer floorArea,Long districtid, String street, Integer numberofbasement, String direction, Integer level,String ward, String types, String rentArea
		//String manager, Integer staff 
		
		
		BuildingController buildingController = new BuildingController();
		List<BuildingReponse> buildingReponses = buildingController.findSearch(null,null,quan,null,null,null,null,null,null,null,null,null);
		for (BuildingReponse building : buildingReponses) {
			System.out.println("ID: "+ building.getId());
			System.out.println("Tên tòa nhà: "+building.getName());
			System.out.println("Địa chỉ: " + building.getAddress());	
			System.out.println("Số lượng tầng hầm: "+ building.getNumberofbasement());
			System.out.println("Giá thuê: "+building.getRentprice());
			System.out.println("Phí dịch vụ: "+building.getServicefree());
			System.out.println("Phí môi giới:  "+building.getBrokeragefree());
			System.out.println("----------------------------------------------------------");
		}
	}
}
