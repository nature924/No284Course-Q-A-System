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


import com.dao.DiscusslaoshihuidaDao;
import com.entity.DiscusslaoshihuidaEntity;
import com.service.DiscusslaoshihuidaService;
import com.entity.vo.DiscusslaoshihuidaVO;
import com.entity.view.DiscusslaoshihuidaView;

@Service("discusslaoshihuidaService")
public class DiscusslaoshihuidaServiceImpl extends ServiceImpl<DiscusslaoshihuidaDao, DiscusslaoshihuidaEntity> implements DiscusslaoshihuidaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslaoshihuidaEntity> page = this.selectPage(
                new Query<DiscusslaoshihuidaEntity>(params).getPage(),
                new EntityWrapper<DiscusslaoshihuidaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslaoshihuidaEntity> wrapper) {
		  Page<DiscusslaoshihuidaView> page =new Query<DiscusslaoshihuidaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslaoshihuidaVO> selectListVO(Wrapper<DiscusslaoshihuidaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslaoshihuidaVO selectVO(Wrapper<DiscusslaoshihuidaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslaoshihuidaView> selectListView(Wrapper<DiscusslaoshihuidaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslaoshihuidaView selectView(Wrapper<DiscusslaoshihuidaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
