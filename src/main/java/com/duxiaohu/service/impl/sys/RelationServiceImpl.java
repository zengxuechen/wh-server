package com.duxiaohu.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duxiaohu.dao.RelationDao;
import com.duxiaohu.model.sys.RelationEntity;
import com.duxiaohu.service.sys.RelationService;

@Service(value = "relationServiceImpl")
public class RelationServiceImpl implements RelationService {

	@Autowired
	private RelationDao relationDao;

	@Override
	public List<RelationEntity> getRelationByUserId(int userId) {
		return relationDao.getRelationByUserId(userId);
	}

	@Transactional
	@Override
	public void insertRelations(List<RelationEntity> relationList) {
		relationDao.delById(relationList.get(0).getUserId());
		if (relationList.get(0).getRoleId() != null) {
			relationDao.insertRelations(relationList);
		}
	}

}
