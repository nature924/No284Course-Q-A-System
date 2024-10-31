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


import com.dao.DiscusslaoshixinxiDao;
import com.entity.DiscusslaoshixinxiEntity;
import com.service.DiscusslaoshixinxiService;
import com.entity.vo.DiscusslaoshixinxiVO;
import com.entity.view.DiscusslaoshixinxiView;

@Service("discusslaoshixinxiService")
public class DiscusslaoshixinxiServiceImpl extends ServiceImpl<DiscusslaoshixinxiDao, DiscusslaoshixinxiEntity> implements DiscusslaoshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslaoshixinxiEntity> page = this.selectPage(
                new Query<DiscusslaoshixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusslaoshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslaoshixinxiEntity> wrapper) {
		  Page<DiscusslaoshixinxiView> page =new Query<DiscusslaoshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslaoshixinxiVO> selectListVO(Wrapper<DiscusslaoshixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslaoshixinxiVO selectVO(Wrapper<DiscusslaoshixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslaoshixinxiView> selectListView(Wrapper<DiscusslaoshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslaoshixinxiView selectView(Wrapper<DiscusslaoshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
