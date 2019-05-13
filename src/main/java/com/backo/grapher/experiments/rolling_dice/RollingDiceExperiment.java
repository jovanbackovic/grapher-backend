package com.backo.grapher.experiments.rolling_dice;

import java.util.HashMap;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.backo.grapher.experiments.Experiment;
import com.backo.grapher.experiments.ExperimentResult;
import com.backo.grapher.experiments.NoParamsException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString(exclude = "NUMBER_OF_SIDES_ON_A_DICE")
public class RollingDiceExperiment implements Experiment{

	private final int NUMBER_OF_SIDES_ON_A_DICE = 6;
	
	private @Getter @Setter Integer numberOfRolls;
	private @Getter @Setter Integer  numberOfDices;
	private @Getter HashMap<Integer, Integer> resultsMap;
	
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public RollingDiceExperiment rollingDiceExperimentBean() {
		return new RollingDiceExperiment();
	}
	
	
	@Override
	public ExperimentResult execute() throws NoParamsException {
		if(numberOfDices == null || numberOfRolls == null) throw new NoParamsException("No parameters for dice rolling experiment");
		resultsMap = new HashMap<Integer, Integer>();
		for(int roll = 0; roll < numberOfRolls; roll++) {
			Random diceRoller = new Random();
			int result = 0;
			for(int dice = 0; dice < numberOfDices; dice++) {
				result += diceRoller.nextInt(NUMBER_OF_SIDES_ON_A_DICE) + 1;
			}
			Integer storedValue = resultsMap.get(result);
			if(storedValue != null) {
				resultsMap.put(result, ++storedValue);
			} else {
				resultsMap.put(result, 0);
			}
		}
		return new ExperimentResult(resultsMap);
		
	}
	
	
}
