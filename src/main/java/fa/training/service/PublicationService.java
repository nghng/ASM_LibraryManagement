package fa.training.service;

import fa.training.model.Publication;
import fa.training.model.YearAndPublisher;
import fa.training.repository.IPublicationRepository;
import fa.training.repository.impl.PublicationRepositoryImpl;

import java.util.List;
import java.util.Map;

public class PublicationService {
    private static PublicationService instance;
    public static IPublicationRepository publicationRepository = new PublicationRepositoryImpl();

    public static PublicationService getInstance() {
        if (instance == null) {
            instance = new PublicationService();
        }
        return instance;
    }

    public void displayMagazineAndBookHavingTheSamePublicationYearAndPublisher(List<Publication> publications){
        Map<YearAndPublisher, List<Publication>> group = publicationRepository
                .filterSameYearAndPublisher(publications);
        if(group.isEmpty()){
            System.out.println("There is no books and magazines that have the " +
                    "same publication year and publisher.");
            return;
        }
        group.entrySet().forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));
    }
}
