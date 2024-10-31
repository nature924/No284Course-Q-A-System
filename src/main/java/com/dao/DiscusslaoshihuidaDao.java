package com.dao;

import com.entity.DiscusslaoshihuidaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslaoshihuidaVO;
import com.entity.view.DiscusslaoshihuidaView;


/**
 * 老师回答评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:02
 */
public interface DiscusslaoshihuidaDao extends BaseMapper<DiscusslaoshihuidaEntity> {
	
	List<DiscusslaoshihuidaVO> selectListVO(@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);
	
	DiscusslaoshihuidaVO selectVO(@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);
	
	List<DiscusslaoshihuidaView> selectListView(@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);

	List<DiscusslaoshihuidaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);
	
	DiscusslaoshihuidaView selectView(@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);
	
}
