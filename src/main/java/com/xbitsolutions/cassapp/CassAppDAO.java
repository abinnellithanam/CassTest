package com.xbitsolutions.cassapp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CassAppDAO {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:/home/cadmium/Desktop/cassAppSwing/cass.db";
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				// System.out.println("Connected to the database");
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				// System.out.println("Driver name: " + dm.getDriverName());
				// System.out.println("Driver version: " + dm.getDriverVersion());
				// System.out.println("Product name: " + dm.getDatabaseProductName());
				// System.out.println("Product version: " + dm.getDatabaseProductVersion());
				// System.out.println("User Name: " + dm.getUserName());
				return conn;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public List<Map<String, Serializable>> getCropsList() {
		List<Map<String, Serializable>> cropList = new ArrayList<Map<String, Serializable>>();
		CassAppDAO cassAppDao = new CassAppDAO();
		Connection conn = cassAppDao.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.getCrops);
			while (rs.next()) {
				Map<String, Serializable> cropMap = new HashMap<String, Serializable>();
				cropMap.put("cropName", rs.getString("fld_crop_name"));
				cropMap.put("cropId", rs.getInt("fld_crop_id"));
				cropList.add(cropMap);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cropList;
	}

	public List<Map<String, Serializable>> getStateList() {
		List<Map<String, Serializable>> stateList = new ArrayList<Map<String, Serializable>>();
		CassAppDAO cassAppDao = new CassAppDAO();
		Connection conn = cassAppDao.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.getStates);
			while (rs.next()) {
				Map<String, Serializable> stateMap = new HashMap<String, Serializable>();
				stateMap.put("stateName", rs.getString("fld_state_name"));
				stateMap.put("stateId", rs.getInt("fld_state_id"));
				stateList.add(stateMap);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stateList;
	}
	
	public List<Map<String, Serializable>> getRfIrrStateList(int cropId) {
		List<Map<String, Serializable>> rfIrrStateList = new ArrayList<Map<String, Serializable>>();
		CassAppDAO cassAppDao = new CassAppDAO();
		Connection conn = cassAppDao.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(Query.getRfIrrStates);
			preparedStatement.setInt(1, cropId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Map<String, Serializable> rfIrrStateMap = new HashMap<String, Serializable>();
				rfIrrStateMap.put("stateName", rs.getString("fld_state_name"));
				rfIrrStateMap.put("stateId", rs.getInt("fld_state_id"));
				rfIrrStateMap.put("rfIrrStateId", rs.getInt("fld_rf_irr_state_id"));
				rfIrrStateMap.put("isRforIrr", rs.getInt("fld_rf_irr"));
				rfIrrStateMap.put("cropId", rs.getInt("fld_crop_id"));
				rfIrrStateMap.put("cropName", rs.getString("fld_crop_name"));
				rfIrrStateList.add(rfIrrStateMap);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rfIrrStateList;
	}

	public List<Map<String, Serializable>> getDistrictList(int stateId) {
		List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
		CassAppDAO cassAppDao = new CassAppDAO();
		Connection conn = cassAppDao.getConnection();
		PreparedStatement prpdStmt = null;
		try {
			prpdStmt = conn.prepareStatement(Query.getDistricts);
			prpdStmt.setInt(1, stateId);
			ResultSet rs = prpdStmt.executeQuery();
			while (rs.next()) {
				Map<String, Serializable> districtMap = new HashMap<String, Serializable>();
				districtMap.put("districtName", rs.getString("fld_district_name"));
				districtMap.put("districtId", rs.getInt("fld_district_id"));
				districtList.add(districtMap);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				prpdStmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return districtList;
	}

	public List<Map<String, Serializable>> getFertTypeList() {
		List<Map<String, Serializable>> fertTypeList = new ArrayList<Map<String, Serializable>>();
		CassAppDAO cassAppDao = new CassAppDAO();
		Connection conn = cassAppDao.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Query.getFertilizerTypes);
			while (rs.next()) {
				Map<String, Serializable> fertTypeMap = new HashMap<String, Serializable>();
				fertTypeMap.put("fertTypeName", rs.getString("fld_fert_name"));
				fertTypeMap.put("fertTypeId", rs.getInt("fld_fert_tpe_id"));
				fertTypeList.add(fertTypeMap);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fertTypeList;
	}

	public List<Map<String, Serializable>> getCropsList(int stateId) {
		List<Map<String, Serializable>> cropList = new ArrayList<Map<String, Serializable>>();
		CassAppDAO cassAppDao = new CassAppDAO();
		Connection conn = cassAppDao.getConnection();
		PreparedStatement prpdStmt = null;
		try {
			prpdStmt = conn.prepareStatement(Query.getStateCrops);
			prpdStmt.setInt(1, stateId);
			ResultSet rs = prpdStmt.executeQuery();
			while (rs.next()) {
				Map<String, Serializable> cropMap = new HashMap<String, Serializable>();
				cropMap.put("cropName", rs.getString("fld_crop_name"));
				cropMap.put("cropId", rs.getInt("fld_crop_id"));
				cropList.add(cropMap);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				prpdStmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cropList;
	}

	public int addYieldTarget(int stateId, Map<String, Object> yieldTargetMap) {
		int isInsertSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) yieldTargetMap.get("isRfOrIrr"), (Integer) yieldTargetMap.get("cropId"));
		if (rfIrrStateId != 0) {
			if ((Integer) yieldTargetMap.get("isApplyToAllDists") == 1) {
				System.out.print("cropId : " + (Integer) yieldTargetMap.get("cropId") + " | ");
				System.out.println("stateId : " + stateId);
				List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
				districtList = getDistrictList(stateId);
				for (Map<String, Serializable> districtMap : districtList) {
					System.out.print("districtId : " + (Integer) districtMap.get("districtId") + " | ");
					isInsertSuccessfull = addYieldTarget(stateId, (Integer) districtMap.get("districtId"), rfIrrStateId, (Integer) yieldTargetMap.get("cropId"), (Integer) yieldTargetMap.get("yieldTarget"));
					System.out.println("yieldTarget : " + (Integer) yieldTargetMap.get("yieldTarget"));
				}
			} else if ((Integer) yieldTargetMap.get("isApplyToAllDists") == 0) {
				System.out.println("Error");
				System.out.print("districtId : " + (Integer) yieldTargetMap.get("districtId") + " | ");
				System.out.println("yieldTarget : " + (Integer) yieldTargetMap.get("yieldTarget"));
				isInsertSuccessfull = addYieldTarget(stateId, (Integer) yieldTargetMap.get("districtId"), rfIrrStateId, (Integer) yieldTargetMap.get("cropId"), (Integer) yieldTargetMap.get("yieldTarget"));
			}
		}
		return isInsertSuccessfull;
	}

	public int addYieldTarget(int stateId, int districtId, int rfIrrStateId, int cropId, int yieldTarget) {
		Connection connection = getConnection();
		int isInsertSuccessfull = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.addyieldTarget);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, cropId);
			preparedStatement.setInt(4, districtId);
			preparedStatement.setInt(5, yieldTarget);
			isInsertSuccessfull = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isInsertSuccessfull;
	}

	public int getRfIrrStateId(int stateId, int isRfOrIrr, int cropId) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		int rfIrrStateId = 0;
		try {
			preparedStatement = connection.prepareStatement(Query.getRfIrrId);
			preparedStatement.setInt(1, stateId);
			preparedStatement.setInt(2, isRfOrIrr);
			preparedStatement.setInt(3, cropId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				rfIrrStateId = resultSet.getInt("fld_rf_irr_state_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rfIrrStateId;
	}

	public int addSoilTestResult(int rfIrrStateId, int stateId, int sFertTypeId, int cropId, int districtId, String soilTestResult) {
		int isInsertSuccessfull = 0;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.addSoilTestResult);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, sFertTypeId);
			preparedStatement.setInt(4, cropId);
			preparedStatement.setInt(5, districtId);
			preparedStatement.setString(6, soilTestResult);
			preparedStatement.setInt(7, 1);
			isInsertSuccessfull = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isInsertSuccessfull;
	}

	public int addSoilTestResult(int stateId, Map<String, Object> soilTestResultMap) {
		int isInsertSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) soilTestResultMap.get("isRfOrIrr"), (Integer) soilTestResultMap.get("cropId"));
		if ((Integer) soilTestResultMap.get("isApplyToAllDists") == 1) {
			System.out.print("cropId : " + (Integer) soilTestResultMap.get("cropId") + " | ");
			System.out.println("stateId : " + stateId);
			List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
			districtList = getDistrictList(stateId);
			for (Map<String, Serializable> districtMap : districtList) {
				System.out.print("districtId : " + (Integer) districtMap.get("districtId") + " | ");
				isInsertSuccessfull = addSoilTestResult(rfIrrStateId, stateId, (Integer) soilTestResultMap.get("sFertTypeId"), (Integer) soilTestResultMap.get("cropId"), (Integer) districtMap.get("districtId"), (String) soilTestResultMap.get("soilTestResult"));
				System.out.println("sFertTypeId : " + (Integer) soilTestResultMap.get("sFertTypeId") + " | soilTestResult : " + (String) soilTestResultMap.get("soilTestResult"));
			}
		} else if ((Integer) soilTestResultMap.get("isApplyToAllDists") == 0) {
			System.out.println("Error");
			System.out.print("districtId : " + (Integer) soilTestResultMap.get("districtId") + " | ");
			System.out.println("sFertTypeId : " + (Integer) soilTestResultMap.get("sFertTypeId") + " | soilTestResult : " + (String) soilTestResultMap.get("soilTestResult"));
			isInsertSuccessfull = addSoilTestResult(rfIrrStateId, stateId, (Integer) soilTestResultMap.get("sFertTypeId"), (Integer) soilTestResultMap.get("cropId"), (Integer) soilTestResultMap.get("districtId"), (String) soilTestResultMap.get("soilTestResult"));
		}
		return isInsertSuccessfull;
	}

	public List<Map<String, Serializable>> getYieldTargetListForDistrict(int stateId, int isRfOrIrr, int cropId, int districtId) {
		List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			int rfIrrStateId = getRfIrrStateId(stateId, isRfOrIrr, cropId);
			preparedStatement = connection.prepareStatement(Query.getYieldTargetListForDistrict);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, cropId);
			preparedStatement.setInt(4, districtId);
			ResultSet resultSet = preparedStatement.executeQuery();
			// System.out.println("SELECT fld_yield_target_id,fld_yield_target FROM tbl_yield_target WHERE fld_rf_irr_state_id = " + rfIrrStateId + " AND fld_state_id = " + stateId + " AND fld_crop_id=" + cropId + " AND fld_district_id = " + districtId + ";");
			while (resultSet.next()) {
				Map<String, Serializable> yieldTargetMap = new HashMap<String, Serializable>();
				yieldTargetMap.put("yieldTargetId", resultSet.getString("fld_yield_target_id"));
				yieldTargetMap.put("yieldTarget", resultSet.getString("fld_yield_target"));
				yieldTargetMap.put("haveSoilTestResult", resultSet.getString("fld_have_soil_tst_rslt"));
				yieldTargetMap.put("cropName", resultSet.getString("fld_crop_name"));
				yieldTargetMap.put("districtName", resultSet.getString("fld_district_name"));
				yieldTargetMap.put("stateName", resultSet.getString("fld_state_name"));
				yieldTargetMap.put("rfIrrStateId", resultSet.getString("fld_rf_irr_state_id"));
				yieldTargetList.add(yieldTargetMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return yieldTargetList;
	}

	public List<Map<String, Serializable>> getYieldTargetListForState(int stateId, int isRfOrIrr, int cropId) {
		List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			int rfIrrStateId = getRfIrrStateId(stateId, isRfOrIrr, cropId);
			preparedStatement = connection.prepareStatement(Query.getYieldTargetListForState);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, cropId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, Serializable> yieldTargetMap = new HashMap<String, Serializable>();
				yieldTargetMap.put("yieldTargetId", resultSet.getString("fld_yield_target_id"));
				yieldTargetMap.put("yieldTarget", resultSet.getString("fld_yield_target"));
				yieldTargetMap.put("haveSoilTestResult", resultSet.getString("fld_have_soil_tst_rslt"));
				yieldTargetMap.put("cropName", resultSet.getString("fld_crop_name"));
				yieldTargetMap.put("districtName", resultSet.getString("fld_district_name"));
				yieldTargetMap.put("stateName", resultSet.getString("fld_state_name"));
				yieldTargetMap.put("rfIrrStateId", resultSet.getString("fld_rf_irr_state_id"));
				yieldTargetList.add(yieldTargetMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return yieldTargetList;
	}

	public List<Map<String, Serializable>> getYieldTargetList(Map<String, Object> yieldTargetFetchCriteriaMap) {
		List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
		if ((Integer) yieldTargetFetchCriteriaMap.get("isApplyToAllDists") == 1) {
			yieldTargetList = getYieldTargetListForState((Integer) yieldTargetFetchCriteriaMap.get("stateId"), (Integer) yieldTargetFetchCriteriaMap.get("isRfOrIrr"), (Integer) yieldTargetFetchCriteriaMap.get("cropId"));
		} else if ((Integer) yieldTargetFetchCriteriaMap.get("isApplyToAllDists") == 0) {
			yieldTargetList = getYieldTargetListForDistrict((Integer) yieldTargetFetchCriteriaMap.get("stateId"), (Integer) yieldTargetFetchCriteriaMap.get("isRfOrIrr"), (Integer) yieldTargetFetchCriteriaMap.get("cropId"), (Integer) yieldTargetFetchCriteriaMap.get("districtId"));
		}

		return yieldTargetList;
	}

	public List<Map<String, Serializable>> getSoilTestResultList(Map<String, Object> soilTestResultFetchCriteriaMap) {
		List<Map<String, Serializable>> soilTestResultList = new ArrayList<Map<String, Serializable>>();
		if ((Integer) soilTestResultFetchCriteriaMap.get("isApplyToAllDists") == 1) {
			soilTestResultList = getSoilTestResultListForState((Integer) soilTestResultFetchCriteriaMap.get("stateId"), (Integer) soilTestResultFetchCriteriaMap.get("isRfOrIrr"), (Integer) soilTestResultFetchCriteriaMap.get("cropId"), (Integer) soilTestResultFetchCriteriaMap.get("sFertTypeId"));
		} else if ((Integer) soilTestResultFetchCriteriaMap.get("isApplyToAllDists") == 0) {
			soilTestResultList = getSoilTestResultListForDistrict((Integer) soilTestResultFetchCriteriaMap.get("stateId"), (Integer) soilTestResultFetchCriteriaMap.get("isRfOrIrr"), (Integer) soilTestResultFetchCriteriaMap.get("cropId"), (Integer) soilTestResultFetchCriteriaMap.get("sFertTypeId"), (Integer) soilTestResultFetchCriteriaMap.get("districtId"));
		}
		return soilTestResultList;
	}

	private List<Map<String, Serializable>> getSoilTestResultListForDistrict(int stateId, int isRfOrIrr, int cropId, int sFertTypeId, int districtId) {
		List<Map<String, Serializable>> soilTestResultList = new ArrayList<Map<String, Serializable>>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			int rfIrrStateId = getRfIrrStateId(stateId, isRfOrIrr, cropId);
			preparedStatement = connection.prepareStatement(Query.getSoilTestResultListForDistrict);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, sFertTypeId);
			preparedStatement.setInt(4, cropId);
			preparedStatement.setInt(5, districtId);
			ResultSet resultSet = preparedStatement.executeQuery();
			// System.out.println("SELECT fld_sol_tst_rslt_id,fld_sol_tst_rslt,fld_have_soil_tst_rslt FROM tbl_soil_tst_rslt WHERE fld_rf_irr_state_id = " + rfIrrStateId + " AND fld_state_id = " + stateId + " AND fld_sfert_tpe_id = " + sFertTypeId + " AND fld_crop_id = " + cropId + " AND fld_district_id = " + districtId + "");
			while (resultSet.next()) {
				Map<String, Serializable> soilTestResultMap = new HashMap<String, Serializable>();
				soilTestResultMap.put("soilTestResultId", resultSet.getString("fld_sol_tst_rslt_id"));
				soilTestResultMap.put("soilTestResult", resultSet.getString("fld_sol_tst_rslt"));
				soilTestResultMap.put("haveSoilTestResult", resultSet.getString("fld_have_soil_tst_rslt"));
				soilTestResultMap.put("cropName", resultSet.getString("fld_crop_name"));
				soilTestResultMap.put("districtName", resultSet.getString("fld_district_name"));
				soilTestResultMap.put("stateName", resultSet.getString("fld_state_name"));
				soilTestResultMap.put("rfIrrStateId", resultSet.getString("fld_rf_irr_state_id"));
				soilTestResultList.add(soilTestResultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soilTestResultList;
	}

	private List<Map<String, Serializable>> getSoilTestResultListForState(int stateId, int isRfOrIrr, int cropId, int sFertTypeId) {
		List<Map<String, Serializable>> soilTestResultList = new ArrayList<Map<String, Serializable>>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			int rfIrrStateId = getRfIrrStateId(stateId, isRfOrIrr, cropId);
			preparedStatement = connection.prepareStatement(Query.getSoilTestResultListForState);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, sFertTypeId);
			preparedStatement.setInt(4, cropId);
			ResultSet resultSet = preparedStatement.executeQuery();
			// System.out.println("SELECT fld_sol_tst_rslt_id,fld_sol_tst_rslt,fld_have_soil_tst_rslt FROM tbl_soil_tst_rslt WHERE fld_rf_irr_state_id = " + rfIrrStateId + " AND fld_state_id = " + stateId + " AND fld_sfert_tpe_id = " + sFertTypeId + " AND fld_crop_id = " + cropId + "");
			while (resultSet.next()) {
				Map<String, Serializable> soilTestResultMap = new HashMap<String, Serializable>();
				soilTestResultMap.put("soilTestResultId", resultSet.getString("fld_sol_tst_rslt_id"));
				soilTestResultMap.put("soilTestResult", resultSet.getString("fld_sol_tst_rslt"));
				soilTestResultMap.put("haveSoilTestResult", resultSet.getString("fld_have_soil_tst_rslt"));
				soilTestResultMap.put("cropName", resultSet.getString("fld_crop_name"));
				soilTestResultMap.put("districtName", resultSet.getString("fld_district_name"));
				soilTestResultMap.put("stateName", resultSet.getString("fld_state_name"));
				soilTestResultMap.put("rfIrrStateId", resultSet.getString("fld_rf_irr_state_id"));
				soilTestResultList.add(soilTestResultMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soilTestResultList;
	}

	public int addFertRecomm(int stateId, Map<String, Object> fertRecommMap) {
		int isInsertSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"));
		if ((Integer) fertRecommMap.get("isApplyToAllDists") == 1) {
			List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
			districtList = getDistrictList(stateId);
			for (Map<String, Serializable> districtMap : districtList) {
				System.out.println(" | stateId : " + stateId + " | DistrictId : " + (Integer) districtMap.get("districtId") + " | cropId : " + (Integer) fertRecommMap.get("cropId") + " | isRfOrIrr : " + (Integer) fertRecommMap.get("isRfOrIrr") + "| rfIrrStateId : " + rfIrrStateId + " | sFertTypeId : " + (Integer) fertRecommMap.get("sFertTypeId"));
				List<Map<String, Serializable>> soilTestResultList = new ArrayList<Map<String, Serializable>>();
				List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
				int soilTestResultId = 0, yieldTargetId = 0;
				Map<String, Serializable> soilTestResultMap = new HashMap<String, Serializable>();
				Map<String, Serializable> yieldTargetIdMap = new HashMap<String, Serializable>();
				soilTestResultMap = getSoilTestResult((Integer) fertRecommMap.get("soilTestResultId"));
				yieldTargetIdMap = getYieldTarget((Integer) fertRecommMap.get("yieldTargetId"));
				// getSoilTestResultListForDistrict(int stateId, int isRfOrIrr, int cropId, int sFertTypeId, int districtId)
				soilTestResultList = getSoilTestResultListForDistrict(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"), (Integer) fertRecommMap.get("sFertTypeId"), (Integer) districtMap.get("districtId"));
				// getYieldTargetListForDistrict(int stateId, int isRfOrIrr, int cropId, int districtId)
				yieldTargetList = getYieldTargetListForDistrict(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"), (Integer) districtMap.get("districtId"));
				for (Map<String, Serializable> map : soilTestResultList) {
					String soilTestResult = (String) map.get("soilTestResult");
					String soilTestResultChk = (String) soilTestResultMap.get("soilTestResult");
					if (soilTestResult.equals(soilTestResultChk)) {
						soilTestResultId = Integer.parseInt((String) map.get("soilTestResultId"));
						System.out.print((String) map.get("soilTestResult") + " : " + soilTestResultId + " || ");
					}
				}
				for (Map<String, Serializable> map : yieldTargetList) {
					// System.out.println((String) map.get("yieldTarget") + " : " + (String) yieldTargetIdMap.get("yieldTarget"));
					if (Integer.parseInt((String) map.get("yieldTarget")) == Integer.parseInt((String) yieldTargetIdMap.get("yieldTarget"))) {
						yieldTargetId = Integer.parseInt((String) map.get("yieldTargetId"));
						System.out.println((String) map.get("yieldTarget") + " : " + yieldTargetId + " || " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
					}
				}
				if (soilTestResultId != 0 && yieldTargetId != 0) {
					int checkFertRecommCount = checkFertRecommExists(soilTestResultId, yieldTargetId);
					if (checkFertRecommCount == 0) {
						System.out.println("c : " + checkFertRecommCount);
						isInsertSuccessfull = addFertRecomm(soilTestResultId, yieldTargetId, Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
					} else {
						System.out.println("checkFertRecommExists(" + soilTestResultId + ", " + yieldTargetId + ", " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")) + ") : " + checkFertRecommCount);
					}
				} else {

					System.out.println("error");
					System.out.println("soilTestResultId : " + soilTestResultId + " | yieldTargetId : " + yieldTargetId);
					System.out.println("yieldTargetList");
					System.out.println(yieldTargetList);
					System.out.println("soilTestResultList");
					System.out.println(soilTestResultList);
					isInsertSuccessfull = 0;
				}
			}
		} else if ((Integer) fertRecommMap.get("isApplyToAllDists") == 0) {
			System.out.println("Error --- only one dist");
			isInsertSuccessfull = addFertRecomm((Integer) fertRecommMap.get("soilTestResultId"), (Integer) fertRecommMap.get("yieldTargetId"), Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
			System.out.println((Integer) fertRecommMap.get("soilTestResultId") + " : " + (Integer) fertRecommMap.get("yieldTargetId") + " || " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
		}
		System.out.println("-------------------------------------------------------------------------");
		return isInsertSuccessfull;
	}

	public int addFertRecomm(int soilTestResultId, int yieldTargetId, float fertRecomm) {
		int isInsertSuccessfull = 0;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.addFertRecomm);
			preparedStatement.setInt(1, soilTestResultId);
			preparedStatement.setInt(2, yieldTargetId);
			preparedStatement.setFloat(3, fertRecomm);
			preparedStatement.setInt(4, 1);
			isInsertSuccessfull = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isInsertSuccessfull;
	}

	private Map<String, Serializable> getSoilTestResult(int soilTestResultId) {
		Map<String, Serializable> soilTestResultMap = new HashMap<String, Serializable>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.getSoilTestResult);
			preparedStatement.setInt(1, soilTestResultId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				soilTestResultMap.put("soilTestResultId", resultSet.getString("fld_sol_tst_rslt_id"));
				soilTestResultMap.put("soilTestResult", resultSet.getString("fld_sol_tst_rslt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soilTestResultMap;
	}

	private Map<String, Serializable> getYieldTarget(int yieldTargetId) {
		Map<String, Serializable> yieldTargetMap = new HashMap<String, Serializable>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.getYieldTarget);
			preparedStatement.setInt(1, yieldTargetId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				yieldTargetMap.put("yieldTargetId", resultSet.getString("fld_yield_target_id"));
				yieldTargetMap.put("yieldTarget", resultSet.getString("fld_yield_target"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return yieldTargetMap;
	}

	public int checkFertRecommExists(int soilTestResultId, int yieldTargetId) {
		Map<String, Serializable> yieldTargetMap = new HashMap<String, Serializable>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(Query.checkFertRecommExists);
			// IN fld_sol_tst_rslt_id ,IN fld_yield_target_id , IN fld_fert_recomm
			// System.out.println("select count(*) as fertRecommCount from tbl_fert_recomm where fld_sol_tst_rslt_id=" + soilTestResultId + " and fld_yield_target_id = " + yieldTargetId + " and fld_fert_recomm =" + fertRecomm + ";");
			preparedStatement.setInt(1, soilTestResultId);
			preparedStatement.setInt(2, yieldTargetId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt("fertRecommCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public List<Map<String, Serializable>> getFertRecommForState(int stateId, int isRfOrIrr, int cropId) {
		List<Map<String, Serializable>> fertRecommList = new ArrayList<Map<String, Serializable>>();
		int rfIrrStateId = getRfIrrStateId(stateId, isRfOrIrr, cropId);
		List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
		districtList = getDistrictList(stateId);// districtId
		for (Map<String, Serializable> districtMap : districtList) {
			Map<String, Serializable> fertRecommDistrictMap = new HashMap<String, Serializable>();
			int districtId = (Integer) districtMap.get("districtId");
			fertRecommDistrictMap.put("districtName", (String) districtMap.get("districtName"));
			fertRecommDistrictMap.put("districtId", districtId);
			List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
			yieldTargetList = getYieldTargetListForDistrict(stateId, isRfOrIrr, cropId, districtId);//
			List<Map<String, Serializable>> fertRecommListOc = new ArrayList<Map<String, Serializable>>();
			List<Map<String, Serializable>> fertRecommListP = new ArrayList<Map<String, Serializable>>();
			List<Map<String, Serializable>> fertRecommListK = new ArrayList<Map<String, Serializable>>();
			Map<String, Serializable> fertRecommMapRsltOc1 = new HashMap<String, Serializable>();
			Map<String, Serializable> fertRecommMapRsltP1 = new HashMap<String, Serializable>();
			Map<String, Serializable> fertRecommMapRsltK1 = new HashMap<String, Serializable>();
			fertRecommMapRsltOc1.put("p1", "OC");
			fertRecommMapRsltP1.put("p1", "P");
			fertRecommMapRsltK1.put("p1", "K");
			for (int i = 0; i < yieldTargetList.size(); i++) {
				fertRecommMapRsltOc1.put("p" + Integer.toString(i + 2), yieldTargetList.get(i).get("yieldTarget"));
				fertRecommMapRsltK1.put("p" + Integer.toString(i + 2), yieldTargetList.get(i).get("yieldTarget"));
				fertRecommMapRsltP1.put("p" + Integer.toString(i + 2), yieldTargetList.get(i).get("yieldTarget"));
			}
			fertRecommListOc.add(fertRecommMapRsltOc1);
			fertRecommListP.add(fertRecommMapRsltP1);
			fertRecommListK.add(fertRecommMapRsltK1);
			List<Map<String, Serializable>> soilTestResultListOc = new ArrayList<Map<String, Serializable>>();
			List<Map<String, Serializable>> soilTestResultListK = new ArrayList<Map<String, Serializable>>();
			List<Map<String, Serializable>> soilTestResultListP = new ArrayList<Map<String, Serializable>>();
			soilTestResultListOc = getSoilTestResultListForDistrict(stateId, isRfOrIrr, cropId, 1, districtId);// soilTestResult
			soilTestResultListP = getSoilTestResultListForDistrict(stateId, isRfOrIrr, cropId, 2, districtId);
			soilTestResultListK = getSoilTestResultListForDistrict(stateId, isRfOrIrr, cropId, 3, districtId);
			for (Map<String, Serializable> soilTestResultMap : soilTestResultListOc) {
				Map<String, Serializable> fertRecommMapRsltOc = new HashMap<String, Serializable>();
				fertRecommMapRsltOc.put("p1", soilTestResultMap.get("soilTestResult"));
				int soilTestResultId = Integer.parseInt((String) soilTestResultMap.get("soilTestResultId"));
				for (int i = 0; i < yieldTargetList.size(); i++) {
					int yieldTargetId = Integer.parseInt((String) yieldTargetList.get(i).get("yieldTargetId"));
					float fertRecomm = getFertRecomm(soilTestResultId, yieldTargetId);
					fertRecommMapRsltOc.put("p" + Integer.toString(i + 2), fertRecomm);
				}
				fertRecommListOc.add(fertRecommMapRsltOc);
			}
			fertRecommDistrictMap.put("fertRecommOc", (Serializable) fertRecommListOc);
			for (Map<String, Serializable> soilTestResultMap : soilTestResultListP) {
				Map<String, Serializable> fertRecommMapRsltP = new HashMap<String, Serializable>();
				fertRecommMapRsltP.put("p1", soilTestResultMap.get("soilTestResult"));
				int soilTestResultId = Integer.parseInt((String) soilTestResultMap.get("soilTestResultId"));
				for (int i = 0; i < yieldTargetList.size(); i++) {
					int yieldTargetId = Integer.parseInt((String) yieldTargetList.get(i).get("yieldTargetId"));
					float fertRecomm = getFertRecomm(soilTestResultId, yieldTargetId);
					fertRecommMapRsltP.put("p" + Integer.toString(i + 2), fertRecomm);
				}
				fertRecommListP.add(fertRecommMapRsltP);
			}
			fertRecommDistrictMap.put("fertRecommP", (Serializable) fertRecommListP);
			for (Map<String, Serializable> soilTestResultMap : soilTestResultListK) {
				Map<String, Serializable> fertRecommMapRsltK = new HashMap<String, Serializable>();
				fertRecommMapRsltK.put("p1", soilTestResultMap.get("soilTestResult"));
				int soilTestResultId = Integer.parseInt((String) soilTestResultMap.get("soilTestResultId"));
				for (int i = 0; i < yieldTargetList.size(); i++) {
					int yieldTargetId = Integer.parseInt((String) yieldTargetList.get(i).get("yieldTargetId"));
					float fertRecomm = getFertRecomm(soilTestResultId, yieldTargetId);
					fertRecommMapRsltK.put("p" + Integer.toString(i + 2), fertRecomm);
				}
				fertRecommListK.add(fertRecommMapRsltK);
			}
			fertRecommDistrictMap.put("fertRecommK", (Serializable) fertRecommListK);
			fertRecommList.add(fertRecommDistrictMap);
		}
		return fertRecommList;
	}

	private float getFertRecomm(int soilTestResultId, int yieldTargetId) {
		List<Map<String, Serializable>> fertRecommList = new ArrayList<Map<String, Serializable>>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		float fertRecomm = 0;
		try {
			preparedStatement = connection.prepareStatement(Query.getFertRecomm);
			preparedStatement.setInt(1, soilTestResultId);
			preparedStatement.setInt(2, yieldTargetId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				fertRecomm = resultSet.getFloat("fld_fert_recomm");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fertRecomm;
	}

	public Integer updateYieldTarget(int stateId, Map<String, Object> yieldTargetMap) {
		int isUpdateSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) yieldTargetMap.get("isRfOrIrr"), (Integer) yieldTargetMap.get("cropId"));
		if (rfIrrStateId != 0) {
			if ((Integer) yieldTargetMap.get("isApplyToAllDists") == 1) {
				System.out.println("Error isApplyToAllDists == 1");
				// System.out.print("cropId : " + (Integer) yieldTargetMap.get("cropId") + " | ");
				// System.out.println("stateId : " + stateId);
				// List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
				// districtList = getDistrictList(stateId);
				// for (Map<String, Serializable> districtMap : districtList) {
				// System.out.print("districtId : " + (Integer) districtMap.get("districtId") + " | ");
				// isUpdateSuccessfull = addYieldTarget(stateId, (Integer) districtMap.get("districtId"), rfIrrStateId, (Integer) yieldTargetMap.get("cropId"), (Integer) yieldTargetMap.get("yieldTarget"));
				// System.out.println("yieldTarget : " + (Integer) yieldTargetMap.get("yieldTarget"));
				// }
			} else if ((Integer) yieldTargetMap.get("isApplyToAllDists") == 0) {
				System.out.print("districtId : " + (Integer) yieldTargetMap.get("districtId") + " | ");
				System.out.println("yieldTarget : " + (Integer) yieldTargetMap.get("yieldTarget"));
				isUpdateSuccessfull = updateYieldTarget(stateId, (Integer) yieldTargetMap.get("districtId"), rfIrrStateId, (Integer) yieldTargetMap.get("cropId"), (Integer) yieldTargetMap.get("yieldTarget"));
			}
		}
		return isUpdateSuccessfull;
	}

	public int updateYieldTarget(int stateId, int districtId, int rfIrrStateId, int cropId, int yieldTarget) {
		Connection connection = getConnection();
		int isUpdateSuccessfull = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.updateyieldTarget);
			preparedStatement.setInt(1, yieldTarget);
			preparedStatement.setInt(2, rfIrrStateId);
			preparedStatement.setInt(3, stateId);
			preparedStatement.setInt(4, cropId);
			preparedStatement.setInt(5, districtId);
			isUpdateSuccessfull = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isUpdateSuccessfull;
	}

	public Integer updateSoilTestResult(int stateId, Map<String, Object> soilTestResultMap) {
		int isUpdateSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) soilTestResultMap.get("isRfOrIrr"), (Integer) soilTestResultMap.get("cropId"));
		if ((Integer) soilTestResultMap.get("isApplyToAllDists") == 1) {
			System.out.println("Error isApplyToAllDists == 1");
			// System.out.print("cropId : " + (Integer) soilTestResultMap.get("cropId") + " | ");
			// System.out.println("stateId : " + stateId);
			// List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
			// districtList = getDistrictList(stateId);
			// for (Map<String, Serializable> districtMap : districtList) {
			// System.out.print("districtId : " + (Integer) districtMap.get("districtId") + " | ");
			// isUpdateSuccessfull = addSoilTestResult(rfIrrStateId, stateId, (Integer) soilTestResultMap.get("sFertTypeId"), (Integer) soilTestResultMap.get("cropId"), (Integer) districtMap.get("districtId"), (String) soilTestResultMap.get("soilTestResult"));
			// System.out.println("sFertTypeId : " + (Integer) soilTestResultMap.get("sFertTypeId") + " | soilTestResult : " + (String) soilTestResultMap.get("soilTestResult"));
			// }
		} else if ((Integer) soilTestResultMap.get("isApplyToAllDists") == 0) {
			System.out.print("districtId : " + (Integer) soilTestResultMap.get("districtId") + " | ");
			System.out.println("sFertTypeId : " + (Integer) soilTestResultMap.get("sFertTypeId") + " | soilTestResult : " + (String) soilTestResultMap.get("soilTestResult"));
			isUpdateSuccessfull = addSoilTestResult(rfIrrStateId, stateId, (Integer) soilTestResultMap.get("sFertTypeId"), (Integer) soilTestResultMap.get("cropId"), (Integer) soilTestResultMap.get("districtId"), (String) soilTestResultMap.get("soilTestResult"));
		}
		return isUpdateSuccessfull;
	}

	public int updateSoilTestResult(int rfIrrStateId, int stateId, int sFertTypeId, int cropId, int districtId, String soilTestResult) {
		int isUpdateSuccessfull = 0;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {// IN fld_sol_tst_rslt,fld_rf_irr_state_id,fld_state_id,fld_sfert_tpe_id,fld_crop_id,fld_district_id,fld_have_soil_tst_rslt
			preparedStatement = connection.prepareStatement(Query.updateSoilTestResult);
			preparedStatement.setString(1, soilTestResult);
			preparedStatement.setInt(2, rfIrrStateId);
			preparedStatement.setInt(3, stateId);
			preparedStatement.setInt(4, sFertTypeId);
			preparedStatement.setInt(5, cropId);
			preparedStatement.setInt(6, districtId);
			preparedStatement.setInt(7, 1);
			isUpdateSuccessfull = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isUpdateSuccessfull;
	}

	public Integer updateFertRecomm(int stateId, Map<String, Object> fertRecommMap) {
		int isUpdateSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"));
		if ((Integer) fertRecommMap.get("isApplyToAllDists") == 1) {
			System.out.println("Error isApplyToAllDists == 1");
			// List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
			// districtList = getDistrictList(stateId);
			// for (Map<String, Serializable> districtMap : districtList) {
			// System.out.println(" | stateId : " + stateId + " | DistrictId : " + (Integer) districtMap.get("districtId") + " | cropId : " + (Integer) fertRecommMap.get("cropId") + " | isRfOrIrr : " + (Integer) fertRecommMap.get("isRfOrIrr") + "| rfIrrStateId : " + rfIrrStateId + " | sFertTypeId : " + (Integer) fertRecommMap.get("sFertTypeId"));
			// List<Map<String, Serializable>> soilTestResultList = new ArrayList<Map<String, Serializable>>();
			// List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
			// int soilTestResultId = 0, yieldTargetId = 0;
			// Map<String, Serializable> soilTestResultMap = new HashMap<String, Serializable>();
			// Map<String, Serializable> yieldTargetIdMap = new HashMap<String, Serializable>();
			// soilTestResultMap = getSoilTestResult((Integer) fertRecommMap.get("soilTestResultId"));
			// yieldTargetIdMap = getYieldTarget((Integer) fertRecommMap.get("yieldTargetId"));
			// // getSoilTestResultListForDistrict(int stateId, int isRfOrIrr, int cropId, int sFertTypeId, int districtId)
			// soilTestResultList = getSoilTestResultListForDistrict(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"), (Integer) fertRecommMap.get("sFertTypeId"), (Integer) districtMap.get("districtId"));
			// // getYieldTargetListForDistrict(int stateId, int isRfOrIrr, int cropId, int districtId)
			// yieldTargetList = getYieldTargetListForDistrict(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"), (Integer) districtMap.get("districtId"));
			// for (Map<String, Serializable> map : soilTestResultList) {
			// String soilTestResult = (String) map.get("soilTestResult");
			// String soilTestResultChk = (String) soilTestResultMap.get("soilTestResult");
			// if (soilTestResult.equals(soilTestResultChk)) {
			// soilTestResultId = Integer.parseInt((String) map.get("soilTestResultId"));
			// System.out.print((String) map.get("soilTestResult") + " : " + soilTestResultId + " || ");
			// }
			// }
			// for (Map<String, Serializable> map : yieldTargetList) {
			// // System.out.println((String) map.get("yieldTarget") + " : " + (String) yieldTargetIdMap.get("yieldTarget"));
			// if (Integer.parseInt((String) map.get("yieldTarget")) == Integer.parseInt((String) yieldTargetIdMap.get("yieldTarget"))) {
			// yieldTargetId = Integer.parseInt((String) map.get("yieldTargetId"));
			// System.out.println((String) map.get("yieldTarget") + " : " + yieldTargetId + " || " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")) );
			// }
			// }
			// if (soilTestResultId != 0 && yieldTargetId != 0) {
			// int checkFertRecommCount = checkFertRecommExists(soilTestResultId, yieldTargetId);
			// if (checkFertRecommCount == 0) {
			// System.out.println("c : " + checkFertRecommCount);
			// isUpdateSuccessfull = addFertRecomm(soilTestResultId, yieldTargetId, Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
			// } else {
			// System.out.println("checkFertRecommExists(" + soilTestResultId + ", " + yieldTargetId + ", " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")) + ") : " + checkFertRecommCount);
			// }
			// } else {
			//
			// System.out.println("error");
			// System.out.println("soilTestResultId : " + soilTestResultId + " | yieldTargetId : " + yieldTargetId);
			// System.out.println("yieldTargetList");
			// System.out.println(yieldTargetList);
			// System.out.println("soilTestResultList");
			// System.out.println(soilTestResultList);
			// isUpdateSuccessfull = 0;
			// }
			// }
		} else if ((Integer) fertRecommMap.get("isApplyToAllDists") == 0) {
			isUpdateSuccessfull = addFertRecomm((Integer) fertRecommMap.get("soilTestResultId"), (Integer) fertRecommMap.get("yieldTargetId"), Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
			System.out.println((Integer) fertRecommMap.get("soilTestResultId") + " : " + (Integer) fertRecommMap.get("yieldTargetId") + " || " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
		}
		System.out.println("-------------------------------------------------------------------------");
		return isUpdateSuccessfull;
	}
	
	public int updateFertRecomm(int soilTestResultId, int yieldTargetId, float fertRecomm) {
		int isUpdateSuccessfull = 0;
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(Query.updateFertRecomm);
			preparedStatement.setFloat(1, fertRecomm);
			preparedStatement.setInt(2, soilTestResultId);
			preparedStatement.setInt(3, yieldTargetId);
			preparedStatement.setInt(4, 1);
			isUpdateSuccessfull = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isUpdateSuccessfull;
	}
	
	public int addFertRecommTest(int stateId, Map<String, Object> fertRecommMap) {
		int isInsertSuccessfull = 0;
		int rfIrrStateId = getRfIrrStateId(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"));
		if ((Integer) fertRecommMap.get("isApplyToAllDists") == 1) {
			List<Map<String, Serializable>> districtList = new ArrayList<Map<String, Serializable>>();
			districtList = getDistrictList(stateId);
			for (Map<String, Serializable> districtMap : districtList) {
				System.out.println(" | stateId : " + stateId + " | DistrictId : " + (Integer) districtMap.get("districtId") + " | cropId : " + (Integer) fertRecommMap.get("cropId") + " | isRfOrIrr : " + (Integer) fertRecommMap.get("isRfOrIrr") + "| rfIrrStateId : " + rfIrrStateId + " | sFertTypeId : " + (Integer) fertRecommMap.get("sFertTypeId"));
				List<Map<String, Serializable>> soilTestResultList = new ArrayList<Map<String, Serializable>>();
				List<Map<String, Serializable>> yieldTargetList = new ArrayList<Map<String, Serializable>>();
				int soilTestResultId = 0, yieldTargetId = 0;
//				Map<String, Serializable> soilTestResultMap = new HashMap<String, Serializable>();
//				Map<String, Serializable> yieldTargetIdMap = new HashMap<String, Serializable>();
				String soilTestResultTst = (String) fertRecommMap.get("soilTestResult");
				int yieldTargetIdTst = (Integer) fertRecommMap.get("yieldTarget");
				// getSoilTestResultListForDistrict(int stateId, int isRfOrIrr, int cropId, int sFertTypeId, int districtId)
				soilTestResultList = getSoilTestResultListForDistrict(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"), (Integer) fertRecommMap.get("sFertTypeId"), (Integer) districtMap.get("districtId"));
				// getYieldTargetListForDistrict(int stateId, int isRfOrIrr, int cropId, int districtId)
				yieldTargetList = getYieldTargetListForDistrict(stateId, (Integer) fertRecommMap.get("isRfOrIrr"), (Integer) fertRecommMap.get("cropId"), (Integer) districtMap.get("districtId"));
				for (Map<String, Serializable> map : soilTestResultList) {
					String soilTestResult = (String) map.get("soilTestResult");
					String soilTestResultChk = soilTestResultTst;
					if (soilTestResult.equals(soilTestResultChk)) {
						soilTestResultId = Integer.parseInt((String) map.get("soilTestResultId"));
						System.out.print((String) map.get("soilTestResult") + " : " + soilTestResultId + " || ");
					}
				}
				for (Map<String, Serializable> map : yieldTargetList) {
					// System.out.println((String) map.get("yieldTarget") + " : " + (String) yieldTargetIdMap.get("yieldTarget"));
					if (Integer.parseInt((String) map.get("yieldTarget")) == yieldTargetIdTst) {
						yieldTargetId = Integer.parseInt((String) map.get("yieldTargetId"));
						System.out.println((String) map.get("yieldTarget") + " : " + yieldTargetId + " || " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
					}
				}
				if (soilTestResultId != 0 && yieldTargetId != 0) {
					int checkFertRecommCount = checkFertRecommExists(soilTestResultId, yieldTargetId);
					if (checkFertRecommCount == 0) {
						System.out.println("c : " + checkFertRecommCount);
						isInsertSuccessfull = addFertRecomm(soilTestResultId, yieldTargetId, Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
					} else {
						System.out.println("checkFertRecommExists(" + soilTestResultId + ", " + yieldTargetId + ", " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")) + ") : " + checkFertRecommCount);
					}
				} else {

					System.out.println("error");
					System.out.println("soilTestResultId : " + soilTestResultId + " | yieldTargetId : " + yieldTargetId);
					System.out.println("yieldTargetList");
					System.out.println(yieldTargetList);
					System.out.println("soilTestResultList");
					System.out.println(soilTestResultList);
					isInsertSuccessfull = 0;
				}
			}
		} else if ((Integer) fertRecommMap.get("isApplyToAllDists") == 0) {
			System.out.println("Error --- only one dist");
			isInsertSuccessfull = addFertRecomm((Integer) fertRecommMap.get("soilTestResultId"), (Integer) fertRecommMap.get("yieldTargetId"), Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
			System.out.println((Integer) fertRecommMap.get("soilTestResultId") + " : " + (Integer) fertRecommMap.get("yieldTargetId") + " || " + Float.parseFloat((String) fertRecommMap.get("fertRecomm")));
		}
		System.out.println("-------------------------------------------------------------------------");
		return isInsertSuccessfull;
	}

	public List<Map<String, Serializable>> getMFertRecommForState(int stateId, int rfIrrStateId, int cropId) {
		List<Map<String, Serializable>> mFertRecomList = new ArrayList<Map<String, Serializable>>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		Map<String, Float> mFertRecommmap = new HashMap<String, Float>();
		try {
			preparedStatement = connection.prepareStatement(Query.getMFertRecomm);
			preparedStatement.setInt(1, rfIrrStateId);
			preparedStatement.setInt(2, stateId);
			preparedStatement.setInt(3, cropId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				mFertRecommmap.put("yieldTarget", (Float)resultSet.getFloat("fld_yield_target"));
				mFertRecommmap.put("MG", (Float)resultSet.getFloat("fld_mg"));
				mFertRecommmap.put("ZN", (Float)resultSet.getFloat("fld_zn"));
				mFertRecommmap.put("B", (Float)resultSet.getFloat("fld_b"));
				mFertRecommmap.put("FE", (Float)resultSet.getFloat("fld_fe"));
				mFertRecommmap.put("MN", (Float)resultSet.getFloat("fld_mn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mFertRecomList;
	}
}
