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


import com.dao.KemuleixingDao;
import com.entity.KemuleixingEntity;
import com.service.KemuleixingService;
import com.entity.vo.KemuleixingVO;
import com.entity.view.KemuleixingView;

@Service("kemuleixingService")
public class KemuleixingServiceImpl extends ServiceImpl<KemuleixingDao, KemuleixingEntity> implements KemuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KemuleixingEntity> page = this.selectPage(
                new Query<KemuleixingEntity>(params).getPage(),
                new EntityWrapper<KemuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KemuleixingEntity> wrapper) {
		  Page<KemuleixingView> page =new Query<KemuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KemuleixingVO> selectListVO(Wrapper<KemuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KemuleixingVO selectVO(Wrapper<KemuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KemuleixingView> selectListView(Wrapper<KemuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KemuleixingView selectView(Wrapper<KemuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
