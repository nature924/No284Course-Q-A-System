package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaoshixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshixinxiView;


/**
 * 老师信息
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface LaoshixinxiService extends IService<LaoshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshixinxiVO> selectListVO(Wrapper<LaoshixinxiEntity> wrapper);
   	
   	LaoshixinxiVO selectVO(@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);
   	
   	List<LaoshixinxiView> selectListView(Wrapper<LaoshixinxiEntity> wrapper);
   	
   	LaoshixinxiView selectView(@Param("ew") Wrapper<LaoshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshixinxiEntity> wrapper);
   	
}

