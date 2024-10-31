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


import com.dao.LaoshiDao;
import com.entity.LaoshiEntity;
import com.service.LaoshiService;
import com.entity.vo.LaoshiVO;
import com.entity.view.LaoshiView;

@Service("laoshiService")
public class LaoshiServiceImpl extends ServiceImpl<LaoshiDao, LaoshiEntity> implements LaoshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshiEntity> page = this.selectPage(
                new Query<LaoshiEntity>(params).getPage(),
                new EntityWrapper<LaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshiEntity> wrapper) {
		  Page<LaoshiView> page =new Query<LaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaoshiVO> selectListVO(Wrapper<LaoshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaoshiVO selectVO(Wrapper<LaoshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaoshiView> selectListView(Wrapper<LaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshiView selectView(Wrapper<LaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
