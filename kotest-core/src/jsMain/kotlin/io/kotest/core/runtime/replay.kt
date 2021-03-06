package io.kotest.core.runtime

actual suspend fun replay(
   times: Int,
   threads: Int,
   before: suspend (Int) -> Unit,
   after: suspend (Int) -> Unit,
   action: suspend (Int) -> Unit
) {
   require(threads == 1) { "Cannot run JS tests on multiple threads. Use the built in kotlin function repeat" }
   repeat(times) {
      before(it)
      action(it)
      after(it)
   }
}
