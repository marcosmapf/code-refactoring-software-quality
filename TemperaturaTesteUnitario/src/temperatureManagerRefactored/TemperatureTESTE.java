package temperatureManagerRefactored;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureTESTE {

	@Test
	public void shouldConvertCelsiusToFarenheit() {
		assertEquals(23, Temperature.convertCelsiusToFarenheit(-5), 0.1);
		assertEquals(32, Temperature.convertCelsiusToFarenheit(0), 0.1);
		assertEquals(64.40, Temperature.convertCelsiusToFarenheit(18), 0.1);
	}

	@Test
	public void shouldConvertCelsiusToKelvin() {
		assertEquals(268.150, Temperature.convertCelsiusToKelvin(-5), 0.1);
		assertEquals(273.150, Temperature.convertCelsiusToKelvin(0), 0.1);
		assertEquals(291.150, Temperature.convertCelsiusToKelvin(18), 0.1);
	}

	@Test
	public void shouldClassifyTemperature() {
		assertEquals("NEGATIVA", Temperature.classifyTemperature(-5));
		assertEquals("ZERO", Temperature.classifyTemperature(0));
		assertEquals("POSITIVA", Temperature.classifyTemperature(18));
	}

	@Test
	public void shouldValidateConversionCelsiusToFarenheit() {
		assertTrue(Temperature.validateConversionCelsiusToFarenheit(-5, 23));
	}
}