package com.oraen.oxygen.common.data.collection;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class ArrayUtil {

    public static int[] melt(int[]... intss){
        int len = 0;
        for(int[] ints : intss){
            if(ints != null){
                len += ints.length;
            }
        }

        int[] re = new int[len];
        int index = 0;
        for(int[] ints : intss){
            if(ints != null){
                for(int v : ints){
                    re[index] = v;
                    index ++;
                }
            }
        }

        return re;
    }

    public static double[] melt(double[]... doubless){
        int len = 0;
        for(double[] doubles : doubless){
            if(doubles != null){
                len += doubles.length;
            }
        }

        double[] re = new double[len];
        int index = 0;
        for(double[] doubles : doubless){
            if(doubles != null){
                for(double v : doubles){
                    re[index] = v;
                    index ++;
                }
            }
        }

        return re;
    }

    public static byte[] melt(byte[]... bytess){
        int len = 0;
        for(byte[] bytes : bytess){
            if(bytes != null){
                len += bytes.length;
            }
        }

        byte[] re = new byte[len];
        int index = 0;
        for(byte[] bytes : bytess){
            if(bytes != null){
                for(byte v : bytes){
                    re[index] = v;
                    index ++;
                }
            }
        }

        return re;
    }

    @SafeVarargs
    public static<T> T[] melt(Class<T> clazz, T[]... tss){
        int len = 0;
        for(T[] ts : tss){
            if(ts != null){
                len += ts.length;
            }
        }

        T[] re = (T[]) Array.newInstance(clazz, len);
        int index = 0;
        for(T[] ts : tss){
            if(ts != null){
                for(T v : ts){
                    re[index] = v;
                    index ++;
                }
            }
        }

        return re;
    }
}
