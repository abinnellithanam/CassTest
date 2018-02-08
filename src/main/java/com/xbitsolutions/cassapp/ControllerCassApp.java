package com.xbitsolutions.cassapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCassApp {
	CassAppDAO cassAppDAO = new CassAppDAO();
	@RequestMapping(value = "/getCropList", method = RequestMethod.GET)
	public List<Map<String,Serializable>> getCropList() {
		
		return cassAppDAO.getCropsList();
	}
	@RequestMapping(value = "/getStateList", method = RequestMethod.GET)
	public List<Map<String,Serializable>> getStateList() {
		
		return cassAppDAO.getStateList();
	}
	@RequestMapping(value = "/getDistrictList/{districtId}", method = RequestMethod.GET)
	public List<Map<String,Serializable>> getDistrictList(@PathVariable int districtId) {
		
		return cassAppDAO.getDistrictList(districtId);
	}
	@RequestMapping(value = "/getFertTypeList", method = RequestMethod.GET)
	public List<Map<String,Serializable>> getFertTypeList() {
		
		return cassAppDAO.getFertTypeList();
	}
	@RequestMapping(value = "/getCropsList/{stateId}", method = RequestMethod.GET)
	public List<Map<String,Serializable>> getCropsList(@PathVariable int stateId) {
		
		return cassAppDAO.getCropsList(stateId);
	}
	@RequestMapping(value="{stateId}/addYieldTarget",method=RequestMethod.POST)
	public Map<String,Serializable> addYieldTarget(@PathVariable int stateId, @RequestBody Map<String,Object> yieldTargetMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("isInsertSuccessfull",(Integer) cassAppDAO.addYieldTarget(stateId, yieldTargetMap));
		return returnMap;
	}
	@RequestMapping(value="{stateId}/addSoilTestResult",method=RequestMethod.POST)
	public Map<String,Serializable> addSoilTestResult(@PathVariable int stateId, @RequestBody Map<String,Object> soilTestResultMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("isInsertSuccessfull",(Integer) cassAppDAO.addSoilTestResult(stateId, soilTestResultMap));
		return returnMap;
	}
	@RequestMapping(value="{stateId}/getYieldTargetList",method=RequestMethod.POST)
	public List<Map<String,Serializable>> getYieldTargetList(@PathVariable int stateId, @RequestBody Map<String,Object> yieldTargetFetchCriteriaMap){
		return cassAppDAO.getYieldTargetList(yieldTargetFetchCriteriaMap);
	}
	@RequestMapping(value="{stateId}/getSoilTestResultList",method=RequestMethod.POST)
	public List<Map<String,Serializable>> getSoilTestResultList(@PathVariable int stateId, @RequestBody Map<String,Object> soilTestResultFetchCriteriaMap){
		return cassAppDAO.getSoilTestResultList(soilTestResultFetchCriteriaMap);
	}
	@RequestMapping(value="{stateId}/addFertRecomm",method=RequestMethod.POST)
	public Map<String, Serializable> addFertRecomm(@PathVariable int stateId, @RequestBody Map<String,Object> soilTestResultFetchCriteriaMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("isInsertSuccessfull",(Integer) cassAppDAO.addFertRecomm(stateId, soilTestResultFetchCriteriaMap));
		return returnMap;
	}
	@RequestMapping(value="{stateId}/getFertRecomm",method=RequestMethod.POST)
	public Map<String, Serializable> getFertRecomm(@PathVariable int stateId, @RequestBody Map<String,Object> getFertRecommCriteriaMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
//		cassAppDAO.getFertRecommForState(stateId, (Integer) getFertRecommCriteriaMap.get("isRfOrIrr"), (Integer) getFertRecommCriteriaMap.get("cropId"));
		returnMap.put("fertRecommList",(Serializable) cassAppDAO.getMFertRecommForState(stateId, (Integer) getFertRecommCriteriaMap.get("isRfOrIrr"), (Integer) getFertRecommCriteriaMap.get("cropId")));
		return returnMap;
	}
	
	@RequestMapping(value="{stateId}/updateYieldTarget",method=RequestMethod.POST)
	public Map<String,Serializable> updateYieldTarget(@PathVariable int stateId, @RequestBody Map<String,Object> yieldTargetMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("isInsertSuccessfull",(Integer) cassAppDAO.updateYieldTarget(stateId, yieldTargetMap));
		return returnMap;
	}
	@RequestMapping(value="{stateId}/updateSoilTestResult",method=RequestMethod.POST)
	public Map<String,Serializable> updateSoilTestResult(@PathVariable int stateId, @RequestBody Map<String,Object> soilTestResultMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("isInsertSuccessfull",(Integer) cassAppDAO.updateSoilTestResult(stateId, soilTestResultMap));
		return returnMap;
	}
	@RequestMapping(value="{stateId}/updateFertRecomm",method=RequestMethod.POST)
	public Map<String, Serializable> updateFertRecomm(@PathVariable int stateId, @RequestBody Map<String,Object> soilTestResultFetchCriteriaMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("isInsertSuccessfull",(Integer) cassAppDAO.updateFertRecomm(stateId, soilTestResultFetchCriteriaMap));
		return returnMap;
	}
	@RequestMapping(value="{stateId}/getMFertRecomm",method=RequestMethod.POST)
	public Map<String, Serializable> getMFertRecomm(@PathVariable int stateId, @RequestBody Map<String,Object> getMFertRecommCriteriaMap){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		returnMap.put("fertRecommList",(Serializable) cassAppDAO.getMFertRecommForState(stateId, (Integer) getMFertRecommCriteriaMap.get("isRfOrIrr"), (Integer) getMFertRecommCriteriaMap.get("cropId")));
		return returnMap;
	}
	
	@RequestMapping(value="{cropId}/getMFertRecommState",method=RequestMethod.GET)
	public Map<String, Serializable> getMFertRecommState(@PathVariable int cropId){
		Map<String,Serializable> returnMap = new HashMap<String, Serializable>();
		List<Map<String, Serializable>> rfIrrStateList = new ArrayList<Map<String, Serializable>>();
		List<Serializable> mFertRecomStatesList = new ArrayList<Serializable>();
		rfIrrStateList = cassAppDAO.getRfIrrStateList(cropId);
		for (Map<String, Serializable> rfIrrStateMap : rfIrrStateList) {
			Map<String,Serializable> mfertRecommMapState = new HashMap<String, Serializable>();
			mfertRecommMapState.put("stateName",(String) rfIrrStateMap.get("stateName"));
			mfertRecommMapState.put("stateId", (Integer)rfIrrStateMap.get("stateId"));
			mfertRecommMapState.put("rfIrrStateId", (Integer)rfIrrStateMap.get("rfIrrStateId"));
			mfertRecommMapState.put("isRforIrr", (Integer)rfIrrStateMap.get("isRforIrr"));
			List<Map<String, Serializable>> mFertRecomList = new ArrayList<Map<String, Serializable>>();
			mFertRecomList = cassAppDAO.getMFertRecommForState((Integer)rfIrrStateMap.get("stateId"), (Integer) rfIrrStateMap.get("rfIrrStateId"), cropId);
			mfertRecommMapState.put("mFertRecomm", (Serializable)mFertRecomList);
			mFertRecomStatesList.add((Serializable)mfertRecommMapState);
		}
		returnMap.put("mFertRecomStatesList",(Serializable) mFertRecomStatesList);
		return returnMap;
	}
}
