package repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import Model.BuildingModel;
import repository.BuildingRepository;
import repository.annotation.Column;
import repository.entity.BuildingEntity;
import untils.getConnection;
import untils.isNullorEmpty;

public class BuildingRepositoryimpl extends SimpleRepository<BuildingEntity> implements BuildingRepository {

	public List<BuildingEntity> findSearch(BuildingModel building) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		getConnection conn = new getConnection();
		List<BuildingEntity> buildingDatas = new ArrayList<>();
		try {
			connection = conn.getconnection();
			StringBuilder query = new StringBuilder("select * from building where 1= 1 ");
			if (isNullorEmpty.check(building.getName())) {
				query.append(" and name like'%" + building.getName() + "%'");
			}
			if (building.getfloorarea() != null) {
				query.append(" and floorarea = " + building.getfloorarea());
			}
			if(building.getDistrictid() != null) {
				query.append(" and districtid = "+ building.getDistrictid());
			}
			if (isNullorEmpty.check(building.getward())) {
				query.append(" and ward like N'%" + building.getward() + "%'");
			}
			if(isNullorEmpty.check(building.getStreet())) {
				query.append(" and street like N'%"+ building.getStreet() +"%'");
			}
			if (building.getNumberofbasement() != null) {
				 query.append(" and numberofbasement = " + building.getNumberofbasement());
			}
			if(isNullorEmpty.check(building.getDirection())) {
				query.append(" and direction like N'%"+ building.getDirection() +"%'");
			}
			if (building.getLevel() != null) {
				 query.append(" and level = " + building.getLevel());
			}
			//System.out.println(query);
			stmt = connection.prepareStatement(query.toString());
			resultSet = stmt.executeQuery();
			ResultSetMetaData resultSetMetaData =resultSet.getMetaData();
			Field[] fields = BuildingEntity.class.getDeclaredFields();
			while (resultSet.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
					String columnName = resultSetMetaData.getColumnName(i + 1);
					Object columnValue = resultSet.getObject(i + 1);
					for (Field field : fields) {
						if (field.isAnnotationPresent(Column.class)) {
							Column column = field.getAnnotation(Column.class);
							if (column.name().equals(columnName) && columnValue != null) {
								BeanUtils.setProperty(buildingEntity, field.getName(), columnValue);
								break;
							}
						}
					}
				}
				System.out.println(buildingEntity.getDistrictid());
			 buildingDatas.add(buildingEntity);
			}
			return buildingDatas;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return new ArrayList<>();
	}

}
