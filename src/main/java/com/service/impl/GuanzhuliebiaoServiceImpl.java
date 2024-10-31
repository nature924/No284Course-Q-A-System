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


import com.dao.GuanzhuliebiaoDao;
import com.entity.GuanzhuliebiaoEntity;
import com.service.GuanzhuliebiaoService;
import com.entity.vo.GuanzhuliebiaoVO;
import com.entity.view.GuanzhuliebiaoView;

@Service("guanzhuliebiaoService")
public class GuanzhuliebiaoServiceImpl extends ServiceImpl<GuanzhuliebiaoDao, GuanzhuliebiaoEntity> implements GuanzhuliebiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuanzhuliebiaoEntity> page = this.selectPage(
                new Query<GuanzhuliebiaoEntity>(params).getPage(),
                new EntityWrapper<GuanzhuliebiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuanzhuliebiaoEntity> wrapper) {
		  Page<GuanzhuliebiaoView> page =new Query<GuanzhuliebiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuanzhuliebiaoVO> selectListVO(Wrapper<GuanzhuliebiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuanzhuliebiaoVO selectVO(Wrapper<GuanzhuliebiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuanzhuliebiaoView> selectListView(Wrapper<GuanzhuliebiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuanzhuliebiaoView selectView(Wrapper<GuanzhuliebiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
