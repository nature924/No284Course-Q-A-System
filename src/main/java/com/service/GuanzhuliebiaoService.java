package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuanzhuliebiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuanzhuliebiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanzhuliebiaoView;


/**
 * 关注列表
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface GuanzhuliebiaoService extends IService<GuanzhuliebiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuanzhuliebiaoVO> selectListVO(Wrapper<GuanzhuliebiaoEntity> wrapper);
   	
   	GuanzhuliebiaoVO selectVO(@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);
   	
   	List<GuanzhuliebiaoView> selectListView(Wrapper<GuanzhuliebiaoEntity> wrapper);
   	
   	GuanzhuliebiaoView selectView(@Param("ew") Wrapper<GuanzhuliebiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuanzhuliebiaoEntity> wrapper);
   	
}

