package com.github.ghmxr.apkextractor.utils;

import java.io.File;
import java.io.FileInputStream;

import android.util.Log;

public class FileSize {
	//public static final int SIZETYPE_B = 1;//��ȡ�ļ���С��λΪB��doubleֵ
	//public static final int SIZETYPE_KB = 2;//��ȡ�ļ���С��λΪKB��doubleֵ
	//public static final int SIZETYPE_MB = 3;//��ȡ�ļ���С��λΪMB��doubleֵ
	//public static final int SIZETYPE_GB = 4;//��ȡ�ļ���С��λΪGB��doubleֵ
	
	/**
	 * ��ȡָ���ļ���С
	 * @param f
	 * @return
	 * @throws Exception
	 */
	
	public static long getFileOrFolderSize(File file){		
		/*if (file.exists()){
			FileInputStream fis = null;
			fis = new FileInputStream(file);
			size = fis.available();
			fis.close();
		}
		else{
			//file.createNewFile();
			Log.e("��ȡ�ļ���С","�ļ�������!");
		}  */
		if(file==null) return 0;
		if(!file.exists()) return 0;
		if(!file.isDirectory()) return file.length();
		else{
			long total=0;
			File [] files=file.listFiles();
			if(files==null||files.length==0) return 0;
			for(File f:files){
				total+=getFileOrFolderSize(f);
			}
			return total;
		}		
	}
	
	
	public static long getFileSize(String filepath){
		return filepath!=null?getFileOrFolderSize(new File(filepath)):0;
	}
			
	public static long getFilesSize(String [] filepaths){		
		if(filepaths==null||filepaths.length==0){
			return 0;
		}
		else{
			long total=0;
			for(int i=0;i<filepaths.length;i++){
				total+=getFileSize(filepaths[i]);
			}
			return total;
		}
	}
	
}

