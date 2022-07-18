package com.example.toastandsnackbar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.toastandsnackbar.databinding.ActivityMainBinding
import com.golovin.fluentstackbar.FluentSnackbar
import com.google.android.material.snackbar.Snackbar
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSnackbar.setOnClickListener {
//            val snackbar = Snackbar.make(binding.root, "Berhasil Muncul", Snackbar.LENGTH_INDEFINITE)
//            snackbar.setAction("Retry"){
//                Snackbar.make(binding.root, "Retry di pencet",Snackbar.LENGTH_SHORT)
//                    .show()
//            }.show()
            val mFluentSnackbar =
                FluentSnackbar.create(this) // you can also use any View instead of Activity


            mFluentSnackbar.create("INI SNACKBAR")
                .maxLines(2) // default is 1 line
                .backgroundColorRes(R.color.purple_500) // default is #323232
                .textColorRes(R.color.white) // default is Color.WHITE
                .duration(Snackbar.LENGTH_SHORT) // default is Snackbar.LENGTH_LONG
                .actionText("cancel") // default is "Action"
                .actionTextColorRes(R.color.purple_200)
                .important()
                .action(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        Toast.makeText(this@MainActivity, "Action clicked", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
                .show()
        }

        binding.btnToast.setOnClickListener {
//            Toast.makeText(this, "Toast Dipencet", Toast.LENGTH_SHORT).show()
            MotionToast.createToast(this,
                "BERHASIL",
                "Upload Completed successfully!",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular))
        }

    }
}