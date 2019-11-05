package com.a_hamoud.listview_sqlserver

import android.annotation.SuppressLint
import android.os.StrictMode
import android.util.Log
import java.lang.Exception

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Created by Alaeddin on 5/21/2017.
 */

class ConnectionHelper {

    lateinit var ip: String
    lateinit var db: String
    lateinit var DBUserNameStr: String
    lateinit var DBPasswordStr: String


    @SuppressLint("NewApi")
    fun connectionclasss(): Connection? {

        // Declaring Server ip, username, database name and password
        ip = "Your Server IP or Domain"
        db = "Database Name"
        DBUserNameStr = "Database UserName"
        DBPasswordStr = "Database Password"
        // Declaring Server ip, username, database name and password


        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var connection: java.sql.Connection? = null
        var ConnectionURL: String? = null
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            ConnectionURL = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$DBUserNameStr;password=$DBPasswordStr;"
            connection = DriverManager.getConnection(ConnectionURL)
        } catch (se: SQLException) {
            Log.e("error here 1 : ", se.message)
        } catch (e: ClassNotFoundException) {
            Log.e("error here 2 : ", e.message)
        } catch (e: Exception) {
            Log.e("error here 3 : ", e.message)
        }

        return connection
    }
}
