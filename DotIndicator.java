package id.web.hangga.customview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by hangga on 13/02/17.
 */

public class DotIndicator extends LinearLayout {

    private int pageCount = 0;
    private ImageView[] dots;
    private Context mContext;
    private String DefaultColor = "#f442ee";
    private String selectedColor = DefaultColor;
    private String unSelectedColor = DefaultColor;

    /**
     * Jika Anda menginginkan warna kustom untuk setiap dot[] nya.
     * @param viewPager
     * @param selectedColor Warna untuk selected Page
     * @param unSelectedColor Warna untuk un_selected Page
     */
    public void setViewPager(ViewPager viewPager, String selectedColor, String unSelectedColor) {
        this.viewPager = viewPager;
        this.selectedColor = selectedColor;
        this.unSelectedColor = unSelectedColor;
        pageCount = viewPager.getAdapter().getCount();
        init();
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        pageCount = viewPager.getAdapter().getCount();
        init();
    }

    private ViewPager viewPager;

    private ShapeDrawable selectedDrawable;

    private ShapeDrawable unSelectedDrawable;

    public DotIndicator(Context context) {
        super(context);
        this.mContext = context;
    }

    public DotIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public DotIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    private void initCircle(){
        selectedDrawable = new ShapeDrawable( new OvalShape());
        selectedDrawable.setIntrinsicHeight(20);
        selectedDrawable.setIntrinsicWidth(20);
        selectedDrawable.setBounds(new Rect(0, 0, 60, 60));
        selectedDrawable.getPaint().setColor(Color.parseColor(selectedColor));

        unSelectedDrawable = new ShapeDrawable( new OvalShape());
        unSelectedDrawable.setIntrinsicHeight(10);
        unSelectedDrawable.setIntrinsicWidth(10);
        unSelectedDrawable.setBounds(new Rect(0, 0, 10, 10));
        unSelectedDrawable.getPaint().setColor(Color.parseColor(unSelectedColor));
        unSelectedDrawable.setPadding(50,50,50,50);
    }

    private void init(){
        this.setGravity(Gravity.CENTER);
        this.setOrientation(LinearLayout.HORIZONTAL);
        if (!isInEditMode() && viewPager != null){

            initCircle();

            dots = new ImageView[pageCount];

            for (int i = 0; i < pageCount; i++) {
                dots[i] = new ImageView(mContext);
                dots[i].setImageDrawable(unSelectedDrawable);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                params.setMargins(4, 0, 4, 0);
                this.addView(dots[i], params);
            }
            dots[0].setImageDrawable(selectedDrawable);

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < pageCount; i++) {
                        dots[i].setImageDrawable(unSelectedDrawable);
                    }
                    dots[position].setImageDrawable(selectedDrawable);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }
}

