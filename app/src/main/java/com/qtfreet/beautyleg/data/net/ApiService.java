package com.qtfreet.beautyleg.data.net;

import com.qtfreet.beautyleg.data.bean.DetailImageBean;
import com.qtfreet.beautyleg.data.bean.blBean;
import com.qtfreet.beautyleg.data.bean.videoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by qtfreet on 2016/3/30.
 */
public interface ApiService {

    @GET("data/cover.jsp")
    Call<List<blBean>> TU(@Query("gid") String git, @Query("type") String type, @Query("cs") String cs, @Query("ps") String ps, @Query("utoken") String utoken,@Query("t") String t, @Query("p") int page,@Query("cs") String cs2);
    @GET("data/detail.jsp")
    Call<List<DetailImageBean>> Detail(@Query("ps") int ps, @Query("t") long t, @Query("hd") int hd, @Query("cs") String cs, @Query("id") int id,@Query("utoken") String token);
    @GET("data/albumDetail.jsp")
    Call<videoBean> Video(@Query("id") int id,@Query("hd") String hd,@Query("cs") String cs,@Query("t") long time,@Query("uc") String uc,@Query("pn") String pn,@Query("av") String av,@Query("mac") String mac,@Query("sessionid") String sessionid,@Query("utoken") String utoken,@Query("kd") boolean kd);
}
