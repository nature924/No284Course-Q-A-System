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


import com.dao.LaoshixinxiDao;
import com.entity.LaoshixinxiEntity;
import com.service.LaoshixinxiService;
import com.entity.vo.LaoshixinxiVO;
import com.entity.view.LaoshixinxiView;

@Service("laoshixinxiService")
public class LaoshixinxiServiceImpl extends ServiceImpl<LaoshixinxiDao, LaoshixinxiEntity> implements LaoshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshixinxiEntity> page = this.selectPage(
                new Query<LaoshixinxiEntity>(params).getPage(),
                new EntityWrapper<LaoshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshixinxiEntity> wrapper) {
		  Page<LaoshixinxiView> page =new Query<LaoshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaoshixinxiVO> selectListVO(Wrapper<LaoshixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaoshixinxiVO selectVO(Wrapper<LaoshixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaoshixinxiView> selectListView(Wrapper<LaoshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshixinxiView selectView(Wrapper<LaoshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
