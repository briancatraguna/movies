package com.dicoding.movieapp.searchresult

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.movieapp.R

class SearchSectionsPagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var bundle: Bundle? = null

    fun setBundle(bundle: Bundle){
        this.bundle = bundle
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_shows)
    }


    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> {
                val movieFragment = SearchMoviesFragment()
                movieFragment.arguments = this.bundle
                return movieFragment
            }
            1 -> {
                val showFragment = SearchTvShowFragment()
                showFragment.arguments = this.bundle
                return showFragment
            }
            else -> {
                return Fragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }
}