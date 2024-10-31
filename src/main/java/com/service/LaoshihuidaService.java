package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshihuidaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaoshihuidaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshihuidaView;


/**
 * 老师回答
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface LaoshihuidaService extends IService<LaoshihuidaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshihuidaVO> selectListVO(Wrapper<LaoshihuidaEntity> wrapper);
   	
   	LaoshihuidaVO selectVO(@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);
   	
   	List<LaoshihuidaView> selectListView(Wrapper<LaoshihuidaEntity> wrapper);
   	
   	LaoshihuidaView selectView(@Param("ew") Wrapper<LaoshihuidaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshihuidaEntity> wrapper);
   	
}

