package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.BuildingDao;
import Model.BuildingModel;

public class BuildingDaoimpl implements BuildingDao {

	public List<BuildingModel> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingModel> buildingModels = new ArrayList<>();
		try {
			connection = conn.getconnection();
			String query = "select * from building";
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingModel buildingModel= new BuildingModel();
				buildingModel.setName(resultSet.getString("names"));
				buildingModel.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingModel.setFloorerea(resultSet.getInt("floorarea"));
				buildingModel.setStreet(resultSet.getString("street"));
				buildingModel.setTypes(resultSet.getString("types"));
				buildingModels.add(buildingModel);
			}
			return buildingModels;

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
	public List<BuildingModel> findSearch(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingModel> buildingModels = new ArrayList<>();
		try {
			connection = conn.getconnection();
			String query = "select * from building where names like '%"+name+"%'";
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingModel buildingModel= new BuildingModel();
				buildingModel.setName(resultSet.getString("names"));
				buildingModel.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingModel.setFloorerea(resultSet.getInt("floorarea"));
				buildingModel.setStreet(resultSet.getString("street"));
				buildingModel.setTypes(resultSet.getString("types"));
				buildingModels.add(buildingModel);
			}
			return buildingModels;

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
