package com.oatrice.internet_speed_testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.internet_speed_testing.InternetSpeedBuilder
import com.example.internet_speed_testing.InternetSpeedBuilder.*
import com.example.internet_speed_testing.ProgressionModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Ajay Deepak on 30-10-2019, 21:04
 */

class MainActivity : AppCompatActivity(){

    private lateinit var rlayoutManager: RecyclerView.LayoutManager

    private val progressionList: ArrayList<ProgressionModel> = ArrayList()
    private var progressionAdapter =  ProgressionAdapter(progressionList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerview?.apply {
            adapter = progressionAdapter
            rlayoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = rlayoutManager
        }

        val builder = InternetSpeedBuilder(this)
        builder.setOnEventInternetSpeedListener(object : OnEventInternetSpeedListener {
            override fun onDownloadProgress(count: Int, progressModel: ProgressionModel) {

            }

            override fun onUploadProgress(count: Int, progressModel: ProgressionModel) {

            }

            override fun onTotalProgress(count: Int, progressModel: ProgressionModel) {
                progressionAdapter.setDataList(count, progressModel)

            }
        })
        builder.start("http://2.testdebit.info/fichiers/1Mo.dat", 20)
    }
}