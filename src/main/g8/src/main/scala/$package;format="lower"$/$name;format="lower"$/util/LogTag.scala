package $package$.$name;format="Camel"$.util

import android.util.Log
import $package$.$name;format="Camel"$.BuildConfig

trait LogTag {
  implicit final val TAG = this.getClass.getSimpleName
}

object DevLog {
  def e(msg:String)(implicit TAG:String): Unit = {
    if(BuildConfig.DEBUG) Log.e(TAG, msg)
  }
}
