package com.macaitech.multimodule.base.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

public class IdUtil {
	
	// 加密映射表 (按位映射)
		static Map<String, String[]> encryptTable = new HashMap<String, String[]>() {
			private static final long serialVersionUID = 1L;
			{
				put("0", new String[] {"4b", "3d", "c5", "1e", "a7", "68", "be", "13", "b0", "49", "76", "83", "6d", "2a", "07", "0a", "e2", "0c", "2d"});
				put("1", new String[] {"ee", "03", "e7", "37", "18", "d0", "40", "cd", "01", "da", "ec", "5a", "71", "d3", "ba", "5b", "89", "bd", "44"});
				put("2", new String[] {"d6", "82", "48", "b3", "1c", "70", "19", "98", "69", "1d", "43", "80", "0d", "6a", "17", "14", "9d", "a5", "8c"});
				put("3", new String[] {"7b", "57", "77", "de", "61", "3a", "2c", "08", "e6", "a4", "58", "02", "81", "0e", "db", "b6", "28", "47", "d7"});
				put("4", new String[] {"20", "42", "38", "cc", "35", "ea", "25", "10", "2e", "12", "92", "36", "84", "b7", "53", "c9", "85", "4e", "d4"});
				put("5", new String[] {"a6", "65", "9e", "aa", "64", "d1", "51", "bc", "52", "4c", "4a", "d9", "05", "09", "95", "4d", "e0", "63", "c0"});
				put("6", new String[] {"6e", "8e", "60", "5d", "06", "3e", "ad", "46", "d2", "5c", "86", "e3", "d8", "99", "66", "ac", "c3", "24", "a0"});
				put("7", new String[] {"5e", "7d", "7e", "b5", "67", "9a", "bb", "8d", "41", "6c", "e5", "a3", "72", "c2", "1b", "11", "54", "29", "62"});
				put("8", new String[] {"0b", "45", "ae", "ce", "8b", "b4", "3b", "c7", "56", "7c", "78", "e8", "b8", "a1", "a9", "d5", "9c", "27", "b2"});
				put("9", new String[] {"23", "cb", "50", "c1", "c6", "8a", "dd", "55", "30", "dc", "33", "59", "75", "16", "91", "ca", "22", "e9", "15"});
			}
		}; 
		
		// 解密映射表
		static Map<String, String> decryptTable = new HashMap<String, String>();
		
		// 随机填充字符串 (按照最后一位的数字映射对应的)
		static Map<Long, String> randTable = new HashMap<Long, String>() {
			private static final long serialVersionUID = 1L;
			{
				put(0l, "eaa18519ee0848558a3e9025ea5de341");
				put(1l, "a67512311c5643a58de05457647be46c");
				put(2l, "491d03ae833464a080de0cbad36ab607");
				put(3l, "b47812314a274abaa8740a819b2e7737");
				put(4l, "81135e21bbdd474c96e9783ada87e434");
				put(5l, "17a39c1e2dee4cbd816b135d630c6465");
				put(6l, "6ba4a1bcc21549bd82248a83e959ea8d");
				put(7l, "edd78cd1389a4908acbcd47bebedb85b");
				put(8l, "aa6c9e83e4244a69a9ceeb056a958632");
				put(9l, "11e72208721e9871314e37e7c790c95a");
			}
		};
		
		static String iDsign = "f5";

		static {
			// 根据加密映射表生成对应的解密映射表
			for (int i = 0; i < 10; i++) {
				String[] ary = encryptTable.get(String.valueOf(i));
				for (int j = 0; j < ary.length; j++) {
					decryptTable.put(ary[j], String.valueOf(i));
				}
			}
		}
		
		// ID串加密
		public static String  IDEncrypt(final long i) {
			if (i <= 0) {
				return "";
			}

			String idString = String.valueOf(i);
			List<String> elements = new ArrayList<String>(){
				private static final long serialVersionUID = 1L;

				{
					add(randTable.get(i % 10));
					add(iDsign);
				}
			}; 
			char[] ids = idString.toCharArray();
			for (int j = 0; j < ids.length; j++) {
				char id = ids[j];
				elements.add( encryptTable.get(String.valueOf(id))[j] );
			}
			
			String result = CollectionsUtil.toString(elements, "");
			
			int length   = result.length();
			int idLength = idString.length();
			
			if (idLength <= 11) {
				return result.substring(length - 24, length);
			}

			if (idLength > 11 && idLength < 16) {
				return result.substring(length-32, length);
			}

			return result.substring(length-40, length);
		}

		// ID串解密
		public static Long IDDecrypt(String s) {
			if (StringUtils.isEmpty(s)) {
				return 0l;
			}
			
			String[] values = s.split(iDsign);
			if (values.length == 1) {
				return 0l;
			}

			String v = values[1];
			int idLength = v.length();

			List<String> elements = new ArrayList<String>();
			for (int i = 0; i < idLength; i+=2) {
				if (i >= idLength-1) {
					return 0l;
				}
				String ch = v.substring(i, i + 2);
				elements.add(decryptTable.get(ch));
			}
			Long result = Long.valueOf(CollectionsUtil.toString(elements, ""));
			return result;
		}
		
		/**
		 * 产生流水ID
		 * @return
		 */
		public static String getTranscationId(String type, String relation) {
			StringBuffer sBuffer = new StringBuffer();
			String random = "";
			while (random.length() < 9) {
				random = String.valueOf(Math.random());
			}
			random = random.substring(2, 9);
			sBuffer.append(type).append(relation).append(DateFormatUtils.format(new Date(), "yyMMddHHmmssSSS")).append(random);
			return sBuffer.toString();
		}
	
	public static void main(String[] args) {
		String result = IDEncrypt(102881);
		//String result = IDEncrypt(6794);
		System.out.println(result);
		System.out.println(IDDecrypt(result));
		//1536559863629414562
		//19473942068295
		//1545825037289448384
		System.out.println(System.currentTimeMillis()*100000);
		//DateUtils.formatDate(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX")
	}
		
}
