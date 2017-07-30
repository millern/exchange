package io.millern.exchange;

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class RateController {

  @GetMapping("/mock_rates")
  fun doThing(@RequestParam(value = "from_currency", defaultValue = "USD") fromCurrency: String,
              @RequestParam(value = "to_currency", defaultValue = "GBP") toCurrency: String): Map<LocalDate, Double> {
    val map = hashMapOf<LocalDate, Double>()
    val from = LocalDate.of(2017, 7, 15).minusDays(30)
    var initialRate = 1.234564
    for ( i in 1..30) {
      initialRate += Math.random() * 0.01 - 0.005
      map.put(from.plusDays(i.toLong()), initialRate)
    }
    return map
  }

}
