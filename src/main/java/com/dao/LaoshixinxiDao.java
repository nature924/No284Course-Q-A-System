package com.dao;

import com.entity.LaoshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaoshixinxiVO;
import com.entity.view.LaoshixinxiView;


/**
 * 老师信息
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface LaoshixinxiDao extends BaseMapper<LaoshixinxiEntity> {
	
	List<LaoshixinxiVO> selectListVO(@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);
	
	LaoshixinxiVO selectVO(@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);
	
	List<LaoshixinxiView> selectListView(@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);

	List<LaoshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);
	
	LaoshixinxiView selectView(@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);
	
}
