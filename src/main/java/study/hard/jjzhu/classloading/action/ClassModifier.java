package study.hard.jjzhu.classloading.action;

/** 
* @ClassName: ClassModifier 
* 修改class文件（只修改常量池常量）
* @author 祝佳俊(jjzhu_ncu@163.com)
* @date 2016年10月30日 下午8:22:28 
*  
*/
public class ClassModifier {
	/**
	 * class 文件中常量池的起始偏移
	 */
	private static final int CONSTANT_POOP_COUNT_INDEX = 8;
	
	/**
	 * CONSTANT_Utf8_info 常量的tag标志
	 */
	private static final int CONSTANT_Utf8_info = 1;
	
	/**
	 * 常量池中11中变量所占的长度，CONSTANT_Utf8_info除外（因其不定长）
	 */
	private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, 5, -1, 5, 9, 9, 3, 3, 5, 5, 5, 5};
	
	private static final int u1 = 1;
	private static final int u2 = 2;
	private byte[] classByte;
	
	public ClassModifier(byte[] classByte){
		this.classByte = classByte;
	}
	
	/** 
	 * 获取常量池中常量的数量
	* @Title: getConstatnPoolCount
	* @return int 
	*/
	public int getConstantPoolCount(){
		return ByteUtils.bytes2Int(classByte, CONSTANT_POOP_COUNT_INDEX, u2);
	}
	
	/** 
	* 修改CONSTANT_Utf8_info常量的内容
	* @param oldStr
	* @param newStr
	* @return  
	* @return byte[] 
	*/
	public byte[] modifyUTF8Constant(String oldStr, String newStr){
		int cpc = getConstantPoolCount();
		int offset = CONSTANT_POOP_COUNT_INDEX + u2;
		for(int i = 0 ; i<cpc; i++){
			int tag = ByteUtils.bytes2Int(classByte, offset, u1);
			if(tag == CONSTANT_Utf8_info){
				int len = ByteUtils.bytes2Int(classByte, offset, u1);
				offset += (u1 + u2);
				String str = ByteUtils.byte2String(classByte, offset, len);
				if(str.equalsIgnoreCase(oldStr)){
					byte[] strBytes = ByteUtils.string2Bytes(newStr);
					byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
					classByte = ByteUtils.bytesReplace(classByte, offset-u2, u2, strLen);
					classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
					return classByte;
				}else{
					offset += len;
				}
			}else{
				offset += CONSTANT_ITEM_LENGTH[tag];
			}
		}
		return classByte;
	}
	
}
