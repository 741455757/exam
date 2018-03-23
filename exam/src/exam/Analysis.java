package exam;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Analysis {
	
	private static Boolean flag1 = false;
	private static Boolean flag2 = false;
	public static void htmlConvert(File input, File outPut){
		FileInputStream fis =null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		String[] strArr={};
		try {
//			fis = new FileInputStream(input);
//			br = new BufferedReader(new InputStreamReader(fis, "GBK"));
//			br = new BufferedReader(new FileReader(fis));//构造一个BufferedReader
			fis = new FileInputStream(input); 
			isr = new InputStreamReader(fis, "GBK"); 
			br = new BufferedReader(isr); 
			String str = null; 
			while((str = br.readLine())!=null){ 
//				strArr = str.split(",");
				strArr = str.split(",");
			}
			System.out.println(strArr);

//			while((str = br.readLine()) != null){}
//			strArr = str.split(",");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//扇区编号是不是数字
		isData(strArr[2]);
		//id不是以1开头
		isOne(strArr[1]);
		
	}

	private static void isOne(String string) {
		if(!"1".equals(string.charAt(0)))
		{
			throw new IllegalArgumentException();
		}
		flag2 = true;
	}

	private static void isData(String str) {
		 String pattern = "^\\d+$";
         Pattern r = Pattern.compile(pattern);
	     Matcher m = r.matcher(str);
	    if(!m.matches()) {
	    	throw new IllegalArgumentException();
	    }
		flag1 =true;
	}
	
	public static void sort(File input, File outPut)
	{
		FileInputStream fis =null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		String[] strArr= new String[]{};
		ArrayList<AnalysisData> list = new ArrayList<AnalysisData>();
		try {
			fis = new FileInputStream(input); 
			isr = new InputStreamReader(fis, "GBK"); 
			br = new BufferedReader(isr); 
			String str = null; 
			while((str = br.readLine())!=null){ 
				strArr = str.split(",");
				list.add(new AnalysisData(Integer.valueOf(strArr[0]), strArr[1], Integer.valueOf(strArr[2]), strArr[3]));
			}
			System.out.println(strArr);

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sortData(list);
		System.out.println(list);
		
	}

	private static void sortData(ArrayList<AnalysisData> list) {
		TreeSet<AnalysisData> ts = new TreeSet<AnalysisData>(new Comparator<AnalysisData>() {
			@Override
			public int compare(AnalysisData o1, AnalysisData o2) {
				if(o1.equals(o2)){
					return 0;
				}
				int num1 = o2.getNum() - o1.getNum();
				int num2 = o1.getID()- o2.getID();
				if(num1 == 0 && num2 == 0){
					throw new IllegalArgumentException();
				}
				return num1==0?num2: num1;
			}
		});
		ts.addAll(list);
		list.clear();
		list.addAll(ts);
	}
}
