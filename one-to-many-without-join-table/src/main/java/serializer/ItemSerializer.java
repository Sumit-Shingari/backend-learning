package serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import data.model.ItemMaster;

public class ItemSerializer extends StdSerializer<ItemMaster> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemSerializer() {
		this(null);
	}

	public ItemSerializer(Class<ItemMaster> t) {
		super(t);
	}

	@Override
	public void serialize(ItemMaster value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("idItem", value.getIdItem());
		jgen.writeStringField("itemName", value.getItemName());
		jgen.writeStringField("description", value.getDescription());
		jgen.writeNumberField("idOrder", value.getOrder().getIdOrder());
		jgen.writeStringField("orderDescription", value.getOrder().getOrderDescription());
		jgen.writeEndObject();
	}
}
