package $package$.$name;format="Camel"$

import android.content.Context
import android.view.View
import android.widget.{Button, TextView}

package object view {
  /**
   * 対象から指定IDに該当するA型のViewを返す
   * @param self
   * @param id
   * @tparam S
   * @tparam V
   * @return
   */
  def findAViewById[S <: { def findViewById(id:Int):View }, V <: View](self:S, id:Int):Option[V] = {
    Option(self.findViewById(id)).map(_.asInstanceOf[V])
  }

  def buttonById[S <: { def findViewById(id:Int):View }](self:S, id:Int):Option[Button] = {
    findAViewById[S, Button](self, id)
  }

  def textById[S <: { def findViewById(id:Int):View }](self:S, id:Int):Option[TextView] = {
    findAViewById[S, TextView](self, id)
  }
}