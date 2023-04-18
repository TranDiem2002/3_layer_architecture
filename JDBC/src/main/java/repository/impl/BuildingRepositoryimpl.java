package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.BuildingRequest.BuildingRequest;
import repository.BuildingRepository;
import repository.entity.DistrictEntity;
import repository.entity.buildingEntity;
import untils.getConnection;
import untils.isNullorEmpty;

public class BuildingRepositoryimpl implements BuildingRepository {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	getConnection conn = new getConnection();

	public List<Long> buildingTypes(BuildingRequest building) {
		List<Long> idBuilding = new ArrayList<>();
		try {
			connection = conn.getconnection();
			StringBuilder query = new StringBuilder("select buildingid from buildingrenttype");
			query.append(" join renttype on renttype.id = buildingrenttype.renttypeid where ");
			for (int i = 0; i < building.getTypes().size(); i++) {
				if (i > 0) {
					query.append(" or ");
				}
				query.append("code like '" + building.getTypes().get(i) + "'");
			}
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				idBuilding.add(resultSet.getLong("buildingid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idBuilding;
	}

	public List<DistrictEntity> nameDistrict() {
		List<DistrictEntity> districts = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder("select *from district ");
			connection = conn.getconnection();
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DistrictEntity district = new DistrictEntity();
				district.setIdDistrict(resultSet.getLong("idDistrict"));
				district.setCode(resultSet.getString("code"));
				district.setNameDistrict(resultSet.getString("nameDistrict"));
				districts.add(district);
			}
			return districts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public void buildingJoin(BuildingRequest building, StringBuilder query) {
		if (isNullorEmpty.check(building.getManager())) {
			query.append(" join (select buildingid from assignmentbuilding where ");
			query.append("staffid = (select id from users where username like '%" + building.getManager() + "%')) as buildingM");
			query.append(" on buildingM.buildingid = building.id");
		}
		if(!isNullorEmpty.checkInt(building.getStaff())) {
			query.append(" join (select buildingid from assignmentbuilding where ");
			query.append(" staffid = "+building.getStaff()+") as buildingS on building.id = buildingS.buildingid");
		}

	}

	public void buildingNoJoin(BuildingRequest building, List<Long> idBuilding, StringBuilder query) {
		if (idBuilding.size() > 0) {
			query.append(" and ");
			for (int i = 0; i < idBuilding.size(); i++) {
				if (i > 0) {
					query.append(" or ");
				}
				query.append(" id = " + idBuilding.get(i));
			}
		}
		if (isNullorEmpty.check(building.getName())) {
			query.append(" and name like'%" + building.getName() + "%'");
		}
		if (!isNullorEmpty.checkInt(building.getFloorarea())) {
			query.append(" and floorarea = " + building.getFloorarea());
		}
		if (isNullorEmpty.check(building.getWard())) {
			query.append(" and ward like N'%" + building.getWard() + "%'");
		}
		if (!isNullorEmpty.checkInt(Integer.parseInt(building.getDistrictid().toString()))) {
			query.append(" and districtid = " + building.getDistrictid());
		}
		if (isNullorEmpty.check(building.getStreet())) {
			query.append(" and street like N'%" + building.getStreet() + "%'");
		}
		if (!isNullorEmpty.checkInt(building.getNumberofbasement())) {
			query.append(" and numberofbasement = " + building.getNumberofbasement());
		}
		if (isNullorEmpty.check(building.getDirection())) {
			query.append(" and direction like N'%" + building.getDirection() + "%'");
		}
		if (isNullorEmpty.check(building.getLevel())) {
			query.append(" and level = " + building.getLevel());
		}

	}

	public List<buildingEntity> findSearch(BuildingRequest building) {
		List<buildingEntity> building_entities = new ArrayList<>();
		List<Long> idBuilding = new ArrayList<>();
		StringBuilder querySearch = new StringBuilder("select * from building");
		try {
			connection = conn.getconnection();
			querySearch.append(" join district on building.districtid = district.idDistrict");
			buildingJoin(building, querySearch);
			//System.out.println(querySearch);
			if (building.getTypes().size() > 0) {
				idBuilding = buildingTypes(building);
			}
			querySearch.append(" where 1=1");
			buildingNoJoin(building, idBuilding, querySearch);
			//System.out.println(querySearch);
			preparedStatement = connection.prepareStatement(querySearch.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				buildingEntity building_entity = new buildingEntity();
				building_entity.setId(resultSet.getLong("id"));
				building_entity.setName(resultSet.getString("name"));
				building_entity.setStreet(resultSet.getString("street"));
				building_entity.setWard(resultSet.getString("ward"));
				building_entity.setDistrictid(resultSet.getLong("districtid"));
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
