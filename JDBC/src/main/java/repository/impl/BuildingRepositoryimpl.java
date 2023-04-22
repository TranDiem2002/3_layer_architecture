package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Model.BuildingRequest.BuildingRequest;
import repository.BuildingRepository;
import repository.entity.buildingEntity;
import untils.getConnection;
import untils.isNullorEmpty;

public class BuildingRepositoryimpl implements BuildingRepository {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	getConnection conn = new getConnection();

	public void buildingJoin(Map<String, Object> map, List<String> types, StringBuilder query) {

		if (types.size() > 0) {
			query.append(
					" join (select renttype.id,name,buildingid,renttypeid from renttype join buildingrenttype on renttypeid = renttype.id where 1 =1 ");
			for (int i = 0; i < types.size(); i++) {
				if (i == 0) {
					query.append(" and ");
				}
				if (i > 0) {
					query.append(" or ");
				}
				query.append("  code like '%" + types.get(i) + "%' ");
			}
			query.append(" )as type on building.id = type.buildingid ");
		}
		if (isNullorEmpty.check(map.get("manager").toString())) {
			query.append(" join (select buildingid from assignmentbuilding where ");
			query.append("staffid = (select id from users where username like '%" + map.get("manager")
					+ "%')) as buildingM");
			query.append(" on buildingM.buildingid = building.id");
		}
		if (!isNullorEmpty.checkInt(Integer.parseInt(map.get("staff").toString()))) {
			query.append(" join (select buildingid from assignmentbuilding where ");
			query.append(" staffid = " + map.get("staff") + ") as buildingS on building.id = buildingS.buildingid");
		}
	}

	public void buildingNoJoin(Map<String, Object> map, List<String> types, StringBuilder query) {
		Set set = map.keySet();
		for (Object key : set) {
			if (key.equals("name") || key.equals("ward")|| key.equals("street")  || key.equals("level") || key.equals( "direction")
					|| key.equals("manager")) {
				if (isNullorEmpty.check(map.get(key).toString())) {
					query.append(" and building." + key + " like '%" + map.get(key) + "%'");
				}
				if (key.equals("floorarea") || key.equals("numberofbasement")) {
					if (!isNullorEmpty.checkInt(Integer.parseInt(map.get(key).toString()))) {
						query.append(" and " + key + " =" + map.get(key));
					}
				}
				if (key.equals("idDistrict")) {
					if (!isNullorEmpty.checkInt(Integer.parseInt(map.get(key).toString()))) {
						query.append(" and districtid =" + map.get(key));
					}
				}
			}
		}
	}

	@Override
	public List<buildingEntity> findSearch(Map<String, Object> map, List<String> types) {
		List<buildingEntity> buildingEntities = new ArrayList<>();
		StringBuilder querySearch = new StringBuilder("select * from building ");
		try {
			connection = conn.getconnection();
			buildingJoin(map, types, querySearch);
			querySearch.append(" where 1=1 ");
			buildingNoJoin(map, types, querySearch);
			//System.out.println(querySearch);
			preparedStatement = connection.prepareStatement(querySearch.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				buildingEntity buildingEntity = new buildingEntity();
				buildingEntity.setId(resultSet.getLong("id"));
				buildingEntity.setName(resultSet.getString("name"));
				buildingEntity.setStreet(resultSet.getString("street"));
				buildingEntity.setWard(resultSet.getString("ward"));
				buildingEntity.setDistrictid(resultSet.getLong("districtid"));
				buildingEntity.setRentprice(resultSet.getInt("rentprice"));
				buildingEntity.setServicefee(resultSet.getString("servicefee"));
				buildingEntity.setBrokeragefee(resultSet.getString("brokeragefee"));
				buildingEntity.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingEntities.add(buildingEntity);
			}
			return buildingEntities;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();

	}

}
