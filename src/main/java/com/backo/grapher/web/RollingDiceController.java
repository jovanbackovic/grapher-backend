package com.backo.grapher.web;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backo.grapher.experiments.ExperimentResult;
import com.backo.grapher.experiments.NoParamsException;
import com.backo.grapher.experiments.rolling_dice.*;

@RestController
@RequestMapping("/dice")
public class RollingDiceController {

	@Resource(name = "rollingDiceExperimentBean")
    RollingDiceExperiment rollingDiceExperiment;
	
    @CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/roll")
	public ResponseEntity<ExperimentResult> executeExperiment(@RequestParam(name = "rolls",defaultValue = "100") int numberOfRolls,  
			@RequestParam(name = "dices", defaultValue = "2") int numberOfDices){
    	rollingDiceExperiment.setNumberOfDices(numberOfDices);
    	rollingDiceExperiment.setNumberOfRolls(numberOfRolls);
    	ExperimentResult result;
		try {
			result = rollingDiceExperiment.execute();
			return ResponseEntity.ok().body(result);

		} catch (NoParamsException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
}
