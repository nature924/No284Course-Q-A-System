package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XueshengwentiDao;
import com.entity.XueshengwentiEntity;
import com.service.XueshengwentiService;
import com.entity.vo.XueshengwentiVO;
import com.entity.view.XueshengwentiView;

@Service("xueshengwentiService")
public class XueshengwentiServiceImpl extends ServiceImpl<XueshengwentiDao, XueshengwentiEntity> implements XueshengwentiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengwentiEntity> page = this.selectPage(
                new Query<XueshengwentiEntity>(params).getPage(),
                new EntityWrapper<XueshengwentiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengwentiEntity> wrapper) {
		  Page<XueshengwentiView> page =new Query<XueshengwentiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengwentiVO> selectListVO(Wrapper<XueshengwentiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengwentiVO selectVO(Wrapper<XueshengwentiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengwentiView> selectListView(Wrapper<XueshengwentiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengwentiView selectView(Wrapper<XueshengwentiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
