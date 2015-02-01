package tr.asil.arayuz;


import tr.asil.arayuz.fragment.AddFragment;
import tr.asil.arayuz.fragment.CategoriesFragment;
import tr.asil.arayuz.fragment.ListFragment;
import tr.asil.arayuz.fragment.SearchFragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity {

	private final Handler handler = new Handler();

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;

	private Drawable oldBackground = null;
	private int currentColor = 0xFF3F9FE0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		


		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
				.getDisplayMetrics());
			pager.setPageMargin(pageMargin);
			tabs.setViewPager(pager);
		
		

		

		//changeColor(currentColor);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	

	public void onColorClicked(View v) {
		//renk seçimi
		

	}

	

	

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "ADD", "CATEGORIES", "LIST", "SEARCH"};

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			if(position==0){
				return AddFragment.newInstance(position);
			}
			else if(position==1){
				return CategoriesFragment.newInstance(position);
			}
			else if(position==2){
				return ListFragment.newInstance(position);
			}
			else{
				return SearchFragment.newInstance(position);
			}
			
		}

	}

}