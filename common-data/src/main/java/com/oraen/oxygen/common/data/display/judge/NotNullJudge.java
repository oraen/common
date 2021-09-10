package com.oraen.oxygen.common.data.display.judge;

import com.oraen.oxygen.common.data.display.Judge;

public class NotNullJudge implements Judge<Object> {
    @Override
    public <TS> boolean isLegal(TS ts) {
        return ts != null;
    }
}
