package com.xbitsolutions.cassapp;

public class Query {
	public static final String getCrops = "select * from tbl_crops;";
	public static final String getStates = "select * from tbl_state;";
	public static final String getRfIrrStates = "select tbl_rf_irr_state.fld_rf_irr_state_id,tbl_rf_irr_state.fld_rf_irr,tbl_rf_irr_state.fld_crop_id,tbl_crops.fld_crop_name,tbl_rf_irr_state.fld_state_id,tbl_state.fld_state_name from tbl_rf_irr_state inner join tbl_crops on tbl_crops.fld_crop_id = tbl_rf_irr_state.fld_crop_id inner join tbl_state on tbl_state.fld_state_id=tbl_rf_irr_state.fld_state_id  where tbl_rf_irr_state.fld_crop_id =?;";
	public static final String getDistricts = "select * from tbl_district where fld_state_id=?;";
	public static final String getFertilizerTypes = "select * from tbl_fert_tpe;";
	public static final String getStateCrops = "select tbl_crops.fld_crop_name,tbl_crops.fld_crop_id from tbl_state_crops inner join tbl_crops on tbl_crops.fld_crop_id=tbl_state_crops.fld_crop_id where tbl_state_crops.fld_state_id=?;";
	public static final String addyieldTarget = "insert into tbl_yield_target(fld_rf_irr_state_id, fld_state_id, fld_crop_id,fld_district_id, fld_yield_target) values(?,?,?,?,?)";
	// fld_rf_irr_state_id, fld_state_id, fld_crop_id,fld_district_id, fld_yield_target, fld_have_soil_tst_rslt
	public static final String getRfIrrId = "select fld_rf_irr_state_id from tbl_rf_irr_state where fld_state_id=? AND fld_rf_irr=? AND fld_crop_id=?";
	// fld_state_id , fld_rf_irr, fld_crop_id
	public static final String addSoilTestResult = "INSERT INTO tbl_soil_tst_rslt(fld_rf_irr_state_id,fld_state_id,fld_sfert_tpe_id,fld_crop_id,fld_district_id,fld_sol_tst_rslt,fld_have_soil_tst_rslt) VALUES(?,?,?,?,?,?,?);";
	public static final String getYieldTargetListForDistrict = "SELECT tbl_yield_target.fld_rf_irr_state_id,tbl_yield_target.fld_yield_target_id,tbl_yield_target.fld_yield_target,tbl_yield_target.fld_have_soil_tst_rslt,tbl_crops.fld_crop_name,tbl_district.fld_district_name,tbl_state.fld_state_name FROM tbl_yield_target INNER JOIN tbl_state ON tbl_state.fld_state_id = tbl_yield_target.fld_state_id INNER JOIN  tbl_crops ON tbl_crops.fld_crop_id = tbl_yield_target.fld_crop_id INNER JOIN tbl_district ON tbl_district.fld_district_id=tbl_yield_target.fld_district_id  WHERE tbl_yield_target.fld_rf_irr_state_id = ? AND tbl_yield_target.fld_state_id = ? AND tbl_yield_target.fld_crop_id=? AND tbl_yield_target.fld_district_id = ?;";
	// fld_rf_irr_state_id ,fld_state_id ,fld_crop_id ,fld_district_id
	// public static final String getYieldTargetListForState = "SELECT fld_yield_target_id,fld_yield_target FROM tbl_yield_target WHERE fld_rf_irr_state_id = ? AND fld_state_id = ? AND fld_crop_id=?;";
	// fld_rf_irr_state_id ,fld_state_id ,fld_crop_id=?
	public static final String getYieldTargetListForState = "SELECT tbl_yield_target.fld_rf_irr_state_id,tbl_yield_target.fld_yield_target_id,tbl_yield_target.fld_yield_target,tbl_yield_target.fld_have_soil_tst_rslt,tbl_crops.fld_crop_name,tbl_district.fld_district_name,tbl_state.fld_state_name FROM tbl_yield_target INNER JOIN tbl_state ON tbl_state.fld_state_id = tbl_yield_target.fld_state_id INNER JOIN  tbl_crops ON tbl_crops.fld_crop_id = tbl_yield_target.fld_crop_id INNER JOIN tbl_district ON tbl_district.fld_district_id=tbl_yield_target.fld_district_id  WHERE tbl_yield_target.fld_rf_irr_state_id = ? AND tbl_yield_target.fld_state_id = ? AND tbl_yield_target.fld_crop_id=?;";
	// fld_rf_irr_state_id ,fld_state_id ,fld_crop_id=?
	// public static final String getSoilTestResultListForDistrict = "SELECT fld_sol_tst_rslt_id,fld_sol_tst_rslt,fld_have_soil_tst_rslt FROM tbl_soil_tst_rslt WHERE fld_rf_irr_state_id = ? AND fld_state_id = ? AND fld_sfert_tpe_id = ? AND fld_crop_id = ? AND fld_district_id = ?;";
	// fld_rf_irr_state_id, fld_state_id, fld_sfert_tpe_id, fld_crop_id, fld_district_id
	public static final String getSoilTestResultListForDistrict = "SELECT tbl_soil_tst_rslt.fld_rf_irr_state_id,tbl_soil_tst_rslt.fld_sol_tst_rslt_id,tbl_soil_tst_rslt.fld_sol_tst_rslt,tbl_soil_tst_rslt.fld_have_soil_tst_rslt,tbl_crops.fld_crop_name,tbl_district.fld_district_name,tbl_state.fld_state_name  FROM tbl_soil_tst_rslt INNER JOIN tbl_state ON tbl_state.fld_state_id = tbl_soil_tst_rslt.fld_state_id INNER JOIN  tbl_crops ON tbl_crops.fld_crop_id = tbl_soil_tst_rslt.fld_crop_id INNER JOIN tbl_district ON tbl_district.fld_district_id=tbl_soil_tst_rslt.fld_district_id WHERE tbl_soil_tst_rslt.fld_rf_irr_state_id = ? AND tbl_soil_tst_rslt.fld_state_id = ? AND tbl_soil_tst_rslt.fld_sfert_tpe_id = ? AND tbl_soil_tst_rslt.fld_crop_id = ? AND tbl_soil_tst_rslt.fld_district_id = ?;";
	// fld_rf_irr_state_id, fld_state_id, fld_sfert_tpe_id, fld_crop_id, fld_district_id
	// public static final String getSoilTestResultListForState = "SELECT fld_sol_tst_rslt_id,fld_sol_tst_rslt,fld_have_soil_tst_rslt FROM tbl_soil_tst_rslt WHERE fld_rf_irr_state_id = ? AND fld_state_id = ? AND fld_sfert_tpe_id = ? AND fld_crop_id = ?";
	// fld_rf_irr_state_id, fld_state_id, fld_sfert_tpe_id, fld_crop_id
	public static final String getSoilTestResultListForState = "SELECT tbl_soil_tst_rslt.fld_rf_irr_state_id,tbl_soil_tst_rslt.fld_sol_tst_rslt_id,tbl_soil_tst_rslt.fld_sol_tst_rslt,tbl_soil_tst_rslt.fld_have_soil_tst_rslt,tbl_crops.fld_crop_name,tbl_district.fld_district_name,tbl_state.fld_state_name  FROM tbl_soil_tst_rslt INNER JOIN tbl_state ON tbl_state.fld_state_id = tbl_soil_tst_rslt.fld_state_id INNER JOIN  tbl_crops ON tbl_crops.fld_crop_id = tbl_soil_tst_rslt.fld_crop_id INNER JOIN tbl_district ON tbl_district.fld_district_id=tbl_soil_tst_rslt.fld_district_id WHERE tbl_soil_tst_rslt.fld_rf_irr_state_id = ? AND tbl_soil_tst_rslt.fld_state_id = ? AND tbl_soil_tst_rslt.fld_sfert_tpe_id = ? AND tbl_soil_tst_rslt.fld_crop_id = ?";
	
