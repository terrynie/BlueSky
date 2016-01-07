package com.bluesky.tools;

import java.util.Iterator;
import java.util.ArrayList;

import com.bluesky.bean.Admin;
import com.bluesky.bean.ConstructionManager;
import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.bean.LawEnforcing;
import com.bluesky.dao.AdminDao;
import com.bluesky.dao.ConstructionManagerDao;
import com.bluesky.dao.InspectionPersonnelDao;
import com.bluesky.dao.LawEnforcingDao;

public class CheckUser {
	public static String checkUser(String dept, String userName, String passwd) {
		System.out.println(dept);
		System.out.println(userName);
		System.out.println(passwd);
		switch (dept) {
		case "Admin":
			ArrayList<Admin> tempAdmin = new AdminDao().queryAdmins();
			Iterator<Admin> iteratorAdmin = tempAdmin.iterator();
			while (iteratorAdmin.hasNext()) {
				Admin admin = iteratorAdmin.next();
				System.out.println(admin.getName().equals(userName));
				System.out.println(admin.getPassword().equals(passwd));
				if (admin.getName().equals(userName) && admin.getPassword().equals(passwd)) {
					return "hasUserNameAndPasswordCorrect";
				} else if (admin.getName().equals(null)) {
					return "hasNoUserName";
				} else if (admin.getName().equals(userName) && !admin.equals(passwd)) {
					return "hasUserNameButPasswordInCorrect";
				}
			}
		case "InspectionPersonnel":
			ArrayList<InspectionPersonnel> tempInspector = new InspectionPersonnelDao().queryInspectors();
			Iterator<InspectionPersonnel> iteratorInspector = tempInspector.iterator();
			while (iteratorInspector.hasNext()) {
				InspectionPersonnel inspector = iteratorInspector.next();
				if (inspector.getName().equals(userName) && inspector.getPassword().equals(passwd)) {
					return "hasUserNameAndPasswordCorrect";
				} else if (inspector.getName().equals(null)) {
					return "hasNoUserName";
				} else if (inspector.getName().equals(userName) && !inspector.equals(passwd)) {
					return "hasUserNameButPasswordInCorrect";
				}
			}
		case "LawEnforcingDept":
			ArrayList<LawEnforcing> tempLawEnforcing = new LawEnforcingDao().queryLawEnforcings();
			Iterator<LawEnforcing> iteratorLawEnforcing = tempLawEnforcing.iterator();
			while (iteratorLawEnforcing.hasNext()) {
				LawEnforcing lawEnforcing = iteratorLawEnforcing.next();
				if (lawEnforcing.getName().equals(userName) && lawEnforcing.getPassword().equals(passwd)) {
					return "hasUserNameAndPasswordCorrect";
				} else if (lawEnforcing.getName().equals(null)) {
					return "hasNoUserName";
				} else if (lawEnforcing.getName().equals(userName) && !lawEnforcing.equals(passwd)) {
					return "hasUserNameButPasswordInCorrect";
				}
			}
		case "ConstructionSiteDirector":
			ArrayList<ConstructionManager> tempConManager = new ConstructionManagerDao().queryManagers();
			Iterator<ConstructionManager> iteratorConManager = tempConManager.iterator();
			while (iteratorConManager.hasNext()) {
				ConstructionManager conManager = iteratorConManager.next();
				if (conManager.getName().equals(userName) && conManager.getPassword().equals(passwd)) {
					return "hasUserNameAndPasswordCorrect";
				} else if (conManager.getName().equals(null)) {
					return "hasNoUserName";
				} else if (conManager.getName().equals(userName) && !conManager.equals(passwd)) {
					return "hasUserNameButPasswordInCorrect";
				}
			}
		default:
			return null;
		}
	}
}
