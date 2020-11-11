package cn.edu.imufe.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.imufe.entity.Answerhistory;
import cn.edu.imufe.entity.AnswerhistoryExample;

public interface AnswerHistoryService {
    int countByExample(AnswerhistoryExample example);

    int deleteByExample(AnswerhistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Answerhistory record);

    int insertSelective(Answerhistory record);

    List<Answerhistory> selectByExample(AnswerhistoryExample example);

    Answerhistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Answerhistory record, @Param("example") AnswerhistoryExample example);

    int updateByExample(@Param("record") Answerhistory record, @Param("example") AnswerhistoryExample example);

    int updateByPrimaryKeySelective(Answerhistory record);

    int updateByPrimaryKey(Answerhistory record);
}
