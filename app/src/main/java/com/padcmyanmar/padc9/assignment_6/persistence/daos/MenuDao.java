package com.padcmyanmar.padc9.assignment_6.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.assignment_6.data.vos.MenuVO;

import java.util.List;

@Dao
public interface MenuDao {

    @Query("SELECT * FROM menu")
    List<MenuVO> getAllMenus();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMenus(List<MenuVO> menuVOS);
}
