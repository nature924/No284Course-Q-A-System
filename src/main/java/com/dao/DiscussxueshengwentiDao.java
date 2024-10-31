package com.dao;

import com.entity.DiscussxueshengwentiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxueshengwentiVO;
import com.entity.view.DiscussxueshengwentiView;


/**
 * 学生问题评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:02
 */
public interface DiscussxueshengwentiDao extends BaseMapper<DiscussxueshengwentiEntity> {
	
	List<DiscussxueshengwentiVO> selectListVO(@Param("ew") Wrapper<DiscussxueshengwentiEntity> wrapper);
	
	DiscussxueshengwentiVO selectVO(@Param("ew") Wrapper<DiscussxueshengwentiEntity> wrapper);
	
	List<DiscussxueshengwentiView> selectListView(@Param("ew") Wrapper<DiscussxueshengwentiEntity> wrapper);

	List<DiscussxueshengwentiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxueshengwentiEntity> wrapper);
	
	DiscussxueshengwentiView selectView(@Param("ew") Wrapper<DiscussxueshengwentiEntity> wrapper);
	
}
