package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslaoshihuidaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslaoshihuidaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslaoshihuidaView;


/**
 * 老师回答评论表
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:02
 */
public interface DiscusslaoshihuidaService extends IService<DiscusslaoshihuidaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslaoshihuidaVO> selectListVO(Wrapper<DiscusslaoshihuidaEntity> wrapper);
   	
   	DiscusslaoshihuidaVO selectVO(@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);
   	
   	List<DiscusslaoshihuidaView> selectListView(Wrapper<DiscusslaoshihuidaEntity> wrapper);
   	
   	DiscusslaoshihuidaView selectView(@Param("ew") Wrapper<DiscusslaoshihuidaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslaoshihuidaEntity> wrapper);
   	
}

