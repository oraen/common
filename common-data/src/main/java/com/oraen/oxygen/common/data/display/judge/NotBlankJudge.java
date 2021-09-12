package com.oraen.oxygen.common.data.display.judge;

import com.oraen.oxygen.common.data.display.Judge;

//未完成
public class NotBlankJudge implements Judge<String> {
    @Override
    @Deprecated
    public <TS extends String> boolean isLegal(TS ts) {
        return false;
    }
}
