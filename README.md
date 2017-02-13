# DotIndicator
Dots Indicator for ViewPager
# Screenshot
![alt tag](https://github.com/hangga/DotIndicator/blob/master/device-2017-02-13-115125.png)

# how to use
```
<com.sebangga.sebangga.customview.DotIndicator
        android:id="@+id/viewIncicator"
        android:layout_above="@+id/wadahbottom"
        android:layout_width="match_parent"
        android:layout_height="55dp"
        android:layout_centerHorizontal="true"
        android:gravity="center"
        android:orientation="horizontal"
        android:paddingTop="10dp"
        android:layout_marginBottom="0dp"/>
        ```
 # In Java
 ```
 viewIncicator = (DotIndicator) findViewById(R.id.viewIncicator);
 mViewPager.setAdapter(mSectionsPagerAdapter);
 viewIncicator.setViewPager(mViewPager);
        ```
