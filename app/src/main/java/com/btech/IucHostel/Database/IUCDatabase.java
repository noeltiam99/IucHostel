package com.btech.IucHostel.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.btech.IucHostel.Database.Daos.HostelDao;
import com.btech.IucHostel.Database.Daos.HostelIndexDao;
import com.btech.IucHostel.Database.Daos.HostelsDao;
import com.btech.IucHostel.Database.Daos.InmatesDao;
import com.btech.IucHostel.Database.Daos.InvoicesDao;
import com.btech.IucHostel.Database.Daos.LocalUserDao;
import com.btech.IucHostel.Database.Daos.RoomsDao;
import com.btech.IucHostel.Database.Daos.StudentDao;
import com.btech.IucHostel.Database.Daos.SystemUsersDao;
import com.btech.IucHostel.Database.Entities.Hostel;
import com.btech.IucHostel.Database.Entities.HostelIndex;
import com.btech.IucHostel.Database.Entities.Hostels;
import com.btech.IucHostel.Database.Entities.Inmates;
import com.btech.IucHostel.Database.Entities.Invoices;
import com.btech.IucHostel.Database.Entities.Localuser;
import com.btech.IucHostel.Database.Entities.Rooms;
import com.btech.IucHostel.Database.Entities.Student;
import com.btech.IucHostel.Database.Entities.SystemUsers;

@Database(entities = {Hostel.class, Hostels.class, HostelIndex.class, Inmates.class, Invoices.class, Rooms.class, Student.class, SystemUsers.class, Localuser.class}, version = 3)
public abstract class IUCDatabase extends RoomDatabase {
    private static IUCDatabase INSTANCE = null;

    public static IUCDatabase getInstance(@NonNull Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, IUCDatabase.class, "IUC.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract HostelDao hostelDao();
    public abstract HostelIndexDao hostelIndexDao();
    public abstract HostelsDao hostelsDao();
    public abstract InmatesDao inmatesDao();
    public abstract InvoicesDao invoicesDao();
    public abstract RoomsDao roomsDao();
    public abstract StudentDao studentDao();
    public abstract SystemUsersDao systemUsersDao();
    public abstract LocalUserDao localUserDao();
}
