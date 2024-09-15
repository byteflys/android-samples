package io.github.hellogoogle2000.android.samples

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import io.github.hellogoogle2000.android.commons.constant.Global
import io.github.hellogoogle2000.android.commons.context.ActivityEx.setFullScreenStyle
import io.github.hellogoogle2000.android.samples.viewlocator.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreenStyle()
        super.onCreate(savedInstanceState)
        Global.application = application
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onResume() {
        super.onResume()
        if (!Environment.isExternalStorageManager()) {
            val uri = Uri.parse("package:$packageName")
            val intent = Intent()
            intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
            intent.data = uri
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } else {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}