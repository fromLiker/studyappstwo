package com.hwk.studyapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hwk.studyapp.constant.Const;
import com.hwk.studyapp.entity.Userinfo;
import com.hwk.studyapp.service.LoginService;
import com.hwk.studyapp.utils.CommonResult;

@RunWith(SpringRunner.class)
@SpringBootTest
//no tests found with test runner 'JUnit5'
//class StudyappApplicationTests {
public class StudyappApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private LoginService loginService;

	@Test
	public void userLogin(){
		try {
			Userinfo userinfo = new Userinfo(); 
			userinfo.setUid("Liker@cn.ibm.com");
			userinfo.setUpw("Liker-07");
//			userinfo.setUrole("");
//			userinfo.setUname("");
//			userinfo.setMskill("");
//			userinfo.setMstarttime(null);
//			userinfo.setMendtime(null);
//			userinfo.setMrates(null);
//			userinfo.setMamount(null);
//			userinfo.setAstatus("");
//			userinfo.setCommone("");
//			userinfo.setCommtwo("");
			CommonResult result = loginService.getUserinfo(userinfo);
	  	  System.out.println("1*****1******" + result.getData());
	      System.out.println("2*****2******" + result.getStatus());
	      System.out.println("3*****3******" + result.getMsg());
	      
			List<Userinfo> list = (List<Userinfo>) result.getData();
			if(list.size() > 0) {
				for(int i=0; i < list.size(); i++){
					Userinfo loginuserinfo = list.get(i);
					System.out.println("login user inof******" + loginuserinfo.getUname());
					System.out.println("login user inof******" + loginuserinfo.getUrole());
				}
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		    CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "Error");
		}
	}
}
