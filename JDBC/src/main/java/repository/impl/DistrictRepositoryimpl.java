package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import repository.DistrictRepository;
import repository.entity.districtEntity;
import untils.getConnection;

public class DistrictRepositoryimpl implements DistrictRepository {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	getConnection conn = new getConnection();

	@Override
	public districtEntity findDistrictID(Long id) {
		districtEntity district = new districtEntity();
		try {
			StringBuilder query = new StringBuilder("select *from district where idDistrict =  " + id);
			connection = conn.getconnection();
			// System.out.println(query);
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				district.setIdDistrict(resultSet.getLong("idDistrict"));
				district.setCode(resultSet.getString("code"));
				district.setNameDistrict(resultSet.getString("nameDistrict"));
			}
			return district;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
