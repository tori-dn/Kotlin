package ua.kpi.practical_example_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ua.kpi.practical_example_1.composables.DisplayModeSelector
import ua.kpi.practical_example_1.composables.GasPowerAppLevel1
import ua.kpi.practical_example_1.composables.GasPowerAppLevel2
import ua.kpi.practical_example_1.composables.GasPowerAppLevel3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Стан для вибору поточного рівня складності
                var displayFor by remember { mutableStateOf(DisplayFor.BASIC_LEVEL) }

                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        // Перемикач режимів відображення
                        DisplayModeSelector(
                            selected = displayFor,
                            onSelectedChange = { displayFor = it }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        // Відображення екрану залежно від обраного рівня
                        when (displayFor) {
                            DisplayFor.BASIC_LEVEL -> GasPowerAppLevel1()
                            DisplayFor.MIDDLE_LEVEL -> GasPowerAppLevel2()
                            DisplayFor.ADVANCED_LEVEL -> GasPowerAppLevel3()
                        }
                    }
                }
            }
        }
    }
}