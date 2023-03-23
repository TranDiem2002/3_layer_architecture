package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import repository.DistrictRepository;
import untils.getConnection;

public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public String findName(Long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		String nameWard = null;
		try {
			connection = conn.getconnection();
			String query = "select *from district where id = " + id;
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
					nameWard = resultSet.getString("name");
					//System.out.println(nameWard);
			}
			return nameWard;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
