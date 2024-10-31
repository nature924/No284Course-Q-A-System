package com.dao;

import com.entity.DiscusslaoshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslaoshixinxiVO;
import com.entity.view.DiscusslaoshixinxiView;


/**
 * 老师信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:02
 */
public interface DiscusslaoshixinxiDao extends BaseMapper<DiscusslaoshixinxiEntity> {
	
	List<DiscusslaoshixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);
	
	DiscusslaoshixinxiVO selectVO(@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);
	
	List<DiscusslaoshixinxiView> selectListView(@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);

	List<DiscusslaoshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);
	
	DiscusslaoshixinxiView selectView(@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);
	
}
