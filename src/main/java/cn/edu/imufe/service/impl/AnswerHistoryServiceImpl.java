package cn.edu.imufe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.imufe.dao.AnswerhistoryDao;
import cn.edu.imufe.entity.Answerhistory;
import cn.edu.imufe.entity.AnswerhistoryExample;
import cn.edu.imufe.service.*;
@Service
public class AnswerHistoryServiceImpl implements AnswerHistoryService {
	@Autowired
	AnswerhistoryDao AD;
	@Override
	public int countByExample(AnswerhistoryExample example) {
		return AD.countByExample(example);
	}

	@Override
	public int deleteByExample(AnswerhistoryExample example) {
		return AD.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return AD.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Answerhistory record) {
		return AD.insert(record);
	}

	@Override
	public int insertSelective(Answerhistory record) {
		return AD.insertSelective(record);
	}

	@Override
	public List<Answerhistory> selectByExample(AnswerhistoryExample example) {
		return AD.selectByExample(example);
	}

	@Override
	public Answerhistory selectByPrimaryKey(Integer id) {
		return AD.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Answerhistory record, AnswerhistoryExample example) {
		return AD.updateByExample(record, example);
	}

	@Override
	public int updateByExample(Answerhistory record, AnswerhistoryExample example) {
		return AD.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Answerhistory record) {
		return AD.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Answerhistory record) {
		return AD.updateByPrimaryKey(record);
	}

}
