package com.oraen.oxygen.common.device.file;

import com.oraen.oxygen.common.data.collection.Filter;
import com.oraen.oxygen.common.device.file.filter.SuffixFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class DirectoryUtil {

    public static List<File> getAllFile(File path){
        List<File> re = new ArrayList<>();
        File[] files = path.listFiles();
        if(files == null){
            return new ArrayList<>(0);
        }
        for(File f : files){
            if(f.isFile()){
                re.add(f);
            }else if(f.isDirectory()){
                re.addAll(getAllFile(f));
            }
        }

        return re;
    }

    public static List<File> getAllFile(String path){
        return getAllFile(new File(path));
    }

    public static List<File> getSuffixFile(File path, String... suffixes){
        List<File> re = getAllFile(path);
        Filter<File> ff = new SuffixFileFilter(suffixes);
        return ff.filter(re);

    }

    public static List<File> getSuffixFile(String path, String... suffixes){
        return getSuffixFile(new File(path), suffixes);

    }

}
