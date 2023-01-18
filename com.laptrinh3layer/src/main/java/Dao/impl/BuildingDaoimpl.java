package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.BuildingDao;
import Dao.xulyDL.BuildingxulyDL;

public class BuildingDaoimpl implements BuildingDao {

	public BuildingxulyDL[] findAll(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();

		try {
			connection = conn.getconnection();
			String query = "select * from building where names like '% " + name + "'";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			BuildingxulyDL[] buildingxulyDL = new BuildingxulyDL[] {};
			int i = 0;
			while (resultSet.next()) {
				BuildingxulyDL buildingxuly = new BuildingxulyDL();
				buildingxuly.setName(resultSet.getString(2));
				buildingxulyDL[i] = buildingxuly;
				i++;
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