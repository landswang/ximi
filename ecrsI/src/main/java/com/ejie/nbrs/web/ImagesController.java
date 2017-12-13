package com.ejie.nbrs.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.ScratchFile;
import com.ejie.nbrs.exception.BusinessException;
import com.ejie.nbrs.service.ImagesService;
import com.ejie.nbrs.service.PackDownFileService;
import com.ejie.nbrs.service.impl.ImageCode;
import com.ejie.nbrs.util.ConfigConst;

/**
 * 图片控制器
 * 
 * @author zlg
 * 
 */
@Controller
@RequestMapping("/imagesDo")
public class ImagesController {

  @Autowired
  private ImagesService imagesService;
  @Autowired
  private PackDownFileService pdFileService;

  /**
   * 跳转到上传页面
   * 
   * @return
   */
  @RequestMapping(value = "/uploadPage")
  public String uploadPage() {
    return "imagestest";
  }
  
  /**
   * 
   * trueUploand: 补充附件，确认提交接口
   * @param  @param sc
   *loanId:贷款编号；
   *SerialNo:业务流水号；
   *LoanVoucher:确定的图片数组字符串
   *eProduct:二级分类/图片所属类别码	    
   * @param  @return    设定文件
   * @return BaseResult<Integer>    DOM对象
   * @throws 
   * @since  CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/trueUploand", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<Integer> trueUploand(@RequestBody SearchCondition sc) {
	  
		System.out.println("-----------------------------------------------" + sc);
	    int code = 0;
	    String msg = "";
	 //   Integer i=null;
	    try {
	    	//i=imagesService.insert2(sc);
	        code = 1;
	        msg = "执行成功";
		} catch (Exception e) {
	        code = 0;
	        msg = "执行失败";
	        e.printStackTrace();
		}
	    
		return new BaseResult<Integer>(code, msg, 0);
	  
  }
  
  /**
   * 
   * listSelectScratchFile: 查询资料补充的临时文件结果集
   * @param  @param sc
   * serialNo：流水号；eProduct：所属类别；
   * @param  @return    设定文件
   * @return BaseResult<List<ScratchFile>>    DOM对象
   * @throws 
   * @since  CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/listSelectScratchFile", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<List<ScratchFile>> listSelectScratchFile(@RequestBody SearchCondition sc) {
	  
		System.out.println("-----------------------------------------------" + sc);
	    int code = 0;
	    String msg = "";
	    List<ScratchFile> listScratchFile=null;
	    try {
	    	listScratchFile=imagesService.selectScratchFile(sc);
	    	if(listScratchFile==null){
		        code = 0;
		        msg = "执行成功,结果集为空";
	    	}
	        code = 1;
	        msg = "执行成功";
		} catch (Exception e) {
	        code = 0;
	        msg = "执行失败";
	        e.printStackTrace();
		}

		return new BaseResult<List<ScratchFile>>(code, msg, listScratchFile);
  }
  
  /**
   * 解析上传的文件
   * aBaseName:保存文件地址；eProduct：上传图片所属类别区分；
   * @param file上传的文件
   * @return 文件信息
   * @throws IOException
   * @throws BusinessException
   */
  @RequestMapping(value = "/uploadImages")
  @ResponseBody
  public String photoUpload(@Param("file") MultipartFile file, HttpServletRequest request,
		  SearchCondition sc)
      throws IllegalStateException, IOException, BusinessException {
    String path = imagesService.uploadImages( file, request,sc);
    sc.setLoanVoucher(path);
    imagesService.insertScratchFile(sc);
    return path;
  }
  
/**
 * 
* @Title: deleteImages
* @Description: TODO 删除临时文件/图片
* @param @param sc
* 必要字段：loanId、serialNo、loanVoucher,realPath
* @param @return    参数
* @return String    返回类型
* @throws
 */
  @RequestMapping(value = "/deleteImages")
  @ResponseBody
  public BaseResult<Boolean> deleteImages(@RequestBody SearchCondition sc){
	  	int code = 0;
	    String msg = "删除失败";
	    boolean bool =  false;
	    try {
	    	bool =  imagesService.deleteScratchFile(sc);
	    	code=1;
	    	msg="删除成功";
		} catch (Exception e) {
			e.printStackTrace();
		}

	return new BaseResult<Boolean>(code, msg, bool);
	  
  }

  /*
   * @Resource默认按 byName 自动注入,是J2EE提供的， 需导入Package: javax.annotation.Resource;
   * 
   * @Resource有两个中重要的属性：name和type ，而Spring将@Resource注解的name属性解析为bean的
   * 名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用 type属性时则使用
   * byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用by Name自动注入策略。
   */
  @Resource
  ImageCode imageCodeeee;

  private static String sRand;

  /**
   * 跳转到登录界面页面
   * 
   * @return
   */
  @RequestMapping(value = "/login")
  public String login() {
    return "verycode";
  }

  @RequestMapping(value = "/openLoginPage")
  public String openLoginPage(HttpServletRequest request, HttpServletResponse response) {
    String msg = request.getParameter("msg");
    if (msg == null|| msg.isEmpty()) {
      // 得到用户读入框信息，如果没有输入或者为空，直接跳转到验证失败页面
      return "error";
    } else {
      if (sRand.equalsIgnoreCase((msg))) {
        // 得到用户输入的验证码匹配成功，跳转到验证通过页面
        return "success";
      } else {
        // 得到用户输入的验证码匹配失败，跳转到验证失败页面
        return "error";
      }
    }
  }

  @RequestMapping(value = "/getImage")
  public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // 禁止图片缓存
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    // 将图像输出到servlet输出流中
    ServletOutputStream sos = response.getOutputStream();
    ImageIO.write(imageCodeeee.getImage(request), "jpeg", sos);
    sos.close();
  }

  
  
  
  @RequestMapping(value = "/whetherZip")
  @CrossOrigin
  @ResponseBody
  public BaseResult<String> whetherZip(HttpServletRequest request, HttpServletResponse response,
		  @RequestBody   SearchCondition sc) throws IOException {
    try {
      ConfigConst.getConfigConst();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pdFileService.whetherZip(sc.getSerialNo());

  }
  
  
  @RequestMapping(value = "/fileToZipDown")
  @CrossOrigin
  @ResponseBody
  public void download(HttpServletRequest request, HttpServletResponse response,
      @RequestParam("serialNo") String serialno) throws IOException {
    try {
      ConfigConst.getConfigConst();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // pdFileService.download(serialno,response);

    // return pdFileService.download("1111111111111111",response);
  pdFileService.download(serialno, response);

  }

}
