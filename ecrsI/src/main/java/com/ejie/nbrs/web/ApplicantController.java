package com.ejie.nbrs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:ApplicantController 借款人档案信息
 * 
 * @author zlg
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月20日 上午9:28:55
 * @see
 */
@RequestMapping("/applicant")
@Controller
public class ApplicantController {
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getApplicantList", method = RequestMethod.GET)
	@CrossOrigin
	@ResponseBody
	public String getApplicantList(){
		
		return "MyJsp";
	}

}
