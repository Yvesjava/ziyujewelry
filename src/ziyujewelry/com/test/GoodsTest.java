package ziyujewelry.com.test;

import java.util.HashSet;
import java.util.Set;

import ziyujewelry.com.dao.impl.GoodsTypeDAOImpl;
import ziyujewelry.com.dbc.ConnectionDemo;
import ziyujewelry.com.factory.ServiceFactory;
import ziyujewelry.com.pojo.Goods;
import ziyujewelry.com.pojo.GoodsType;
import ziyujewelry.com.pojo.Mater;
import ziyujewelry.com.util.UtilTool;

public class GoodsTest {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.setGoodsId(76933);
		goods.setGoodsSn("这个是商品编号");
		goods.setGoodsName("商品名字");
		goods.setGoodsImg("E:/fsdf/");
		goods.setGoodsDesc("这是商品描述部分，哈哈哈");
		goods.setMaterId(2);
		goods.setGoodsTypeId(3);
		goods.setMosId(4);
		goods.setShopName("博雅");
		goods.setMarkePrice(299.00);
		goods.setGoodsCost(100.00);
		goods.setGoodsStock(9999);
		goods.setSaleCount(55);
		goods.setIsHot(true);
		goods.setIsNew(true);
		
		Mater mater = new Mater();
		mater.setMaterId(1898);
		mater.setMaterName("大溪地黑珍珠");
		mater.setMaterShape("圆形珠子");
		mater.setMaterCost(350.0);
		mater.setMaterSize("8*8mm");
		
		
		
		
		
		
		
		
		
//		try {
////			System.out.println(ServiceFactory.getIGoodsTypeServiceInstance().insert(gt));
////			System.out.println(ServiceFactory.getIGoodsTypeServiceInstance().delete(s));
////			System.out.println(ServiceFactory.getIGoodsTypeServiceInstance().update(gt));
////			System.out.println(ServiceFactory.getIGoodsTypeServiceInstance().get(88));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

		
//		try {
////			System.out.println(ServiceFactory.getIMaterServiceInstance().insert(mater));
////			System.out.println(ServiceFactory.getIMaterServiceInstance().delete(s));
////			System.out.println(ServiceFactory.getIMaterServiceInstance().get(692629).toString());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		

		
		
		//随机获取商品ID
//		System.out.println((int)(Math.random()*100000));
		
		
//		//执行了删除操作，删除操作需要传入一个set集合，推荐使用hashSet集合
//		Set<Integer> s = new HashSet<Integer>();
//		s.add(1107);
//		try {
//			System.out.println(ServiceFactory.getIGoodsServiceInstance().delete(s));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		//执行了插入数据操作，需要传入一个goods对象，该对象应该要包含ID信息，否则会出现错误
//		try {
//			System.out.println(ServiceFactory.getIGoodsServiceInstance().insert(goods));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//执行了更新操作,因为goodsId是随机生成的，此处要该对象中的ID为表中存在的记录
//		try {
//			System.out.println(ServiceFactory.getIGoodsServiceInstance().update(goods));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		
		
		
	}

}
