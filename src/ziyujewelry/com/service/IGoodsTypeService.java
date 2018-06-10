package ziyujewelry.com.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ziyujewelry.com.pojo.GoodsType;

public interface IGoodsTypeService {
	public boolean insert(GoodsType goodsType)throws Exception;
	public boolean update(GoodsType goodsType)throws Exception;
	public boolean delete(Set<Integer> goodsTypeId)throws Exception;
	public GoodsType get(Integer goodsTypeId)throws Exception;
	public List<GoodsType> list()throws Exception;
	public Map<String,Object> list(int currentPage,int lineSize,String colnum,String keyWord)throws Exception; 
}
