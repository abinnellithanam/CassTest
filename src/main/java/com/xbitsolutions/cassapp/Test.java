package com.xbitsolutions.cassapp;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		 CassAppDAO cassAppDAO = new CassAppDAO();
//		// List<Map<String, Serializable>> stateList = new ArrayList<Map<String, Serializable>>();
//		// List<String> soilTstRsltMapOC = new ArrayList<String>();
//		// List<String> soilTstRsltMapP = new ArrayList<String>();
//		// List<String> soilTstRsltMapK = new ArrayList<String>();
//		//
//		// soilTstRsltMapOC.add("Below 0.5");
//		// soilTstRsltMapOC.add("0.5 - 0.75");
//		// soilTstRsltMapOC.add("Above 0.75");
//		//
//		// soilTstRsltMapP.add("Below 10");
//		// soilTstRsltMapP.add("10 - 20");
//		// soilTstRsltMapP.add("Above 20");
//		//
//		// soilTstRsltMapK.add("Below 280");
//		// soilTstRsltMapK.add("280 - 560");
//		// soilTstRsltMapK.add("Above 560");
//		//
//		// stateList = cassAppDAO.getStateList();
//		// List<Integer> cropList = new ArrayList<Integer>();
//		// cropList.add(3);
//		// cropList.add(4);
//		// cropList.add(5);
//		// cropList.add(6);
//		// cropList.add(7);
//		// cropList.add(8);
//		// for (Integer cropId : cropList) {
//		// for (Map<String, Serializable> stateMap : stateList) {
//		// for (String soilTstRsltOC : soilTstRsltMapOC) {
//		// Map<String, Object> soilTestResultMap = new HashMap<String, Object>();
//		// soilTestResultMap.put("isRfOrIrr", -1);
//		// soilTestResultMap.put("cropId", cropId);
//		// soilTestResultMap.put("isApplyToAllDists", 1);
//		// soilTestResultMap.put("sFertTypeId", 1);
//		// soilTestResultMap.put("soilTestResult", soilTstRsltOC);
//		// cassAppDAO.addSoilTestResult((int) stateMap.get("stateId"), soilTestResultMap);
//		// }
//		//
//		// for (String soilTstRsltP : soilTstRsltMapP) {
//		// Map<String, Object> soilTestResultMap = new HashMap<String, Object>();
//		// soilTestResultMap.put("isRfOrIrr", -1);
//		// soilTestResultMap.put("cropId", cropId);
//		// soilTestResultMap.put("isApplyToAllDists", 1);
//		// soilTestResultMap.put("sFertTypeId", 2);
//		// soilTestResultMap.put("soilTestResult", soilTstRsltP);
//		// cassAppDAO.addSoilTestResult((int) stateMap.get("stateId"), soilTestResultMap);
//		// }
//		//
//		// for (String soilTstRsltK : soilTstRsltMapK) {
//		// Map<String, Object> soilTestResultMap = new HashMap<String, Object>();
//		// soilTestResultMap.put("isRfOrIrr", -1);
//		// soilTestResultMap.put("cropId", cropId);
//		// soilTestResultMap.put("isApplyToAllDists", 1);
//		// soilTestResultMap.put("sFertTypeId", 3);
//		// soilTestResultMap.put("soilTestResult", soilTstRsltK);
//		// cassAppDAO.addSoilTestResult((int) stateMap.get("stateId"), soilTestResultMap);
//		// }
//		// }
//		// }
//
//		// List<Integer> yieldTargetList = new ArrayList<Integer>();
//		// yieldTargetList.add(30);
//		// yieldTargetList.add(40);
//		//
//		// List<String> soilTestResultListOc = new ArrayList<String>();
//		// soilTestResultListOc.add("Below 0.5");
//		// soilTestResultListOc.add("0.5 - 0.75");
//		// soilTestResultListOc.add("Above 0.75");
//		//
//		// List<String> soilTestResultListP = new ArrayList<String>();
//		// soilTestResultListP.add("Below 10");
//		// soilTestResultListP.add("10 - 20");
//		// soilTestResultListP.add("Above 20");
//		//
//		// List<String> soilTestResultListK = new ArrayList<String>();
//		// soilTestResultListK.add("Below 280");
//		// soilTestResultListK.add("280 - 560");
//		// soilTestResultListK.add("Above 560");
//		//
//		// List<Integer> yieldTargetIdList = new ArrayList<Integer>();
//		// List<Integer> soilTestResultIdList = new ArrayList<Integer>();

