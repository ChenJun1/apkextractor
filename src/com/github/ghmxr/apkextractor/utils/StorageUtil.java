package com.github.ghmxr.apkextractor.utils;

import java.io.File;

import android.os.Environment;
import android.os.StatFs;

public class StorageUtil {
	
	/**
	 * ��ȡSD��ʣ��ռ���ֽ���
	 * 
	 */
	public static long getSDAvaliableSize(){			
		if(Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
			 File path = Environment.getExternalStorageDirectory();  
		       StatFs stat = new StatFs(path.getPath());  
		       long blockSize = stat.getBlockSize();  
		       long availableBlocks = stat.getAvailableBlocks();   
		       return  blockSize * availableBlocks;
		}
		else{
			return 0;
		}		  
	}
	
	
	/**
	 * ��ȡSD������ģ��SD��·��
	 */
	public static String getSDPath(){ 	   	   
	  if(Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){                               
	       return Environment.getExternalStorageDirectory().toString();//��ȡ��Ŀ¼
	  }   
	    return ""; 
	}

}
