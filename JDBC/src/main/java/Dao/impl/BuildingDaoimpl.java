package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BuildingEntity.BuildingEntity;
import Dao.BuildingDao;
import Model.BuildingModel;
import untils.getConnection;
import untils.isNullorEmpty;

public class BuildingDaoimpl implements BuildingDao {

	public List<BuildingEntity> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingEntity> buildingDatas = new ArrayList<>();
		try {
			connection = conn.getconnection();
			String query = "select * from building";
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingEntity buildingData = new BuildingEntity();
				buildingData.setName(resultSet.getString("names"));
				buildingData.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingData.setFloorerea(resultSet.getInt("floorarea"));
				buildingData.setStreet(resultSet.getString("street"));
				buildingData.setTypes(resultSet.getString("types"));
				buildingDatas.add(buildingData);
			}
			return buildingDatas;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return buildingDatas;
	}

	@Override
	public List<BuildingEntity> findSearch(BuildingModel building) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingEntity> buildingDatas = new ArrayList<>();
		try {
			connection = conn.getconnection();
			StringBuilder query = new StringBuilder("select * from building where 1= 1 ");
			if (!isNullorEmpty.check(building.getName())) {
				query.append("and names like'%" + building.getName() + "%'");
			}
			if (building.getNumberofbasement() != null) {
				query.append("and numberofbasement = " + building.getNumberofbasement() + "");
			}
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingEntity buildingData = new BuildingEntity();
				buildingData.setName(resultSet.getString("names"));
				buildingData.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingData.setFloorerea(resultSet.getInt("floorarea"));
				buildingData.setStreet(resultSet.getString("street"));
				buildingData.setTypes(resultSet.getString("types"));
				buildingDatas.add(buildingData);
			}
			return buildingDatas;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return buildingDatas;
	}

}
