package ziyujewelry.com.factory;



import java.sql.Connection;

import ziyujewelry.com.dao.IGoodsDAO;
import ziyujewelry.com.dao.IGoodsTypeDAO;
import ziyujewelry.com.dao.IMaterDAO;
import ziyujewelry.com.dao.impl.GoodsDAOImpl;
import ziyujewelry.com.dao.impl.GoodsTypeDAOImpl;
import ziyujewelry.com.dao.impl.MaterDAOImpl;


/**
 * 工厂类，只需调用工厂类里的对应方法，就可获取对应的接口类
 * @author Administrator
 *
 */
public class DAOFactory {
	
	public static IGoodsDAO getIGoodsDAOInstance(Connection conn){
		return new GoodsDAOImpl(conn);
	}
	
	public static IMaterDAO getIMaterDAOInstance(Connection conn){
		return new MaterDAOImpl(conn);
	}
	
	public static IGoodsTypeDAO getIGoodsTypeDAOInstance(Connection conn){
		return new GoodsTypeDAOImpl(conn);
	}
	
}
