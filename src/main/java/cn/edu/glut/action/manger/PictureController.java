package cn.edu.glut.action.manger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.glut.util.IDUtils;

/**
 * 图片处理control
 * @author Kuang
 *
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
	/**
	 *商品图片上传
	 * @param uploadFiles
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> uploadPhotos(MultipartFile[] uploadFiles) {
		try {
			String basePath = "D:"+File.separator+"imgs";
			StringBuffer imgUrlSb = new StringBuffer();
			boolean isFrist = true;
			for(MultipartFile uploadfile: uploadFiles) {
				String fileName = IDUtils.genImageName();
				String oriName = uploadfile.getOriginalFilename();  //上传文件名称
				String extName = oriName.substring(oriName.lastIndexOf("."));
				String newFileUrl = new StringBuffer().append(fileName).append(extName).toString();
				StringBuffer savePathSB = new StringBuffer(basePath).append(File.separator).append(newFileUrl);
				uploadfile.transferTo(new File(savePathSB.toString()));
				if(isFrist) {
					isFrist = false;
				}else {
					imgUrlSb.append(",");				
				}
				imgUrlSb.append(newFileUrl);			
			}
			Map<String,Object> result = new HashMap<>();
			result.put("error", 0);
			result.put("imgUrls", imgUrlSb.toString());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return result;
		}
	}
	
	/**
	 *富文本图片上(富文本回调的json格式有具体要求不能使用公共的输出响应�?)
	 * @param uploadFiles
	 * @return
	 */
	@RequestMapping(value="/uploadRichImg",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> uploadRichImg(MultipartFile uploadFile) {
		try {
			//文件保存地址
			String basePath = "D:"+File.separator+"imgs";
			String fileName = IDUtils.genImageName();
			String oriName = uploadFile.getOriginalFilename();  //上传文件名称
			String extName = oriName.substring(oriName.lastIndexOf("."));
			String newFileUrl = new StringBuffer().append(fileName).append(extName).toString();
			StringBuffer savePathSB = new StringBuffer(basePath).append(File.separator).append(newFileUrl);
			uploadFile.transferTo(new File(savePathSB.toString()));
			Map<String,Object> result = new HashMap<>();
			result.put("error", 0);
			//pic后期可以换成文件服务器的地址
			result.put("url", "/pic/"+newFileUrl);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return result;
		}
	}
}
