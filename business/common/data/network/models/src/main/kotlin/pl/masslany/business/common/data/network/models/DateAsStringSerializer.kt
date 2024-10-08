package pl.masslany.business.common.data.network.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.SimpleDateFormat
import java.util.Date

object DateAsStringSerializer : KSerializer<Date?> {
    @Suppress("SimpleDateFormat")
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

    override fun serialize(
        encoder: Encoder,
        value: Date?,
    ) = encoder.encodeString(dateFormat.toLocalizedPattern())

    override fun deserialize(decoder: Decoder): Date = dateFormat.parse(decoder.decodeString())
}
