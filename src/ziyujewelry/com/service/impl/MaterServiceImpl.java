package ziyujewelry.com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ziyujewelry.com.dbc.ConnectionDemo;
import ziyujewelry.com.factory.DAOFactory;
import ziyujewelry.com.pojo.Goods;
import ziyujewelry.com.pojo.Mater;
import ziyujewelry.com.service.IMaterService;

public class MaterServiceImpl implements IMaterService {
	private ConnectionDemo dbc = new ConnectionDemo();
	
	@Override
	public boolean insert(Mater mater) throws Exception {
		try {
			if(DAOFactory.getIMaterDAOInstance(dbc.getConnection()).findById(mater.getMaterId()) == null){
				return DAOFactory.getIMaterDAOInstance(dbc.getConnection()).doCreate(mater);
			}
		}catch(Exception e){
			throw e;
		}finally {
			dbc.close();
		}
		return false;
	}

	@Override
	public boolean update(Mater mater) throws Exception {
		try {
			if(DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).findById(mater.getMaterId()) != null){
				return DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).doUpdate(mater);
			}
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean delete(Set<Integer> materId) throws Exception {
		try {
			return DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).doRemoveBatch(materId);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Mater get(Integer materId) throws Exception {
		try {
			return DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).findById(materId);
		}catch(Exception e){
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Mater> list() throws Exception {
		try {
			return DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e){
			throw e;
		}finally {
			dbc.close();
		}
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize, String colnum, String keyWord) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("allMater", DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).findAll());
			map.put("materCount", DAOFactory.getIMaterDAOInstance(this.dbc.getConnection()).findAllSplit(currentPage, lineSize, colnum, keyWord));
			return map;
		}catch(Exception e){
			throw e;
		}finally {
			dbc.close();
		}
	}

}
