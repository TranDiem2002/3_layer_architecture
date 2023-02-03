package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.BuildingDao;
import Dao.xulyDL.BuildingxulyDL;
import constant.SystemConstant;
import utils.StringUtils;

public class BuildingDaoimpl implements BuildingDao {

	public List<BuildingxulyDL> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingxulyDL> buildingxulyDL = new ArrayList<>();
		try {
			connection = conn.getconnection();
			String query = "select * from building";
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingxulyDL buildingxuly = new BuildingxulyDL();
				buildingxuly.setName(resultSet.getString("names"));
				buildingxuly.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingxuly.setFloorerea(resultSet.getInt("floorarea"));
				buildingxuly.setStreet(resultSet.getString("street"));
				buildingxuly.setTypes(resultSet.getString("types"));
				buildingxulyDL.add(buildingxuly);
			}
			return buildingxulyDL;

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
	public List<BuildingxulyDL> findSearch(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingxulyDL> buildingxulyDL = new ArrayList<>();
		try {
			connection = conn.getconnection();
			String query = "select * from building where names like '%"+name+"%'";
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BuildingxulyDL buildingxuly = new BuildingxulyDL();
				buildingxuly.setName(resultSet.getString("names"));
				buildingxuly.setNumberofbasement(resultSet.getInt("numberofbasement"));
				buildingxuly.setFloorerea(resultSet.getInt("floorarea"));
				buildingxuly.setStreet(resultSet.getString("street"));
				buildingxuly.setTypes(resultSet.getString("types"));
				buildingxulyDL.add(buildingxuly);
			}
			return buildingxulyDL;

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
