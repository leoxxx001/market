package cn.com.carit.market.service.impl.app;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.carit.market.bean.app.AppComment;
import cn.com.carit.market.common.utils.DataGridModel;
import cn.com.carit.market.common.utils.JsonPage;
import cn.com.carit.market.dao.app.AppCommentDao;
import cn.com.carit.market.service.app.AppCommentService;

/**
 * AppCommentServiceImpl
 * Auto generated Code
 */
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class AppCommentServiceImpl implements AppCommentService{
	
	@Resource
	private AppCommentDao appCommentDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int saveOrUpdate(AppComment appComment) {
		if (appComment==null) {
			throw new NullPointerException("appComment object is null...");
		}
		if (appComment.getId()==0) {
			return appCommentDao.add(appComment);
		}
		return appCommentDao.update(appComment);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public int delete(int id) {
		if (id<=0) {
			throw new IllegalArgumentException("id must bigger than 0...");
		}
		return appCommentDao.delete(id);
	}

	@Override
	public AppComment queryById(int id) {
		if (id<=0) {
			throw new IllegalArgumentException("id must bigger than 0...");
		}
		return appCommentDao.queryById(id);
	}

	@Override
	public List<AppComment> query() {
		return appCommentDao.query();
	}

	@Override
	public List<AppComment> queryByExemple(AppComment appComment) {
		if (appComment==null) {
			throw new NullPointerException("must given an exemple...");
		}
		return appCommentDao.queryByExemple(appComment);
	}

	@Override
	public JsonPage queryByExemple(AppComment appComment, DataGridModel dgm) {
		if (appComment==null) {
			throw new NullPointerException("must given an exemple...");
		}
		return appCommentDao.queryByExemple(appComment, dgm);
	}

	@Override
	public int getCount(AppComment appComment) {
		if (appComment==null) {
			throw new NullPointerException("must given an exemple...");
		}
		return appCommentDao.getCount(appComment);
	}
}
