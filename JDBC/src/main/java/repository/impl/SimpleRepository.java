package repository.impl;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;

import Model.BuildingModel;
import repository.JpaRepository;
import repository.annotation.Column;
import repository.annotation.Entity;
import repository.annotation.Table;
import repository.entity.BuildingEntity;
import untils.getConnection;
import untils.isNullorEmpty;

public class SimpleRepository<T> implements JpaRepository<T> {

	@Override
	public List<T> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		getConnection conn = new getConnection();
		List<T> results = new ArrayList<>();
		Class<T> tClass = (Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
		String tableName = "";
		if (tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		try {
			connection = conn.getconnection();
			String query = "select * from " + tableName;
			preparedStatement = connection.prepareStatement(query.toString());
			rs = preparedStatement.executeQuery();

			ResultSetMetaData resultSetMetaData = rs.getMetaData();//the description of this ResultSet object's columns
			Field[] fields = tClass.getDeclaredFields();// số filed tương ứng với bảng đó dưới databse 
			while (rs.next()) {
				T object = tClass.newInstance();
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
					String columnName = resultSetMetaData.getColumnName(i + 1);
					Object columnValue = rs.getObject(i + 1);
					for (Field field : fields) {
						if (field.isAnnotationPresent(Column.class)) {
							Column column = field.getAnnotation(Column.class);
							if (column.name().equals(columnName) && columnValue != null) {
								BeanUtils.setProperty(object, field.getName(), columnValue);
								break;
							}
						}
					}
				}
				results.add(object);
			}
			return results;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return new ArrayList<>();
	}
	
	
	
	
//	public List<BuildingEntity> findAll() {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		getConnection conn = new getConnection();
//		List<BuildingEntity> buildingDatas = new ArrayList<>();
//		try {
//			connection = conn.getconnection();
//			String query = "select * from building";
//			preparedStatement = connection.prepareStatement(query.toString());
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				BuildingEntity buildingData = new BuildingEntity();
//				buildingData.setName(resultSet.getString("names"));
//				buildingData.setNumberofbasement(resultSet.getInt("numberofbasement"));
//				buildingData.setFloorerea(resultSet.getInt("floorarea"));
//				buildingData.setStreet(resultSet.getString("street"));
//				buildingData.setTypes(resultSet.getString("types"));
//				buildingDatas.add(buildingData);
//			}
//			return buildingDatas;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//				preparedStatement.close();
//				resultSet.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return new ArrayList<>();
//	}

//	@Override
//	public List<BuildingEntity> findSearch(BuildingModel building) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		getConnection conn = new getConnection();
//		List<BuildingEntity> buildingDatas = new ArrayList<>();
//		try {
//			connection = conn.getconnection();
//			StringBuilder query = new StringBuilder("select * from building where 1= 1 ");
//			if (isNullorEmpty.check(building.getName())) {
//				query.append("and names like'%" + building.getName() + "%'");
//				// query.append("and names like ?");
//			}
//			if (building.getNumberofbasement() != null) {
//				query.append("and numberofbasement = " + building.getNumberofbasement() + "");
//				// query.append("and numberofbasement = ?");
//			}
//			System.out.println(query);
//			preparedStatement = connection.prepareStatement(query.toString());
////			preparedStatement.setString(1, "'%" + building.getName() + "%'");
////			preparedStatement.setInt(2, building.getNumberofbasement());
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				BuildingEntity buildingData = new BuildingEntity();
//				buildingData.setName(resultSet.getString("names"));
//				buildingData.setNumberofbasement(resultSet.getInt("numberofbasement"));
//				buildingData.setFloorerea(resultSet.getInt("floorarea"));
//				buildingData.setStreet(resultSet.getString("street"));
//				//buildingData.setTypes(resultSet.getString("types"));
//				buildingDatas.add(buildingData);
//			}
//			return buildingDatas;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//				preparedStatement.close();
//				resultSet.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return new ArrayList<>();
//	}

	
}
