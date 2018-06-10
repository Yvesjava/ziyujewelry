package ziyujewelry.com.util;

public class UtilTool {
	

	/**
	 * 产生一个随机数
	 * @param i 传入要int的数值，定义随机数的位数,该值必须是大于0的一个正整数，否则返回0
	 * @return 返回一个随机数
	 */
	public static Integer getRandom(Integer i){
		if(i<=0){
			return 0;
		}
		Integer rand = (int)((Math.random()*9+1)*(Math.pow(10, i-1)));
		return rand;
	}
}
