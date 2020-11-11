package cn.edu.imufe.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.imufe.entity.Answer;
import cn.edu.imufe.pojo.Answer_id_title;
import cn.edu.imufe.service.AnswerService;
import cn.edu.imufe.util.RandomList;


/**
 * @author lilei
 *
 * 2020年10月14日
 */
@Controller
@RequestMapping(value="/answer")
public class AnswerController extends BaseController {
	@Autowired
	private AnswerService answerservice;
	
	/**
	 * @功能	根据题目id获取题目信息
	 * @参数	id
	 * @返回值 返回完整的参数信息
	 */
	@ResponseBody
	@RequestMapping(value="/gettitle",method=RequestMethod.GET)
	private Map<String,Object> preview(@RequestParam String id){
		Map<String,Object> modelMap=new HashMap<>();
		if(id!=null && id!="") 
		{
			Answer answer = answerservice.selectByPrimaryKey(Integer.parseInt(id));
			if(answer!=null)
			{
				modelMap.put("message", "success");
				modelMap.put("answer", answer);
			}else  
			{
				modelMap.put("message", "查询为空！");
			}
		}else 
		{
			modelMap.put("message", "请选择题目！");
		}
		
		return modelMap;
	}
	/**
	 * @功能	发送五道随机题目
	 * @参数	暂时无参数
	 * @返回值 返回题目id list
	 */
	@ResponseBody
	@RequestMapping(value="/getrandomquizs",method=RequestMethod.GET)
	private Map<String,Object> getrandomquizs(){
		Map<String,Object> modelMap=new HashMap<>();
		List<Integer> allid = answerservice.selectAllid();
		Integer Random = 5;
		//随机抽取的题目数量
		if(allid!=null)
		{
			@SuppressWarnings("unchecked")
			List<Integer> randomlist = RandomList.createRandomList(allid, Random);
			//获取随机题目id allid为题库中全部id Random为随机抽取的数量
			if(!Random.equals(randomlist.size())) 
			{
				modelMap.put("message", "随机题目数量不足！");
			}else
			{
				modelMap.put("message", "success");
				modelMap.put("randomlist", randomlist);
			}
		}else  
		{
			modelMap.put("message", "没有题库！");
		}
		return modelMap;
	}
	/**
	 * @功能	发送所有题目id
	 * @参数	无参数
	 * @返回值 返回所有题目id list
	 */
	@ResponseBody
	@RequestMapping(value="/getquizs",method=RequestMethod.GET)
	private Map<String,Object> getquizs(){
		Map<String,Object> modelMap=new HashMap<>();
		List<Answer_id_title> allidwithtitle = answerservice.selectAllIdwithTitle();
		if(allidwithtitle!=null)
		{
			modelMap.put("message", "success");
			modelMap.put("alllist", allidwithtitle);
		}else  
		{
			modelMap.put("message", "没有题库！");
		}
		return modelMap;
	}
	/**
	 * @功能	创建新的题目
	 * @参数	Answer
	 * @返回值 message
	 */
	@ResponseBody
	@RequestMapping(value="/createquiz",method=RequestMethod.GET)
	private Map<String,Object> createquiz(@RequestBody Answer answer){
		Map<String,Object> modelMap=new HashMap<>();
		Integer index = answerservice.insertSelective(answer);
		if(index.equals(1)) 
		{
			modelMap.put("message", "success");
		}else 
		{
			modelMap.put("message", "插入失败！");
		}
		return modelMap;
	}
	/**
	 * @功能	删除指定题目
	 * @参数	题目id
	 * @返回值 message
	 */
	@ResponseBody
	@RequestMapping(value="/deletequiz",method=RequestMethod.GET)
	private Map<String,Object> deletequiz(@RequestParam Integer id){
		Map<String,Object> modelMap=new HashMap<>();
		Integer index = answerservice.deleteByPrimaryKey(id);
		if(index.equals(1)) 
		{
			modelMap.put("message", "success");
		}else 
		{
			modelMap.put("message", "删除失败！");
		}
		return modelMap;
	}
	/**
	 * @功能	修改题目
	 * @参数	新的题目信息
	 * @返回值 message
	 */
	@ResponseBody
	@RequestMapping(value="/updatequiz",method=RequestMethod.GET)
	private Map<String,Object> updatequiz(@RequestParam Answer answer){
		Map<String,Object> modelMap=new HashMap<>();
		Integer index = answerservice.updateByPrimaryKeySelective(answer);
		if(index.equals(1)) 
		{
			modelMap.put("message", "success");
		}else 
		{
			modelMap.put("message", "修改失败！");
		}
		return modelMap;
	}
}
