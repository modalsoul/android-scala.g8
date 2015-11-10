package $package$.$name;format="lower"$.view.activity

import android.app.Activity
import $package$.$name;format="Camel"$.util.{LogTag, DevLog}

class BaseActivity extends Activity with LogTag {
  implicit val context = this
  
}