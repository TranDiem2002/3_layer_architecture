package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.BuildingDao;
import DaoBuildingData.BuildingData;
import Model.BuildingModel;
import untils.getConnection;

public class BuildingDaoimpl implements BuildingDao {

	public List<BuildingData> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingData> buildingDatas= new ArrayList<>();
		try {
			connection = conn.getconnection();
			String query = "select * from building";
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingData buildingData = new BuildingData();
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public List<BuildingData> findSearch(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingData> buildingDatas = new ArrayList<>();
		try {
			connection = conn.getconnection();
			StringBuilder query = new StringBuilder( "select * from building where names like '%"+name+"%'");
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingData buildingData = new BuildingData();
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
