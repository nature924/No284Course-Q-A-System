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


import com.dao.LaoshihuidaDao;
import com.entity.LaoshihuidaEntity;
import com.service.LaoshihuidaService;
import com.entity.vo.LaoshihuidaVO;
import com.entity.view.LaoshihuidaView;

@Service("laoshihuidaService")
public class LaoshihuidaServiceImpl extends ServiceImpl<LaoshihuidaDao, LaoshihuidaEntity> implements LaoshihuidaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshihuidaEntity> page = this.selectPage(
                new Query<LaoshihuidaEntity>(params).getPage(),
                new EntityWrapper<LaoshihuidaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshihuidaEntity> wrapper) {
		  Page<LaoshihuidaView> page =new Query<LaoshihuidaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaoshihuidaVO> selectListVO(Wrapper<LaoshihuidaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaoshihuidaVO selectVO(Wrapper<LaoshihuidaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaoshihuidaView> selectListView(Wrapper<LaoshihuidaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshihuidaView selectView(Wrapper<LaoshihuidaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
