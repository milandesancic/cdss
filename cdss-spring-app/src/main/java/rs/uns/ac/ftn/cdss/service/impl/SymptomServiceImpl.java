package rs.uns.ac.ftn.cdss.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.uns.ac.ftn.cdss.CdssSpringAppApplication;
import rs.uns.ac.ftn.cdss.model.Disease;
import rs.uns.ac.ftn.cdss.model.Symptom;
import rs.uns.ac.ftn.cdss.repository.SymptomRepository;
import rs.uns.ac.ftn.cdss.service.SymptomService;

@Service
public class SymptomServiceImpl implements SymptomService {

	@Autowired
	SymptomRepository symptomRepository;

	@Override
	public Symptom findById(Long id) {
		return this.symptomRepository.getOne(id);
	}

//	@Override
//	public Collection<Symptom> getAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ArrayList<Symptom> getSymptomsByDisease(Disease disease, String username) {

		KieSession kieSession = (KieSession) CdssSpringAppApplication.kieSessions.get(username);
		if (kieSession != null) {
			QueryResults results = kieSession.getQueryResults("disease symptoms", new Object[] { disease });
			System.out.println("we have " + results.size());

			Map<Symptom, Long> map = new HashMap<>();
			for (QueryResultsRow row : results) {
				System.err.println("usao u ovo");
				Collection<Symptom> generalSymptoms = (Collection<Symptom>) row.get("generalSymptoms");
				Collection<Symptom> specificSymptoms = (Collection<Symptom>) row.get("specificSymptoms");
				for (Symptom s : generalSymptoms) {
					map.put(s, 1L);
				}
				for (Symptom s : specificSymptoms) {
					map.put(s, 2L);
				}
			}
			ArrayList<Symptom> relatedSymptoms = new ArrayList<>();
			Map<Symptom, Long> result = map.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
							LinkedHashMap::new));
			for (Symptom ss : result.keySet()) {
				relatedSymptoms.add(ss);
			}
			return relatedSymptoms;
		}
		// ne postoji sesija
		return null;

	}

}