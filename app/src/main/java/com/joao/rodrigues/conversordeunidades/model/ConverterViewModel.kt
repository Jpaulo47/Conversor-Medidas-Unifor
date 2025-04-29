package com.joao.rodrigues.conversordeunidades.model

import kotlin.math.roundToInt

class ConverterViewModel {

    private var fromUnit: UnitType = UnitType.METERS
    private var toUnit: UnitType = UnitType.KILOMETERS

    fun setFromUnit(unit: UnitType) {
        fromUnit = unit
    }

    fun setToUnit(unit: UnitType) {
        toUnit = unit
    }

    fun getFromUnit(): UnitType = fromUnit

    fun getToUnit(): UnitType = toUnit

    fun convert(value: Double): Double {
        val valueInMeters = when (fromUnit) {
            UnitType.MILLIMETERS -> value / 1000
            UnitType.CENTIMETERS -> value / 100
            UnitType.METERS -> value
            UnitType.KILOMETERS -> value * 1000
            UnitType.MICROMETERS -> value / 1000000
            UnitType.NANOMETERS -> value / 1000000000
            UnitType.MILES -> value * 1609.34
            UnitType.YARDS -> value * 0.9144
            UnitType.FEET -> value * 0.3048
            UnitType.INCHES -> value * 0.0254
            UnitType.NAUTICAL_MILES -> value * 1852
        }

        val result = when (toUnit) {
            UnitType.MILLIMETERS -> valueInMeters * 1000
            UnitType.CENTIMETERS -> valueInMeters * 100
            UnitType.METERS -> valueInMeters
            UnitType.KILOMETERS -> valueInMeters / 1000
            UnitType.MICROMETERS -> valueInMeters * 1000000
            UnitType.NANOMETERS -> valueInMeters * 1000000000
            UnitType.MILES -> valueInMeters / 1609.34
            UnitType.YARDS -> valueInMeters / 0.9144
            UnitType.FEET -> valueInMeters / 0.3048
            UnitType.INCHES -> valueInMeters / 0.0254
            UnitType.NAUTICAL_MILES -> valueInMeters / 1852
        }

        return (result * 100).roundToInt() / 100.0
    }
}

enum class UnitType(val displayName: String) {
    MILLIMETERS("Milímetro"),
    CENTIMETERS("Centímetro"),
    METERS("Metro"),
    KILOMETERS("Quilômetro"),
    MICROMETERS("Micrômetro"),
    NANOMETERS("Nanômetro"),
    MILES("Milha"),
    YARDS("Jarda"),
    FEET("Pé"),
    INCHES("Polegada"),
    NAUTICAL_MILES("Milha náutica")
}