//		List<Integer> stateList = new ArrayList<Integer>();
//		stateList.add(1);
//		stateList.add(2);
//		stateList.add(3);
//		stateList.add(4);
//		stateList.add(5);
//		stateList.add(6);
//		stateList.add(7);
//		stateList.add(8);
//
//		System.out.println("SWEET POTATO");
//		System.out.println();
//		// 4444444 SWEET POTATO 44444444 SWEET POTATO 4444444444 SWEET POTATO 4444444444444
//		Map<String, Object> soilTestResultFetchCriteriaMap = new HashMap<String, Object>();
//		soilTestResultFetchCriteriaMap.put("isRfOrIrr", -1);
//		soilTestResultFetchCriteriaMap.put("cropId", 4);
//		soilTestResultFetchCriteriaMap.put("isApplyToAllDists", 1);
//
//		CassAppDAO cassAppDAO = new CassAppDAO();
//
//		for (Integer stateId : stateList) {
//
//			// ####################################################//
//			soilTestResultFetchCriteriaMap.put("sFertTypeId", 1);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 0.5");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "62.5");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "0.5 - 0.75");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "50");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 0.75");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "37.5");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// ####################################################//
//			soilTestResultFetchCriteriaMap.put("sFertTypeId", 2);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 10");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "31.25");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "10 - 20");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "25");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 20");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "18.75");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// ####################################################//
//			soilTestResultFetchCriteriaMap.put("sFertTypeId", 3);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 280");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "62.5");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "280 - 560");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "50");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 560");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "37.5");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//		}
//
//		System.out.println("TARO");
//		System.out.println();
//		// 555 TARO 55555 TARO 555555 TARO 5555555 TARO 555555 TARO 555555555
//		soilTestResultFetchCriteriaMap.put("isRfOrIrr", -1);
//		soilTestResultFetchCriteriaMap.put("cropId", 5);
//		soilTestResultFetchCriteriaMap.put("isApplyToAllDists", 1);
//
//		for (Integer stateId : stateList) {
//
//			// ####################################################//
//			soilTestResultFetchCriteriaMap.put("sFertTypeId", 1);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 0.5");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "0.5 - 0.75");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "80");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 0.75");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// ####################################################//
//			soilTestResultFetchCriteriaMap.put("sFertTypeId", 2);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 10");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "31.25");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "10 - 20");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "25");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 20");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "18.75");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// ####################################################//
//			soilTestResultFetchCriteriaMap.put("sFertTypeId", 3);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 280");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "125");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "280 - 560");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//			// -----------------------------------//
//			soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 560");
//
//			soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//			soilTestResultFetchCriteriaMap.put("fertRecomm", "75");
//
//			cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//		}
//		
//		System.out.println("CHINEESE POTATO");
//		System.out.println();
//		
//		// 6666 CHINEESE POTATO 66666666 CHINEESE POTATO 66666666666 CHINEESE POTATO 66666666666666666
//				soilTestResultFetchCriteriaMap.put("isRfOrIrr", -1);
//				soilTestResultFetchCriteriaMap.put("cropId", 6);
//				soilTestResultFetchCriteriaMap.put("isApplyToAllDists", 1);
//
//				for (Integer stateId : stateList) {
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 1);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 0.5");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "0.5 - 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "45");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 2);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 10");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "10 - 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "45");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 3);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 280");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "125");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "280 - 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//				}
//				
//				System.out.println("ARROW ROOT");
//				System.out.println();
//				// 7777777777777 ARROW ROOT 7777777777777 ARROW ROOT 7777777777777 ARROW ROOT 7777777777777
//				soilTestResultFetchCriteriaMap.put("isRfOrIrr", -1);
//				soilTestResultFetchCriteriaMap.put("cropId", 7);
//				soilTestResultFetchCriteriaMap.put("isApplyToAllDists", 1);
//
//				for (Integer stateId : stateList) {
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 1);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 0.5");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "62.5");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "0.5 - 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "50");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "37.5");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 2);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 10");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "31.25");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "10 - 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "25");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "18.75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 3);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 280");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "93.75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "280 - 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "56.25");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//				}
//				
//				
//				
//				
//				List<Integer> stateList1 = new ArrayList<Integer>();
//				stateList1.add(1);
//				stateList1.add(2);
//				stateList1.add(4);
//				stateList1.add(5);
//				stateList1.add(6);
//				stateList1.add(7);
//				stateList1.add(8);
//				
//				System.out.println("YAM BEAN EXCEPT BIHAR");
//				System.out.println();
//				// 8888888888 YAM BEAN 8888888888 YAM BEAN 8888888888 YAM BEAN 8888888888
//				soilTestResultFetchCriteriaMap.put("isRfOrIrr", -1);
//				soilTestResultFetchCriteriaMap.put("cropId", 8);
//				soilTestResultFetchCriteriaMap.put("isApplyToAllDists", 1);
//
//				for (Integer stateId : stateList1) {
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 1);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 0.5");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "0.5 - 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "80");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 2);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 10");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "75");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "10 - 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "45");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 3);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 280");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "280 - 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "80");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(stateId, soilTestResultFetchCriteriaMap);
//				}
//				
//				
//				System.out.println("YAM BEAN BIHAR");
//				System.out.println();
//				// 8888888BIHAR888 YAM BEAN 88888BIHAR88888 YAM BEAN 8888888BIHAR888 YAM BEAN 8888888888 BIHAR
//				soilTestResultFetchCriteriaMap.put("isRfOrIrr", -1);
//				soilTestResultFetchCriteriaMap.put("cropId", 8);
//				soilTestResultFetchCriteriaMap.put("isApplyToAllDists", 1);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 1);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 0.5");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "0.5 - 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "80");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 0.75");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 2);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 10");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "50");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "10 - 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "40");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 20");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "30");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// ####################################################//
//					soilTestResultFetchCriteriaMap.put("sFertTypeId", 3);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Below 280");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "100");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "280 - 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "80");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
//
//					// -----------------------------------//
//					soilTestResultFetchCriteriaMap.put("soilTestResult", "Above 560");
//
//					soilTestResultFetchCriteriaMap.put("yieldTarget", -1);
//					soilTestResultFetchCriteriaMap.put("fertRecomm", "60");
//
//					cassAppDAO.addFertRecommTest(3, soilTestResultFetchCriteriaMap);
		System.out.println(cassAppDAO.getRfIrrStateList(1));

	}
}
