package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaoshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshiView;


/**
 * 老师
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface LaoshiService extends IService<LaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshiVO> selectListVO(Wrapper<LaoshiEntity> wrapper);
   	
   	LaoshiVO selectVO(@Param("ew") Wrapper<LaoshiEntity> wrapper);
   	
   	List<LaoshiView> selectListView(Wrapper<LaoshiEntity> wrapper);
   	
   	LaoshiView selectView(@Param("ew") Wrapper<LaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshiEntity> wrapper);
   	
}

