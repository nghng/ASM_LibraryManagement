package fa.training.repository.impl;

import fa.training.model.Magazine;
import fa.training.model.Publication;
import fa.training.repository.IMagazineRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MagazineRepositoryImpl implements IMagazineRepository {

	@Override
	public boolean addMagazine(List<Publication> publications, Magazine magazine) {
		return publications.add(magazine);
	}

	@Override
	public List<Magazine> findTopNVolume(List<Publication> publications, int n) {
		List<Magazine> magazines = publications.stream()
				.filter(p -> p instanceof Magazine)
				.map(p -> (Magazine) p)
				.sorted(Comparator.comparingInt(Magazine::getVolume).reversed())
				.limit(n)
				.collect(Collectors.toList());
		return magazines;


	}
}