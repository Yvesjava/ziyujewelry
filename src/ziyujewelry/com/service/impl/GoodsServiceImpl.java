package ziyujewelry.com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ziyujewelry.com.dbc.ConnectionDemo;
import ziyujewelry.com.factory.DAOFactory;
import ziyujewelry.com.pojo.Goods;
import ziyujewelry.com.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
	private ConnectionDemo dbc = new ConnectionDemo();

	@Override
	public boolean insert(Goods goods) throws Exception {
		try{
			if(DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findById(goods.getGoodsId()) == null){
				return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doCreate(goods);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean update(Goods goods) throws Exception {
		try{
			if(DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findById(goods.getGoodsId()) != null){
				return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdate(goods);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean delete(Set<Integer> goodsId) throws Exception {
		try{
			return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doRemoveBatch(goodsId);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Goods get(Integer goodsId) throws Exception {
		try{
			return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findById(goodsId);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Goods> list() throws Exception {
		try{
			return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String colnum, String keyWord) throws Exception {
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("allGoods", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage, lineSize, colnum, keyWord));
			map.put("GoodsCount", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).getAllCount(colnum, keyWord));
			return map;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
