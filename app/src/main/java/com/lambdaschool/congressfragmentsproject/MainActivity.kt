package com.lambdaschool.congressfragmentsproject

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.congressfragmentsproject.api.CongressDao
import com.lambdaschool.congressfragmentsproject.api.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview
import java.util.ArrayList

//step 1. grok starter code
//step 2. create list fragment
//step 3. attach list fragment to main activity
//step 4. add second fragment for tables
//step 5. add second activity for phones

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get an overview list for all members of congress
        val allMembers: ArrayList<CongresspersonOverview> = CongressDao.allMembers

        // get details for a single member of congress
        val singleMemberDetails: CongresspersonDetails? = allMembers[0].id?.let { CongressDao.getMemberDetails(it) }

        // get congressperson portrait
        val image: Bitmap? = allMembers[0].id?.let { CongressDao.getImage(it) }
    }
}
