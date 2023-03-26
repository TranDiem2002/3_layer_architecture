package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.BuildingRequest.BuildingRequest;
import repository.BuildingRepository;
import repository.entity.Building_entity;
import untils.SplitString;
import untils.getConnection;
import untils.isNullorEmpty;

public class BuildingRepositoryimpl implements BuildingRepository {

	public void buildingJoin(BuildingRequest building, StringBuilder querySearch) {
		if (building.getDistrictid() != null) {
			querySearch.append(" join district on building.districtid = district.idDistrict");
		}
		if (isNullorEmpty.check(building.getTypes())) {
			List<String> type = SplitString.sp(building.getTypes());
			querySearch.append(" join (select distinct buildingid from buildingrenttype");
			querySearch.append(" join (select id from renttype where code like'%" + type.get(0) + "%'");
			if(type.size()>1) {
				for (int i = 1; i < type.size(); i++) {
				querySearch.append(" or code like'%" + type.get(i) + "%'");
			}
			}
			querySearch.append(
					") as idtype on buildingrenttype.renttypeid = idtype.id) as buildingID on building.id = buildingID.buildingid");
		}
		if (isNullorEmpty.check(building.getRentarea())) {
			List<String> renareas = SplitString.sp(building.getRentarea());
			querySearch.append(" join(select distinct buildingid from rentarea where 1=1");
			int x = Integer.parseInt(renareas.get(0));
			int y = Integer.parseInt(renareas.get(1));
			if (x != 0) {
				querySearch.append(" and value >=" + x);
			}
			if (y != 0) {
				querySearch.append(" and value <=" + y);
			}
			querySearch.append(")as idrentarea on building.id = idrentarea.buildingid");
		}
	}

	public void buildingNoJoin(BuildingRequest building, StringBuilder query) {
		if (!building.getName().isEmpty() && building.getName() != null) {
			query.append(" and name like'%" + building.getName() + "%'");
		}
		if (building.getFloorarea() != null) {
			query.append(" and floorarea = " + building.getFloorarea());
		}
		if (building.getDistrictid() != null) {
			query.append(" and districtid = " + building.getDistrictid());
		}
		if (!building.getStreet().isEmpty() && building.getStreet() != null) {
			query.append(" and street like N'%" + building.getStreet() + "%'");
		}
		if (building.getNumberofbasement() != null) {
			query.append(" and numberofbasement = " + building.getNumberofbasement());
		}
		if (!building.getDirection().isEmpty() && building.getDirection() != null) {
			query.append(" and direction like N'%" + building.getDirection() + "%'");
		}
		if (building.getLevel() != null) {
			query.append(" and level = " + building.getLevel());
		}
	}

	public List<Building_entity> findSearch(BuildingRequest building) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<Building_entity> building_entities = new ArrayList<>();
		StringBuilder querySearch = new StringBuilder("select * from building");	
		try {
			connection = conn.getconnection();
			buildingJoin(building, querySearch);
			querySearch.append(" where 1=1");
			buildingNoJoin(building, querySearch);
			System.out.println(querySearch);
			preparedStatement = connection.prepareStatement(querySearch.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Building_entity building_entity = new Building_entity();
				building_entity.setId(resultSet.getLong("id"));;
				building_entity.setName(resultSet.getString("name"));
				building_entity.setStreet(resultSet.getString("street"));
				building_entity.setWard(resultSet.getString("ward"));
				building_entity.setDistrictName(resultSet.getString("nameDistrict"));
				building_entity.setRentprice(resultSet.getInt("rentprice"));
				building_entity.setServicefee(resultSet.getString("servicefee"));
				building_entity.setBrokeragefee(resultSet.getString("brokeragefee"));
				building_entity.setNumberofbasement(resultSet.getInt("numberofbasement"));
				building_entities.add(building_entity);
			}
			return building_entities;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();

	}

}
