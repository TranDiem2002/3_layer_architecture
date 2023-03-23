package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import repository.renttype;
import untils.getConnection;

public class renttypeImpl implements renttype {

	

	@Override
	public List<Long> findIdTypes(String code) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<Long> codes = new ArrayList<>();
		String[] types = code.split(",");
		StringBuilder query = new StringBuilder("select * from renttype where code like '%" + types[0] + "%'");
		try {
			for (int i = 1; i < types.length; i++) {
				query.append(" or code like '%" + types[i] + "%'");
			}
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				codes.add(resultSet.getLong("id"));
				System.out.println(resultSet.getLong("id"));
			}
			return codes;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@Override
	public List<Long> findIdBuilding(List<Long> idTypes) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			getConnection conn = new getConnection();
		List<Long> ids = new ArrayList<>();
			try {
				connection = conn.getconnection();
				String query = "select *from renttype where code like '%" +idTypes.get(0);
				System.out.println(query);
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
						ids.add(resultSet.getLong("id"));
						System.out.println(resultSet.getLong("id"));
				}
				return ids;
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
