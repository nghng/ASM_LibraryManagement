package fa.training.service;

import fa.training.model.Magazine;
import fa.training.model.Publication;
import fa.training.repository.IMagazineRepository;
import fa.training.repository.impl.MagazineRepositoryImpl;
import fa.training.view.View;

import java.util.List;

public class MagazineService {
    private static MagazineService instance;
    public static IMagazineRepository magazineRepository = new MagazineRepositoryImpl();

    public static MagazineService getInstance() {
        if (instance == null) {
            instance = new MagazineService();
        }
        return instance;
    }

    public void addMagazine(List<Publication> publications) {
        Magazine magazine = View.getInstance().inputMagazine();
        System.out.println(magazineRepository.addMagazine(publications, magazine) ? "Add Success" : "Add Fail");
    }

    public void findTopNVolumeMagazine(List<Publication> publications, int n) {
        if (publications.isEmpty()) {
            System.out.println("There is no publications recorded");
        }
        magazineRepository.findTopNVolume(publications, n).forEach(System.out::println);
    }
}
