package com.hwk.studyapp.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hwk.studyapp.constant.Const;
import com.hwk.studyapp.entity.Userinfo;
import com.hwk.studyapp.service.LoginService;
import com.hwk.studyapp.utils.CommonResult;

@RestController
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = "hwk/login", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public CommonResult loginCtrl(@RequestHeader String token, @RequestBody Userinfo userinfo) {

    	String userid = userinfo.getUid();
    	String userpw = userinfo.getUpw();
    	
    	if (StringUtils.isBlank(token))
            return CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "user token is null.", null);
        if (StringUtils.isBlank(userid))
            return CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "user id is null", null); 
        if (StringUtils.isBlank(userpw))
            return CommonResult.build(Const.COMMONRESULT_ERROR_CODE, "user password is null", null); 
    	try {
        	CommonResult res = loginService.getUserinfo(userinfo);
        	System.out.println("***********2::" + res);
        	return res;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR");
            return CommonResult.build(500, "There is no userinfo in DB.");
        }
    }
}
