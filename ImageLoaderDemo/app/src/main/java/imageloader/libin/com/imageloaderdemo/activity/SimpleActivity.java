package imageloader.libin.com.imageloaderdemo.activity;

import android.animation.ObjectAnimator;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.maowo.mylibrary.images.config.PriorityMode;
import com.maowo.mylibrary.images.config.ScaleMode;
import com.maowo.mylibrary.images.imagei.ImageDownLoadCallBack;
import com.maowo.mylibrary.images.loader.ImageLoader;
import com.maowo.mylibrary.images.utils.DownLoadImageService;

import java.io.File;

import imageloader.libin.com.imageloaderdemo.GlideApp;
import imageloader.libin.com.imageloaderdemo.R;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;

import static com.maowo.mylibrary.images.config.Contants.ANDROID_RESOURCE;
import static com.maowo.mylibrary.images.config.Contants.ASSERTS_PATH;
import static com.maowo.mylibrary.images.config.Contants.FOREWARD_SLASH;
import static com.maowo.mylibrary.images.config.Contants.RAW;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.IMG_NAME;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.IMG_NAME_C;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.URL1;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.URL2;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.URL3;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.URL4;
import static imageloader.libin.com.imageloaderdemo.config.imageconfig.URL5;


public class SimpleActivity extends AppCompatActivity {

    private ImageView iv_test1;
    private ImageView iv_test2;
    private ImageView iv_test3;
    private ImageView iv_test4;
    private ImageView iv_test5;
    private ImageView iv_test6;
    private ImageView iv_test7;
    private ImageView iv_test8;
    private ImageView iv_test9;
    private ImageView iv_test10;
    private ImageView iv_test11;
    private ImageView iv_test12;
    private ImageView iv_test13;
    private ImageView iv_test14;
    private ImageView iv_test15;

    private static final String TAG = SimpleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        findview();

        load();
    }

    private void findview() {
        iv_test1 = (ImageView) findViewById(R.id.iv_test1);
        iv_test2 = (ImageView) findViewById(R.id.iv_test2);
        iv_test3 = (ImageView) findViewById(R.id.iv_test3);
        iv_test4 = (ImageView) findViewById(R.id.iv_test4);
        iv_test5 = (ImageView) findViewById(R.id.iv_test5);
        iv_test6 = (ImageView) findViewById(R.id.iv_test6);
        iv_test7 = (ImageView) findViewById(R.id.iv_test7);
        iv_test8 = (ImageView) findViewById(R.id.iv_test8);
        iv_test9 = (ImageView) findViewById(R.id.iv_test9);
        iv_test10 = (ImageView) findViewById(R.id.iv_test10);
        iv_test11 = (ImageView) findViewById(R.id.iv_test11);
        iv_test12 = (ImageView) findViewById(R.id.iv_test12);
        iv_test13 = (ImageView) findViewById(R.id.iv_test13);
        iv_test14 = (ImageView) findViewById(R.id.iv_test14);
        iv_test15 = (ImageView) findViewById(R.id.iv_test15);
    }

    private void load() {
        ViewPropertyTransition.Animator animationObject = new ViewPropertyTransition.Animator() {
            @Override
            public void animate(View view) {
                view.setAlpha( 0f );

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
                fadeAnim.setDuration( 52500 );
                fadeAnim.start();
            }
        };

        ImageLoader.with(this)
                .url(URL2)
//                .animate(android.R.anim.slide_in_left)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.CENTER_CROP)
                .into(iv_test1);

        ImageLoader.with(this)
                .url(URL1)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test2);

//        ImageLoader.with(this)
//                .url(URL2)
//                .placeHolder(R.mipmap.ic_launcher)
//                .scale(ScaleMode.FIT_CENTER)
//                .into(iv_test3);

        GlideApp.with(this).asGif().placeholder(R.mipmap.ic_launcher).transform(new SepiaFilterTransformation()).circleCrop().load(URL4).diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(iv_test3);

        ImageLoader.with(this)
                .url(URL4)
                .placeHolder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test4);

        ImageLoader.with(this)
                .url(URL3)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test5);

        ImageLoader.with(this)
                .url(URL5)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test6);

        ImageLoader.with(this)
                .res(R.drawable.ads)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test7);

        ImageLoader.with(this)
                .res(R.drawable.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .toonFilter()
                .into(iv_test8);

        ImageLoader.with(this)
                .res(R.drawable.b000)
                .vignetteFilter()
                .priority(PriorityMode.PRIORITY_NORMAL)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
//                .ignoreCertificateVerify()
                .into(iv_test9);

        ImageLoader.with(this)
                .res(R.drawable.b000)
                .sketchFilter()
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test10);

//        ImageLoader.with(this)
//                .content("content://media/external/images/media/"+getContentId())
//                .placeHolder(R.mipmap.ic_launcher)
//                .scale(ScaleMode.FIT_CENTER)
//                .into(iv_test10);

        ImageLoader.with(this)
                .file("file://"+ Environment.getExternalStorageDirectory().getPath()+FOREWARD_SLASH+IMG_NAME)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test11);


        ImageLoader.with(this)
                .file(new File(getFilesDir(), IMG_NAME_C))
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .into(iv_test12);

        ImageLoader.with(this)
                .asserts(ASSERTS_PATH+IMG_NAME_C)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .rectRoundCorner(50)
                .into(iv_test13);

        ImageLoader.with(this)
                .raw(ANDROID_RESOURCE+getPackageName()+RAW+R.raw.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .asCircle()
                .into(iv_test14);

        ImageLoader.with(this)
                .raw(ANDROID_RESOURCE+getPackageName()+RAW+R.raw.jpeg_test)
                .placeHolder(R.mipmap.ic_launcher)
                .scale(ScaleMode.FIT_CENTER)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .asSquare()
                .into(iv_test15);

        ImageLoader.saveImageIntoGallery(new DownLoadImageService(SimpleActivity.this, URL3, true, "lala", new ImageDownLoadCallBack() {

            @Override
            public void onDownLoadSuccess(Bitmap bitmap) {
                Log.e(TAG, "下载图片成功 bitmap");
            }

            @Override
            public void onDownLoadFailed() {
                Log.e(TAG, "下载图片失败");
            }

        }));
    }

    public long getContentId(){
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        long aLong = 0;
        if (cursor != null && cursor.moveToFirst()) {
            aLong = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        }

        return aLong;
    }


}
