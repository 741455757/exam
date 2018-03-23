package exam;

import java.io.File;

import org.junit.Test;

public class TestTrue {
	@Test
	public void test1(){
		File input = new File("src/1.txt");
		File outPut = new File("1-1.txt");
		try {
			Analysis.htmlConvert(input, outPut);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void test2(){
		File input = new File("src/1.txt");
		File outPut = new File("1-1.txt");
		try {
			Analysis.sort(input, outPut);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
}
