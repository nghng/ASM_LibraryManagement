package fa.training.repository;

import fa.training.model.Publication;
import fa.training.model.YearAndPublisher;

import java.util.List;
import java.util.Map;

public interface IPublicationRepository {
    Map<YearAndPublisher, List<Publication>> filterSameYearAndPublisher(List<Publication> publications);

}
