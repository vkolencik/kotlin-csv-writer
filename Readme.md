Toy CSV generator example for showcasing Kotlin's DSL capability.

Example usage:
```kotlin
FileWriter(path).use {
    csv(it) {
        line {
            cell("Column 1")
            cell("Column 2")
            cell("Column 3")
        }
        
        someData.map {
            line {
                cell(it.value1)
                cell(it.value2)
                cell(it.decimalValue, 3) // three decimal places
            }
        }   
        
        line {
            cell(sum1)
            cell(sum2)
            cell(sum3)
        }
    }
}
```

Uses `"` as text delimiter, `;` as column separator and CRLF as line separator.
