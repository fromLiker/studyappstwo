package com.hwk.studyapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwk.studyapp.constant.Const;
import com.hwk.studyapp.dao.UserinfoMapper;
import com.hwk.studyapp.entity.Userinfo;
import com.hwk.studyapp.utils.CommonResult;

@Service
public class LoginService {

    @Autowired
    private UserinfoMapper userinfoMapper;
    
    private static Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	public CommonResult getUserinfo(Userinfo userinfo) throws Exception{

		List<Userinfo> userinfoList = userinfoMapper.selectUserinfoList(userinfo);
        
        if(null!= userinfoList && userinfoList.size()>0){
        	logger.info("reture userinfoList");
        	return CommonResult.build(Const.COMMONRESULT_OK_CODE, "Login successfully!", userinfoList);

        }
        return CommonResult.build(500, "There is no userinfo in DB.");
	}
	
}
