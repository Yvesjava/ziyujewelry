package ziyujewelry.com.factory;

import ziyujewelry.com.service.IGoodsService;
import ziyujewelry.com.service.IGoodsTypeService;
import ziyujewelry.com.service.IMaterService;
import ziyujewelry.com.service.impl.GoodsServiceImpl;
import ziyujewelry.com.service.impl.GoodsTypeServiceImpl;
import ziyujewelry.com.service.impl.MaterServiceImpl;

public class ServiceFactory {
	public static IGoodsService getIGoodsServiceInstance(){
		return new GoodsServiceImpl();
	}
	
	public static IMaterService getIMaterServiceInstance(){
		return new MaterServiceImpl();
	}
	
	public static IGoodsTypeService getIGoodsTypeServiceInstance(){
		return new GoodsTypeServiceImpl();
	}
}
