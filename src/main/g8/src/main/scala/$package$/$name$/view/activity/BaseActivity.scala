package $package$.$name$.view.activity

import android.app.Activity
import $package$.$name$.util.{LogTag, DevLog}

class BaseActivity extends Activity with LogTag {
  implicit val context = this
  
}