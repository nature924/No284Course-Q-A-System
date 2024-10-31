package com.dao;

import com.entity.GuanzhuliebiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuanzhuliebiaoVO;
import com.entity.view.GuanzhuliebiaoView;


/**
 * 关注列表
 * 
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface GuanzhuliebiaoDao extends BaseMapper<GuanzhuliebiaoEntity> {
	
	List<GuanzhuliebiaoVO> selectListVO(@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);
	
	GuanzhuliebiaoVO selectVO(@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);
	
	List<GuanzhuliebiaoView> selectListView(@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);

	List<GuanzhuliebiaoView> selectListView(Pagination page,@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);
	
	GuanzhuliebiaoView selectView(@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);
	
}
