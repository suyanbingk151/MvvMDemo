package com.mvvm.gionee.mvvmdemo.viewmodle;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import com.mvvm.gionee.mvvmdemo.R;
import com.mvvm.gionee.mvvmdemo.data.GirlsData;
import com.mvvm.gionee.mvvmdemo.modle.GirlsModle;
import com.mvvm.gionee.mvvmdemo.modle.Impl.GirlsModleImpl;
import com.mvvm.gionee.mvvmdemo.view.XRecyclerViewBaseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by gionee on 2018/1/17.
 */

public class GirlsViewModel extends AndroidViewModel {

    private static final MutableLiveData ABSENT = new MutableLiveData();

    {
        ABSENT.setValue(null);
    }

    private Application application;
    private GirlsModle girlsModle;
    private List<GirlsData.ResultsBean> mainGirlsData = new ArrayList<>();
    private XRecyclerViewBaseView baseView;
    private MutableLiveData<GirlsData> applyData = new MutableLiveData<>();

    public ObservableField<GirlsData> uiObservableData = new ObservableField<>();

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    public GirlsViewModel(Application application, XRecyclerViewBaseView baseView) {
        super(application);
        this.application = application;
        this.baseView = baseView;
        girlsModle = new GirlsModleImpl();
    }

    public void loadGirlListData(final int page, final int pageSize) {
        Map<String, String> map = new HashMap<>();
        map.put("pn", page + "");
        map.put("rn", pageSize + "");
        map.put("tag1", application.getString(R.string.tag1));
        map.put("tag2", application.getString(R.string.tag2));
        map.put("ie", "utf8");
        girlsModle.getGirlsListData(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GirlsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        baseView.loadComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseView.loadComplete();
                    }

                    @Override
                    public void onNext(GirlsData girlsData) {
                        girlsData.getData().remove(girlsData.getData().size() - 1);
                        mainGirlsData.addAll(girlsData.getData());
                        girlsData.setData(mainGirlsData);
                        applyData.setValue(girlsData);

                    }
                });
    }

    public void clearListData() {
        mainGirlsData.clear();
    }


    public LiveData<GirlsData> getLiveObservableData() {
        return applyData;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.clear();
    }
}
