package com.dao;

import com.entity.KemuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KemuleixingVO;
import com.entity.view.KemuleixingView;


/**
 * 科目类型
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface KemuleixingDao extends BaseMapper<KemuleixingEntity> {
	
	List<KemuleixingVO> selectListVO(@Param("ew") Wrapper<KemuleixingEntity> wrapper);
	
	KemuleixingVO selectVO(@Param("ew") Wrapper<KemuleixingEntity> wrapper);
	
	List<KemuleixingView> selectListView(@Param("ew") Wrapper<KemuleixingEntity> wrapper);

	List<KemuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<KemuleixingEntity> wrapper);
	
	KemuleixingView selectView(@Param("ew") Wrapper<KemuleixingEntity> wrapper);
	
}
