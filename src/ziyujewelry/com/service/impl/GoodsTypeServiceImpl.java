package ziyujewelry.com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ziyujewelry.com.dbc.ConnectionDemo;
import ziyujewelry.com.factory.DAOFactory;
import ziyujewelry.com.pojo.GoodsType;
import ziyujewelry.com.service.IGoodsTypeService;

public class GoodsTypeServiceImpl implements IGoodsTypeService {
	private ConnectionDemo dbc = new ConnectionDemo();

	@Override
	public boolean insert(GoodsType goodsType) throws Exception {
		try {
			if(DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).findById(goodsType.getGoodsTypeId())==null){
				return DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).doCreate(goodsType);
			}
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return false;
	}

	@Override
	public boolean update(GoodsType goodsType) throws Exception {
		try {
			if(DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).findById(goodsType.getGoodsTypeId())!=null){
				return DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).doUpdate(goodsType);
			}
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return false;
	}

	@Override
	public boolean delete(Set<Integer> goodsTypeId) throws Exception {
		try {
			return DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).doRemoveBatch(goodsTypeId);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

	@Override
	public GoodsType get(Integer goodsTypeId) throws Exception {
		try {
			return DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).findById(goodsTypeId);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

	@Override
	public List<GoodsType> list() throws Exception {
		try {
			return DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String colnum, String keyWord) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("allGoodsType", DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage, lineSize, colnum, keyWord));
			map.put("GoodsTypeCount", DAOFactory.getIGoodsTypeDAOInstance(this.dbc.getConnection()).getAllCount(colnum, keyWord));
			return map;
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
	}

}
