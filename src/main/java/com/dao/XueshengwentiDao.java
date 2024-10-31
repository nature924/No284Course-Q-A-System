package com.dao;

import com.entity.XueshengwentiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengwentiVO;
import com.entity.view.XueshengwentiView;


/**
 * 学生问题
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface XueshengwentiDao extends BaseMapper<XueshengwentiEntity> {
	
	List<XueshengwentiVO> selectListVO(@Param("ew") Wrapper<XueshengwentiEntity> wrapper);
	
	XueshengwentiVO selectVO(@Param("ew") Wrapper<XueshengwentiEntity> wrapper);
	
	List<XueshengwentiView> selectListView(@Param("ew") Wrapper<XueshengwentiEntity> wrapper);

	List<XueshengwentiView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengwentiEntity> wrapper);
	
	XueshengwentiView selectView(@Param("ew") Wrapper<XueshengwentiEntity> wrapper);
	
}
