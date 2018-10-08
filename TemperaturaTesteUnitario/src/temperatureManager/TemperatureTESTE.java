package temperatureManager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemperatureTESTE {

	Temperature temperature;
	@Before
	
	public void setUp() throws Exception {
		temperature = new Temperature();
	}
	
	@Test
	public void shouldConvertCelsiusToFarenheit() {
		assertEquals(23, temperature.celsiusParaFarenheit(-5), 0.1);
		assertEquals(32, temperature.celsiusParaFarenheit(0), 0.1);
		assertEquals(64.40, temperature.celsiusParaFarenheit(18), 0.1);
	}

	@Test
	public void shouldConvertCelsiusToKelvin() {
		assertEquals(268.150, temperature.celsiusParaKelvin(-5), 0.1);
		assertEquals(273.150, temperature.celsiusParaKelvin(0), 0.1);
		assertEquals(291.150, temperature.celsiusParaKelvin(18), 0.1);
	}

	@Test
	public void shouldClassifyTemperature() {
		assertEquals("NEGATIVA", temperature.classificaTemperatura(-5));
		assertEquals("ZERO", temperature.classificaTemperatura(0));
		assertEquals("POSITIVA", temperature.classificaTemperatura(18));
	}

	@Test
	public void shouldValidateConversionCelsiusToFarenheit() {
		assertTrue(temperature.validaConversaoCelsiusFarenheit(-5, 23));
	}
}