package discussion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

	public int add(int x, int y) {
		int resultAdd = x + y;

		logger.info("Result: " + resultAdd);

		return resultAdd;
	}

}
