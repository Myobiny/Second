package ko.co.second;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.HashMap;
import java.util.Map;

import ko.co.second.databinding.ActivityPagerBinding;

public class PagerActivity extends AppCompatActivity {

    ActivityPagerBinding binding;
    PagerAdapter mAdapter;

    Map<Integer, Fragment> mPageReferenceMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAdapter = new PagerAdapter(getSupportFragmentManager());
        binding.pager.setAdapter(mAdapter);
        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                setLayoutTab(position);
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        binding.rlayoutTabFirst.setOnClickListener(v->{
            binding.pager.setCurrentItem(0);
        });
        binding.rlayoutTabSecond.setOnClickListener(v->{
            binding.pager.setCurrentItem(1);
        });
        binding.rlayoutTabThird.setOnClickListener(v->{
            binding.pager.setCurrentItem(2);
        });

    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment result = null;

            if (position == 0) {
                result = MapFragment.newInstance();
            } else if (position == 1) {
                result = HomeFragment.newInstance();
            } else if (position == 2) {
                result = MyInfoFragment.newInstance();
            }

            mPageReferenceMap.put(position, result);

            return result;
        }

        @Override
        public int getCount() {
            return 3;
        }

    }

    private void setLayoutTab(int position) {
        binding.rlayoutTabFirst.setSelected(position == 0);
        binding.rlayoutTabSecond.setSelected(position == 1);
        binding.rlayoutTabThird.setSelected(position == 2);
    }

}
