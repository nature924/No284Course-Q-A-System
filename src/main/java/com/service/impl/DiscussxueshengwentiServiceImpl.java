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


import com.dao.DiscussxueshengwentiDao;
import com.entity.DiscussxueshengwentiEntity;
import com.service.DiscussxueshengwentiService;
import com.entity.vo.DiscussxueshengwentiVO;
import com.entity.view.DiscussxueshengwentiView;

@Service("discussxueshengwentiService")
public class DiscussxueshengwentiServiceImpl extends ServiceImpl<DiscussxueshengwentiDao, DiscussxueshengwentiEntity> implements DiscussxueshengwentiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxueshengwentiEntity> page = this.selectPage(
                new Query<DiscussxueshengwentiEntity>(params).getPage(),
                new EntityWrapper<DiscussxueshengwentiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxueshengwentiEntity> wrapper) {
		  Page<DiscussxueshengwentiView> page =new Query<DiscussxueshengwentiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxueshengwentiVO> selectListVO(Wrapper<DiscussxueshengwentiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxueshengwentiVO selectVO(Wrapper<DiscussxueshengwentiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxueshengwentiView> selectListView(Wrapper<DiscussxueshengwentiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxueshengwentiView selectView(Wrapper<DiscussxueshengwentiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
