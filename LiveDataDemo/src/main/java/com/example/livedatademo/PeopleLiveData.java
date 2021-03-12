package com.example.livedatademo;

import androidx.lifecycle.LiveData;

/**
 * @CreateDate: 2021-3-10 8:50
 * @UpdateDate: 2021-3-10 8:50
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class PeopleLiveData extends LiveData<PeopleBean> {
    private PeopleBean peopleBean;

    public PeopleLiveData(PeopleBean peopleBean) {
        this.peopleBean = peopleBean;
    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

}
