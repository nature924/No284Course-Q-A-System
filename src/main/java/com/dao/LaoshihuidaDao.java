package com.dao;

import com.entity.LaoshihuidaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaoshihuidaVO;
import com.entity.view.LaoshihuidaView;


/**
 * 老师回答
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface LaoshihuidaDao extends BaseMapper<LaoshihuidaEntity> {
	
	List<LaoshihuidaVO> selectListVO(@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);
	
	LaoshihuidaVO selectVO(@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);
	
	List<LaoshihuidaView> selectListView(@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);

	List<LaoshihuidaView> selectListView(Pagination page,@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);
	
	LaoshihuidaView selectView(@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);
	
}
