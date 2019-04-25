package com.hefa.user.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.PageHelper;
import com.hefa.common.base.JsonResult;
import com.hefa.common.exception.ValidationException;
import com.hefa.common.page.Pagination;
import com.hefa.system.sequence.api.DbSequenceService;
import com.hefa.user.mapper.PlatformRegionMapper;
import com.hefa.user.pojo.PlatformRegion;
import com.hefa.user.pojo.bo.RegionAdd;
import com.hefa.user.pojo.bo.RegionUserParam;
import com.hefa.user.pojo.vo.RegionUserInfo;

@Service
public class PlatfromRegionService {

	@Autowired
	private PlatformRegionMapper platfromRegionMapper;
	
	@Autowired
	private DbSequenceService dbSequenceService;
	
	/**
	 * 获取区域列表数据
	 * @param param
	 * @return
	 */
	public JsonResult<Pagination<RegionUserInfo>> getRegionList(@RequestBody RegionUserParam param){
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<RegionUserInfo> list = platfromRegionMapper.getRegionList(param);
		return JsonResult.successJsonResult(new Pagination<>(list));
	}
	
	/**
	 * 
	 * <p>添加售后区域</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> addRegion(@RequestBody RegionAdd regionAdd){
		String area = regionAdd.getRegionArea();
		String area2 = platfromRegionMapper.selectUserCodeByArea(area.replace("/", ""));
		if(StringUtils.isNotBlank(area2))  throw new ValidationException("区域已存在"); 
		String[] split = area.split("/");
		PlatformRegion pr = new PlatformRegion();
		pr.setPlatfromUserCode(regionAdd.getPlatfromUserCode());
		pr.setRegionCreatime(new Date());
		pr.setRegionProvince(split.length >= 1? split[0]:"");
		pr.setRegionCity(split.length >= 2? split[1]:"");
		pr.setRegionArea(split.length >= 3? split[2]:"");
		pr.setRegionCode(dbSequenceService.getPlatRegionNumber());
		pr.setRegionModifytime(null);
		pr.setStatus((byte)1);
		platfromRegionMapper.insertRegion(pr);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>售后区域变更 人员变更</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> updateRegionchange(@RequestBody RegionAdd regionAdd){
		String[] split = regionAdd.getRegionArea().split("/");
		PlatformRegion pr = new PlatformRegion();
		pr.setPlatfromUserCode(regionAdd.getPlatfromUserCode());
		pr.setRegionProvince(split.length >= 1? split[0]:"");
		pr.setRegionCity(split.length >= 2? split[1]:"");
		pr.setRegionArea(split.length >= 3? split[2]:"");
		pr.setId(regionAdd.getId());
		pr.setRegionModifytime(new Date());
		platfromRegionMapper.updateRegion(pr);
		return JsonResult.successJsonResult();
	}
	
	/**
	 * 
	 * <p>售后区域人员删除</p>
	 * @param param
	 * @return
	 * @author jonly  
	 */
	public JsonResult<String> deleteRegion(Long id ){
		platfromRegionMapper.deleteRegion(id);
		return JsonResult.successJsonResult();
	}
}
