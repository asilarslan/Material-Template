package tr.asil.arayuz.fragment;


import tr.asil.arayuz.R;
import tr.asil.arayuz.R.id;
import tr.asil.arayuz.R.layout;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class ListFragment extends Fragment {

	private static final String ARG_POSITION = "position";
	private static final Integer LIST_ITEM = 0;
	
	public static final int[] COLOR = { 0xFF666666, 0xFF96AA39,
		0xFFC74B46, 0xFFF4842D, 0xFF3F9FE0, 0xFF5161BC };
	public static final String[] LIST = { "ÝÞ BANKASI", "BLOG DATABASE ÞÝFRESÝ",
        "PORTAL DATABASE ÞÝFRESÝ", "GMAIL ÞÝFREM", "SAHÝBÝNDENCOM ÞÝFREM", "MODEM ÞÝFREM" };

	private int position;

	public static ListFragment newInstance(int position) {
		ListFragment f = new ListFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_list, container, false);
		/*LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

		FrameLayout fl = new FrameLayout(getActivity());
		fl.setLayoutParams(params);

		final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
				.getDisplayMetrics());

		TextView v = new TextView(getActivity());
		params.setMargins(margin, margin, margin, margin);
		v.setLayoutParams(params);
		v.setLayoutParams(params);
		v.setGravity(Gravity.CENTER);
		v.setBackgroundResource(R.drawable.background_card);
		v.setText("CARD " + (position + 1));

		fl.addView(v);*/
		ListView lv = (ListView)v.findViewById(R.id.listView1);
        lv.setAdapter(new MyListAdapter(getActivity()));
		
		return v;
	}
	
	
	private class MyListAdapter extends BaseAdapter {
        public MyListAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return LIST.length;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

           
            

            View item = convertView;
            if(convertView == null ) {
                item = LayoutInflater.from(mContext).inflate(
                        R.layout.items, parent, false);
                item.setTag(LIST_ITEM);
            }

            TextView header = (TextView)item.findViewById(R.id.name);
            header.setText(LIST[position % LIST.length]);
            
            ImageView iv = (ImageView) item.findViewById(R.id.color);
            iv.setBackgroundColor(COLOR[position % COLOR.length]);


            


            return item;
        }

       

        private final Context mContext;
    }

}