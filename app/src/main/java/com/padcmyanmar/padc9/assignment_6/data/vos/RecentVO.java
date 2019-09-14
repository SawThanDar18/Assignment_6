package com.padcmyanmar.padc9.assignment_6.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "recent")
public class RecentVO {

    @PrimaryKey
    @NotNull
    private String name;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }
}
