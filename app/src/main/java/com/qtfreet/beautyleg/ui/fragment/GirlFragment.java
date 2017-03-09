package com.qtfreet.beautyleg.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.data.Constants;
import com.qtfreet.beautyleg.data.bean.DetailImageBean;
import com.qtfreet.beautyleg.data.bean.ImageUrlList;
import com.qtfreet.beautyleg.data.bean.blBean;
import com.qtfreet.beautyleg.data.bean.imageBean;
import com.qtfreet.beautyleg.data.bean.videoBean;
import com.qtfreet.beautyleg.data.net.Api;
import com.qtfreet.beautyleg.data.net.ApiService;
import com.qtfreet.beautyleg.ui.activity.GirlDetailActivity;
import com.qtfreet.beautyleg.ui.activity.VideoActivity;
import com.qtfreet.beautyleg.ui.adapter.GirlsAdapter;
import com.qtfreet.beautyleg.ui.adapter.OnMeiziClickListener;
import com.qtfreet.beautyleg.ui.service.DownloadService;
import com.qtfreet.beautyleg.utils.Utils;
import com.qtfreet.beautyleg.wiget.ActionSheetDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GirlFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnMeiziClickListener {


    private List<imageBean> imageInfo;
    private boolean isLoadMore = false;
    private int hasLoadPage = 0;
    private GirlsAdapter mAdapter;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.getData().getInt(Constants.STATE)) {
                case Constants.REQUEST_FAIL:
                    showRefreshing(false);
                    Toast.makeText(getActivity(), "未获取到数据，请重新尝试", Toast.LENGTH_SHORT).show();
                    isLoadMore = false;
                    break;
                case Constants.GET_URL_SUCCESS:
                    showRefreshing(false);
                    mAdapter.notifyDataSetChanged();
                    hasLoadPage++;
                    isLoadMore = false;
                    break;
                case Constants.GET_URL_READY:
                    startActivity(new Intent(getActivity(), GirlDetailActivity.class));
                    break;
                case Constants.GET_DOWNLOAD_URL_SUCC:
                    Intent t = new Intent(getActivity(), DownloadService.class);
                    t.putExtra(DownloadService.TYPE, 0);
                    t.putExtra(DownloadService.NAME, msg.getData().getString(Constants.NAME));
                    getActivity().startService(t);
                    break;
                case Constants.GET_VIDEO_URL_SUCC:
                    Intent i = new Intent(getActivity(), VideoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(VideoActivity.VideoActivity, msg.getData().getString(Constants.DATA));
                    i.putExtras(bundle);
                    startActivity(i);
                    break;
                case Constants.GET_DOWNLOAD_VIDEO_URL_SUCC:
                    Intent k = new Intent(getActivity(), DownloadService.class);
                    k.putExtra(DownloadService.TYPE, 1);
                    k.putExtra(DownloadService.NAME, msg.getData().getString(Constants.NAME));
                    k.putExtra(DownloadService.URL, msg.getData().getString(Constants.URL));
                    getActivity().startService(k);
                    break;

            }
        }
    };
    private String gid;

    public static GirlFragment newFragment(int flag) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.TYPE, flag);
        GirlFragment testFragment = new GirlFragment();
        testFragment.setArguments(bundle);
        return testFragment;
    }


    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageInfo = new ArrayList<>();
        int type = getArguments().getInt(Constants.TYPE, Constants.AISS);
        gid = Utils.getType(type);
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    Constants.WRITE_EX);
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == Constants.WRITE_EX) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(getActivity(), "未赋予权限，将不可使用下载功能", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @BindView(R.id.swipe_refresh)

    SwipeRefreshLayout refresh;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_layout, container, false);
        ButterKnife.bind(this, view);
        refresh.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R
                .color.holo_orange_light, android.R.color.holo_green_light);
        refresh.setOnRefreshListener(this);
        showRefreshing(true);
        return view;
    }

    private boolean RequestFail(Response response) {
        if (!response.isSuccessful()) {
            return true;
        }
        if (response.body() == null) {
            //error
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.STATE, Constants.REQUEST_FAIL);
            sendMessage(bundle);
            return true;
        }
        return false;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mAdapter = new GirlsAdapter(getActivity(), imageInfo);
        mAdapter.setOnMeiziClickListener(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    int[] positions = new int[mStaggeredGridLayoutManager.getSpanCount()];
                    positions = mStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(positions);
                    for (int position : positions) {
                        if (position == mStaggeredGridLayoutManager.getItemCount() - 1) {
                            loadMore();
                            break;
                        }
                    }
                }


            }
        });

        requestData(0);
    }

    private void loadMore() {
        if (!isLoadMore) {
            isLoadMore = true;
            requestData(hasLoadPage + 1);
        }
    }


    private void showRefreshing(boolean isShow) {
        if (isShow) {
            refresh.setProgressViewOffset(false, 0, (int) (getActivity().getResources().getDisplayMetrics().density * 24 +
                    0.5f));
            refresh.setRefreshing(true);
        } else {
            refresh.setRefreshing(false);
        }
    }

    private ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.XIUREN).client(Utils.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }


    public void requestData(int page) {
        showRefreshing(true);
        long time = System.currentTimeMillis();
        Call<List<blBean>> call = getApiService().TU(gid, "-1", "testviewoo", "30", String.valueOf(time) + String.valueOf(time), "1464360635524", page, "23f21003665979d02cc1df4a0f009b32");
        call.enqueue(new Callback<List<blBean>>() {
            @Override
            public void onResponse(Call<List<blBean>> call, Response<List<blBean>> response) {
                if (RequestFail(response)) {
                    return;
                } else {
                    int size = response.body().size();
                    if (size == 0) {
                        Toast.makeText(getActivity(), "未获取到数据，请重新尝试", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    imageBean imageBean;
                    for (int i = 0; i < size; i++) {
                        imageBean = new imageBean();
                        imageBean.setUrl(response.body().get(i).getThumbpicurl());
                        imageBean.setAlbumname(response.body().get(i).getAlbumname());
                        imageBean.setId(response.body().get(i).getId());
                        imageBean.setType(response.body().get(i).getType());
                        imageBean.setDes(response.body().get(i).getAlbumname());
                        imageInfo.add(imageBean);
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.STATE, Constants.GET_URL_SUCCESS);
                sendMessage(bundle);
            }

            @Override
            public void onFailure(Call<List<blBean>> call, Throwable t) {

            }
        });


    }

    @Override
    public void onRefresh() {
        showRefreshing(false);
    }

    private String EncryptSign(long time, int id, String data) {

        String t = Utils.MD5(Utils.MD5(Api.SIGN + "52340") + time + id + data);
        return t;

    }

    private void requsetDetailReponse(final int level, int id) {
        long time = System.currentTimeMillis();
        String t = level == 3 ? "301000" : "101000";
        Call<List<DetailImageBean>> c = getApiService().Detail(1000, time, level, EncryptSign(time, id, t), id, String.valueOf(time) + String.valueOf(time));
        c.enqueue(new Callback<List<DetailImageBean>>() {
            @Override
            public void onResponse(Call<List<DetailImageBean>> call, Response<List<DetailImageBean>> response) {
                if (RequestFail(response)) {
                    return;
                }
                List<DetailImageBean> image = response.body();
                int size = image.size();
                if (size == 0) {
                    Toast.makeText(getActivity(), "未获取到数据，请重新尝试", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (level == 3) {
                    ImageUrlList.bigurl = new ArrayList<>();
                    ImageUrlList.bigurl.clear();
                    for (int i = 0; i < size; i++) {
                        ImageUrlList.bigurl.add(image.get(i).getThumbpicurl());
                    }
                } else if (level == 1) {
                    ImageUrlList.url = new ArrayList<>();
                    ImageUrlList.url.clear();
                    for (int i = 0; i < size; i++) {
                        ImageUrlList.url.add(image.get(i).getThumbpicurl());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(Constants.STATE, Constants.GET_URL_READY);
                    sendMessage(bundle);
                }

            }

            @Override
            public void onFailure(Call<List<DetailImageBean>> call, Throwable t) {

            }
        });

    }

    private void requestDetail(int id) throws Exception {
        requsetDetailReponse(3, id);
        requsetDetailReponse(1, id);
    }

    @Override
    public void onMeiziClick(View itemView, int position) {
        int id = imageInfo.get(position).getId();
        int type = imageInfo.get(position).getType();
        if (type == 0) {
            try {
                requestDetail(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type == 1) {
            try {
                requestVideoUrl(id, Constants.GET_VIDEO_URL_SUCC);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void requestVideoUrl(int id, final int task) throws Exception {
        Call<videoBean> c = getApiService().Video(id, "1", EncryptSign(time, id, ""), time, "Release", "com.mason.beautyleg", "80", "08:00:27:04:69:94", "[sessionid]", Api.TOKEN, false);
        c.enqueue(new Callback<videoBean>() {
            @Override
            public void onResponse(Call<videoBean> call, Response<videoBean> response) {
                if (RequestFail(response) || response.body().getVideoList() == null) {
                    return;
                }
                List<videoBean.VideoListBean> videoList = response.body().getVideoList();
                int videoListSize = videoList.size();
                String url = "";
                if (videoListSize == 3) {
                    url = videoList.get(videoListSize - 2).getVideoUrl();
                } else if (videoListSize == 2) {
                    url = videoList.get(videoListSize - 1).getVideoUrl();
                }
                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(getActivity(), "未获取到视频地址", Toast.LENGTH_SHORT).show();
                    return;
                }
                Bundle bundle = new Bundle();
                switch (task) {
                    case Constants.GET_VIDEO_URL_SUCC:
                        bundle.putInt(Constants.STATE, Constants.GET_VIDEO_URL_SUCC);
                        bundle.putString(Constants.DATA, url);
                        break;
                    case Constants.GET_DOWNLOAD_VIDEO_URL_SUCC:
                        bundle.putInt(Constants.STATE, Constants.GET_DOWNLOAD_VIDEO_URL_SUCC);
                        bundle.putString(Constants.URL, response.body().getVideoList().get(response.body().getVideoList().size() - 1).getVideoUrl());
                        bundle.putString(Constants.NAME, response.body().getAlbumname());
                        break;
                }

                sendMessage(bundle);
            }

            @Override
            public void onFailure(Call<videoBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onMeiziLongClick(View itemView, final int position) {
        if (imageInfo.get(position).getType() != 1) {
            new ActionSheetDialog(getActivity()).builder().setTitle("提示").addSheetItem("点击下载", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    try {
                        requestDownload(imageInfo.get(position).getId(), position);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).show();
        } else {
            new ActionSheetDialog(getActivity()).builder().setTitle("提示").addSheetItem("点击下载", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                @Override
                public void onClick(int which) {
                    try {
                        requestVideoUrl(imageInfo.get(position).getId(), Constants.GET_DOWNLOAD_VIDEO_URL_SUCC);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).show();
        }

    }


    private void sendMessage(Bundle bundle) {
        Message msg = Message.obtain();
        msg.setData(bundle);
        handler.sendMessage(msg);
    }


    private Long time = System.currentTimeMillis();

    private void requestDownload(int id, final int postion) throws Exception {
        long time = System.currentTimeMillis();
        Call<List<DetailImageBean>> c = getApiService().Detail(1000, time, 3, EncryptSign(time, id, "301000"), id, String.valueOf(time) + String.valueOf(time));
        c.enqueue(new Callback<List<DetailImageBean>>() {
            @Override
            public void onResponse(Call<List<DetailImageBean>> call, Response<List<DetailImageBean>> response) {
                if (RequestFail(response)) {
                    return;
                }
                List<DetailImageBean> image = response.body();
                ImageUrlList.bigurl = new ArrayList<>();
                ImageUrlList.bigurl.clear();
                int size = image.size();
                if (size == 0) {
                    Toast.makeText(getActivity(), "未获取到数据，请重新尝试", Toast.LENGTH_SHORT).show();
                    return;
                }
                for (int i = 0; i < size; i++) {
                    ImageUrlList.bigurl.add(image.get(i).getThumbpicurl());
                }
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.STATE, Constants.GET_DOWNLOAD_URL_SUCC);
                bundle.putString(Constants.NAME, imageInfo.get(postion).getAlbumname());
                sendMessage(bundle);
            }

            @Override
            public void onFailure(Call<List<DetailImageBean>> call, Throwable t) {

            }
        });
    }
}
