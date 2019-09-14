package com.padcmyanmar.padc9.assignment_6.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.assignment_6.data.vos.RecentVO;

import java.util.List;

@Dao
public interface RecentDao {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long addRecentWord(RecentVO recentVO);

    @Query("SELECT * FROM recent")
    public abstract List<RecentVO> getAllRecentWords();*/
}
