package com.o7services.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.o7services.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var layout = arrayListOf(R.layout.layout_page_one, R.layout.layout_page_two, R.layout.layout_page_three, R.layout.layout_page_four,
        R.layout.layout_page_five)
    var adapter = ViewPageRecycler(layout)
    var dotsRecycler = DotsRecycler(layout.size)
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvRecycler.adapter = dotsRecycler

        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
//                    binding.llMain.set
                    dotsRecycler.updatePosition(position)
                    if (position==0){
                        binding.tvSkip.visibility = View.INVISIBLE
                        binding.ivArrow.visibility = View.INVISIBLE
                        binding.tvDone.visibility = View.INVISIBLE
//                        binding.iv0.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.red))

                    }else if (position==1){
                        binding.tvSkip.visibility = View.VISIBLE
                        binding.ivArrow.visibility = View.VISIBLE
                        binding.tvDone.visibility = View.INVISIBLE
//                        binding.iv1.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.blue))

                    }else if (position==2){
                        binding.tvSkip.visibility = View.VISIBLE
                        binding.ivArrow.visibility = View.VISIBLE
                        binding.tvDone.visibility = View.INVISIBLE
//                        binding.iv2.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.green))

                    }else if (position==3){
                        binding.tvSkip.visibility = View.VISIBLE
                        binding.ivArrow.visibility = View.VISIBLE
                        binding.tvDone.visibility = View.INVISIBLE
//                        binding.iv3.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.yellow))

                    }else{
                        binding.tvSkip.visibility = View.INVISIBLE
                        binding.ivArrow.visibility = View.INVISIBLE
                        binding.tvDone.visibility = View.VISIBLE
//                        binding.iv4.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.purple))

                    }
                    Log.e(TAG, "position $position")

                }

            }
        )
        binding.ivArrow.setOnClickListener {
            val currentPosition = binding.viewPager.currentItem
            if (currentPosition < layout.size - 1) {
                binding.viewPager.currentItem = currentPosition + 1
            }
        }
        binding.tvSkip.setOnClickListener {
            val lastPosition = layout.size - 1
            binding.viewPager.currentItem = lastPosition
        }
    }
}