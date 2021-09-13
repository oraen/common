package com.oraen.oxygen.common.device.file.filter;

import com.oraen.oxygen.common.data.collection.Filter;

import java.io.File;
import java.util.*;

public class SuffixFileFilter implements Filter<File> {

    private final Set<String> targetSuffix = new HashSet<>();

    public SuffixFileFilter(String... suffixes){
        targetSuffix.addAll(Arrays.asList(suffixes));
    }

    public SuffixFileFilter(Collection<String> suffixList){
        targetSuffix.addAll(suffixList);
    }


    @Override
    public <TS extends File> boolean isLegal(TS ts) {
        if(ts.isFile()){
            String[] split = ts.getName().split("\\.");
            String suffix = split[split.length - 1];
            if(targetSuffix.contains(suffix)){
                return true;
            }
        }

        return false;
    }
}
