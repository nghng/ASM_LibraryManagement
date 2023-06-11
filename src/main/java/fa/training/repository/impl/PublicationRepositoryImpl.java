package fa.training.repository.impl;

import fa.training.model.Publication;
import fa.training.model.YearAndPublisher;
import fa.training.repository.IPublicationRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PublicationRepositoryImpl implements IPublicationRepository {

	@Override
	public Map<YearAndPublisher, List<Publication>> filterSameYearAndPublisher(List<Publication> publications) {
        return publications.stream()
                .collect(Collectors.groupingBy(p -> new YearAndPublisher(p.getPublicationYear(), p.getPublisher())))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1  && entry.getValue().stream().map(Publication::getClass).distinct().count() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	}

}
