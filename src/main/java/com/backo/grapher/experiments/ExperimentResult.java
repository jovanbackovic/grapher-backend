package com.backo.grapher.experiments;

import java.util.HashMap;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExperimentResult {
	private @NonNull HashMap<Integer, Integer> graphData;

}
