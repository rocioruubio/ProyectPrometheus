package com.prometheus.ProyectoPrometheus;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class testController {
private Counter counter;
	
	public testController(MeterRegistry registry) {
		this.counter = Counter.builder("invocaciones.hello").description("Invocaciones totales").register(registry);
	}
	
	@GetMapping("/testcontroller")
	public String helloWorld() {
		counter.increment();
		return "soy Rocio";
	}
}
