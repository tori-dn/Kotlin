package ua.kpi.practical_example_1.composables

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun GasPowerAppLevel3() {
    // Стан для поточної потужності ТЕС та витрати природного газу
    var thermalPower by remember { mutableStateOf(500) }
    var gasConsumption by remember { mutableStateOf(110) }

    val animatedPower by animateIntAsState(
        targetValue = thermalPower,
        label = "ThermalPowerAnimation"
    )
    val animatedGas by animateIntAsState(
        targetValue = gasConsumption,
        label = "GasConsumptionAnimation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "ТЕС на природному газі",
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Поточна потужність: $animatedPower МВт",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Витрата газу: $animatedGas тис. м³/год",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            thermalPower = Random.nextInt(300, 1200)
            gasConsumption = (thermalPower * 0.22).toInt()
        }) {
            Text("Оновити моніторинг")
        }
    }
}