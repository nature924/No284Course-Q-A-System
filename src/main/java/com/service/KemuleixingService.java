package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KemuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KemuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KemuleixingView;


/**
 * 科目类型
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface KemuleixingService extends IService<KemuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KemuleixingVO> selectListVO(Wrapper<KemuleixingEntity> wrapper);
   	
   	KemuleixingVO selectVO(@Param("ew") Wrapper<KemuleixingEntity> wrapper);
   	
   	List<KemuleixingView> selectListView(Wrapper<KemuleixingEntity> wrapper);
   	
   	KemuleixingView selectView(@Param("ew") Wrapper<KemuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KemuleixingEntity> wrapper);
   	
}