	public static final String addFertRecomm = "INSERT INTO tbl_fert_recomm(fld_sol_tst_rslt_id,fld_yield_target_id,fld_fert_recomm,fld_have_soil_tst_rslt) VALUES(?,?,?,?)";
	public static final String getSoilTestResult = "SELECT * FROM tbl_soil_tst_rslt where fld_sol_tst_rslt_id =?";
	public static final String getYieldTarget = "SELECT * FROM tbl_yield_target where fld_yield_target_id = ?";
	public static final String checkFertRecommExists = "select count(*) as fertRecommCount from tbl_fert_recomm where fld_sol_tst_rslt_id=? and fld_yield_target_id = ?;";
	//IN fld_sol_tst_rslt_id ,IN fld_yield_target_id , IN fld_fert_recomm
	public static final String getFertRecomm = "SELECT fld_fert_recomm FROM tbl_fert_recomm WHERE fld_sol_tst_rslt_id = ? AND fld_yield_target_id =?";
	public static final String updateyieldTarget = "UPDATE tbl_yield_target SET fld_yield_target = ? WHERE fld_rf_irr_state_id = ? AND fld_state_id = ? AND fld_crop_id = ? AND fld_district_id = ?";
	//IN fld_yield_target, IN fld_rf_irr_state_id ,IN fld_state_id , IN fld_crop_id ,IN fld_district_id";
	public static final String updateSoilTestResult = "UPDATE tbl_soil_tst_rslt SET fld_sol_tst_rslt = ? WHERE fld_rf_irr_state_id=? AND fld_state_id=? AND fld_sfert_tpe_id=? AND fld_crop_id=? AND fld_district_id=? AND fld_have_soil_tst_rslt=?;";
	//IN fld_sol_tst_rslt,fld_rf_irr_state_id,fld_state_id,fld_sfert_tpe_id,fld_crop_id,fld_district_id,fld_have_soil_tst_rslt
	public static final String updateFertRecomm = "UPDATE tbl_fert_recomm SET fld_fert_recomm = ? WHERE fld_sol_tst_rslt_id = ? AND fld_yield_target_id = ? AND fld_have_soil_tst_rslt = ?";
	//IN fld_fert_recomm ,fld_sol_tst_rslt_id,fld_yield_target_id,fld_have_soil_tst_rslt
	public static final String getMFertRecomm = "select tbl_district.fld_district_name,tbl_yield_target.fld_yield_target,tbl_micronutrient_recom.fld_mg,tbl_micronutrient_recom.fld_zn,tbl_micronutrient_recom.fld_b,tbl_micronutrient_recom.fld_fe,tbl_micronutrient_recom.fld_mn from tbl_micronutrient_recom INNER JOIN tbl_district ON tbl_district.fld_district_id = tbl_micronutrient_recom.fld_district_id INNER JOIN  tbl_yield_target ON tbl_micronutrient_recom.fld_yield_target_id = tbl_yield_target.fld_yield_target_id where tbl_micronutrient_recom.fld_rf_irr_state_id = ? AND tbl_micronutrient_recom.fld_state_id = ? AND tbl_micronutrient_recom.fld_crop_id = ?;";
	//fld_rf_irr_state_id,fld_state_id,fld_district_id,fld_crop_id
}
