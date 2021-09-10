package com.oraen.oxygen.common.data.display;

public interface Judge<T> {

    <TS extends T>boolean isLegal(TS ts);
}
