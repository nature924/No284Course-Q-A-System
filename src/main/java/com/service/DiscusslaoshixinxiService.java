package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslaoshixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslaoshixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslaoshixinxiView;


/**
 * 老师信息评论表
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:02
 */
public interface DiscusslaoshixinxiService extends IService<DiscusslaoshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslaoshixinxiVO> selectListVO(Wrapper<DiscusslaoshixinxiEntity> wrapper);
   	
   	DiscusslaoshixinxiVO selectVO(@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);
   	
   	List<DiscusslaoshixinxiView> selectListView(Wrapper<DiscusslaoshixinxiEntity> wrapper);
   	
   	DiscusslaoshixinxiView selectView(@Param("ew") Wrapper<DiscusslaoshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslaoshixinxiEntity> wrapper);
   	
}

