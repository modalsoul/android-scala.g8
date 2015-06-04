package $package$.$name;format="Camel"$.util

class Loan[T <: {def close()}] private (value: T) {
  def foreach[U](f: T => U): U = try {
    f(value)
  } finally {
    value.close()
  }
}

object Loan {
  def apply[T <: {def close()}](value: T) = new Loan(value)
}