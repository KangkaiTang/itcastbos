package com.kk.bos.pinyin;

import java.util.Arrays;

import org.junit.Test;

import com.kk.bos.utils.PinYin4jUtils;

public class PinyinTest {
	@Test
	public void test() {
		String str0 = "浙江省" ;
		System.out.println(str0.substring(0, str0.length()-1));
		System.out.println(str0);
		
	
		
		String str2 = PinYin4jUtils.getNamePinyin("北京市");
		System.out.println(str2);
		
		String str3 = PinYin4jUtils.getHeader("浙江省");
		System.out.println(str3);
	}
}
