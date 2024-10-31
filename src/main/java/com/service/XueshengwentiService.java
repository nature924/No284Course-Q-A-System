package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengwentiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengwentiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengwentiView;


/**
 * 学生问题
 *
 * @author 
 * @email 
 * @date 2021-04-15 14:47:01
 */
public interface XueshengwentiService extends IService<XueshengwentiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengwentiVO> selectListVO(Wrapper<XueshengwentiEntity> wrapper);
   	
   	XueshengwentiVO selectVO(@Param("ew") Wrapper<XueshengwentiEntity> wrapper);
   	
   	List<XueshengwentiView> selectListView(Wrapper<XueshengwentiEntity> wrapper);
   	
   	XueshengwentiView selectView(@Param("ew") Wrapper<XueshengwentiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengwentiEntity> wrapper);
   	
}

