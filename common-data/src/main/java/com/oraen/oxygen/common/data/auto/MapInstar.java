package com.oraen.oxygen.common.data.auto;//package com.oraen.oxygen.common.data.auto;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MapInstar implements Instar {
//
//    private Map<String, Object> map = new HashMap<>();
//
//    private void push(Object value){
//        clear();
//        map.put("value", value);
//    }
//
//    @Override
//    public void from(double value) {
//        push(value);
//    }
//
//    @Override
//    public void from(String value) {
//        push(value);
//    }
//
//    @Override
//    public void from(Map<?, ?> value) {
//        clear();
//        for(Map.Entry<?, ?> entry : value.entrySet()){
//            map.put(entry.getKey().toString(), entry.getValue());
//        }
//
//    }
//
//    @Override
//    public void from(Collection<?> value) {
//        push(value);
//    }
//
//    @Override
//    public void fromEntity(Object value) {
//        //push(value);
//    }
//
//    @Override
//    public void clear() {
//        this.map.clear();
//    }
//
//    @Override
//    public double getNum() {
//        try{
//            return Double.parseDouble(map.get("value").toString());
//        }catch (Exception e){
//            throw new AutoTransitionException(map.get("value"), double.class);
//        }
//    }
//
//    @Override
//    public int getInt() {
//        try{
//            return Double.valueOf(map.get("value").toString()).intValue();
//        }catch (Exception e){
//            throw new AutoTransitionException(map.get("name"), int.class);
//        }
//    }
//
//    @Override
//    public String getString() {
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> getMap() {
//        return null;
//    }
//
//    @Override
//    public <T> List<T> getList(Class<T> clazz) {
//        return null;
//    }
//
//    @Override
//    public <T> T getEntity(Class<T> clazz) {
//        return null;
//    }
//}
